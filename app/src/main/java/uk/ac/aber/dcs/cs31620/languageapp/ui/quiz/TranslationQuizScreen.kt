package uk.ac.aber.dcs.cs31620.languageapp.ui.quiz

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import uk.ac.aber.dcs.cs31620.languageapp.model.Language
import uk.ac.aber.dcs.cs31620.languageapp.model.Results
import uk.ac.aber.dcs.cs31620.languageapp.model.Word
import uk.ac.aber.dcs.cs31620.languageapp.model.WordLanguageViewModel
import uk.ac.aber.dcs.cs31620.languageapp.ui.components.QuizResults
import uk.ac.aber.dcs.cs31620.languageapp.ui.components.TopLevelScaffold
import uk.ac.aber.dcs.cs31620.languageapp.ui.navigation.Screen
import kotlin.math.min
import kotlin.random.Random

/**
 * The translation quiz screen.
 *
 * This function displays a translation quiz and allows the user to solve it.
 *
 * @param navController The navigation controller for the app.
 */
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "NotConstructor",
    "CoroutineCreationDuringComposition"
)
@Composable
fun TranslationQuizScreen(navController : NavHostController) {

    // Accessing the databases
    val viewModel: WordLanguageViewModel = viewModel()
    val allWords: LiveData<List<Word>> = viewModel.allWords
    val allLanguages: LiveData<List<Language>> = viewModel.allLanguages
    val language = allLanguages.observeAsState().value?.firstOrNull()

    // Stores the words
    val wordsToUse = remember { mutableStateOf<List<Word>?>(null) }
    val wordObserve = allWords.observeAsState()

    // Resetting the words when the screen is opened
    LaunchedEffect(Unit) {
        wordsToUse.value = null
    }

    // Gets new live data and shuffles it, takes 10 or all the words, whichever is less
    if (wordsToUse.value == null) {
        wordsToUse.value = wordObserve.value?.shuffled()
            ?.take(min(10, allWords.value?.size ?: 0))
    }

    // Stores the question number
    val currentIndex = remember { mutableStateOf(0) }
    // Stores the current question
    var currentWord = wordsToUse.value?.get(currentIndex.value)
    // Stores the users answer
    val userAnswer = remember { mutableStateOf("") }

    //Stores the score
    val score = remember { mutableStateOf(0) }
    // Stores the state of the quiz
    val quizFinished = remember { mutableStateOf(false) }

    // Randomises the language of the question
    val displayLanguage = if (Random.nextBoolean()) "native" else "foreign"
    val translationLanguage = if (displayLanguage == "native") "foreign" else "native"

    TopLevelScaffold(
        navController = navController,
        titleName = "Translation Quiz"
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Column {

                // Result screen
                if (quizFinished.value) {
                    QuizResults(score.value, wordsToUse.value?.size ?: 0) {
                        navController.navigate(Screen.Quiz.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                } else {

                    // Displays quiz
                    Text(
                        text = "What is this translated into ${if (displayLanguage == "native") language?.foreignLanguage else language?.nativeLanguage}?",
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontSize = 18.sp,
                            color = MaterialTheme.colorScheme.onBackground
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                    )

                    Card(
                        shape = RoundedCornerShape(4.dp),
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                            .height(75.dp)
                            .shadow(4.dp, RoundedCornerShape(4.dp))
                    ) {
                        // Display the current word
                        (if (displayLanguage == "native") currentWord?.nativeWord else currentWord?.foreignWord)?.let {
                            Text(
                                text = it,
                                textAlign = TextAlign.Center,
                                style = TextStyle(
                                    fontSize = 18.sp,
                                    color = MaterialTheme.colorScheme.onBackground
                                ),
                                modifier = Modifier
                                    .padding(16.dp)
                                    .fillMaxWidth()
                            )
                        }
                    }

                    Text(
                        text = "${currentIndex.value + 1} of ${wordsToUse.value?.size ?: 0}",
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontSize = 18.sp,
                            color = MaterialTheme.colorScheme.onBackground
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )

                    // Display the text field for the user to enter their answer
                    TextField(
                        value = userAnswer.value,
                        onValueChange = { userAnswer.value = it },
                        label = { Text("Enter your translation here") },
                        modifier = Modifier
                            .padding(top = 24.dp, bottom = 16.dp, start = 16.dp, end = 16.dp)
                            .fillMaxWidth()
                    )

                    // Display the button to submit the answer
                    Button(
                        onClick = {
                            // Check if the answer is correct and update the score
                            if (userAnswer.value.equals(
                                    (if (translationLanguage == "native") currentWord?.nativeWord else currentWord?.foreignWord),
                                    ignoreCase = true
                                )
                            ) {
                                score.value++
                            }


                            // Check if we have reached the end of the list
                            if (currentIndex.value == (wordsToUse.value?.size ?: 0) - 1) {
                                quizFinished.value = true
                                viewModel.insertResults(
                                    Results(
                                        0,
                                        "Translation Quiz",
                                        "${score.value}/${wordsToUse.value?.size}"
                                    )
                                )

                            } else {
                                // Update the current index and current word
                                currentIndex.value++
                                currentWord = wordsToUse.value?.get(currentIndex.value)

                            }
                            // Reset the user answer
                            userAnswer.value = ""
                        },
                        modifier = Modifier
                            .padding(16.dp)
                            .align(Alignment.CenterHorizontally)
                    ) {
                        Text(text = "Submit")
                    }
                }
            }
        }
    }
}