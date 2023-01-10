package uk.ac.aber.dcs.cs31620.languageapp.ui.quiz

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import uk.ac.aber.dcs.cs31620.languageapp.model.Results
import uk.ac.aber.dcs.cs31620.languageapp.model.Word
import uk.ac.aber.dcs.cs31620.languageapp.model.WordLanguageViewModel
import uk.ac.aber.dcs.cs31620.languageapp.ui.components.QuizResults
import uk.ac.aber.dcs.cs31620.languageapp.ui.components.TopLevelScaffold
import uk.ac.aber.dcs.cs31620.languageapp.ui.navigation.Screen
import kotlin.math.min

/**
 * The scramble quiz screen.
 *
 * This function displays a scramble quiz and allows the user to solve it.
 *
 * @param navController The navigation controller for the app.
 */
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "NotConstructor")
@Composable
fun ScrambleQuizScreen(navController : NavHostController) {

    // Accessing the databases
    val viewModel: WordLanguageViewModel = viewModel()
    val allWords : LiveData<List<Word>> = viewModel.allWords

    // Storing the data
    val wordsToUse = remember { mutableStateOf<List<Word>?>(null) }
    val wordObserve = allWords.observeAsState()

    // Resetting the words when screen is opened
    LaunchedEffect(Unit) {
        wordsToUse.value = null
    }

    // Gets new live data and shuffles it, takes 10 or all the words, whichever is less
    if (wordsToUse.value == null) {
        wordsToUse.value = wordObserve.value?.shuffled()
            ?.take(min(10, allWords.value?.size ?: 0))
    }

    // Stores which question the quiz is on
    val currentIndex = remember { mutableStateOf(0)}
    // Stores the current word
    var currentWord = wordsToUse.value?.get(currentIndex.value)
    // Stores the users answer
    val userAnswer = remember { mutableStateOf("") }

    // Stores the score
    val score = remember { mutableStateOf(0) }
    // Stores the state of the quiz
    val quizFinished = remember { mutableStateOf(false) }

    // Shuffles the letters of the current word
    var shuffledWord = currentWord?.foreignWord
    var counter = 0
    while (shuffledWord == currentWord?.foreignWord && counter < 100) {
        shuffledWord = currentWord?.foreignWord?.toList()?.shuffled()?.joinToString("")
        counter++
    }

    TopLevelScaffold(
        navController = navController,
        titleName = "Scramble Quiz"
    ){  innerPadding ->
        Surface(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Column {

                if(quizFinished. value) {
                    // Result screen
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
                        text = "What is this unscrambled?",
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
                    ){
                            Text(
                                text = shuffledWord.toString(),
                                textAlign = TextAlign.Center,
                                style = TextStyle(fontSize = 18.sp, color = MaterialTheme.colorScheme.onBackground),
                                modifier = Modifier
                                    .padding(16.dp)
                                    .fillMaxWidth()
                            )
                    }

                    Text(
                        text = "${currentIndex.value + 1} of ${wordsToUse.value?.size ?: 0}",
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontSize = 18.sp,
                            color = MaterialTheme.colorScheme.onBackground),
                        modifier = Modifier.fillMaxWidth()
                    )

                    TextField(
                        value = userAnswer.value,
                        onValueChange = { userAnswer.value = it },
                        label = { Text("Enter your answer here") },
                        modifier = Modifier
                            .padding(top = 24.dp, bottom = 16.dp, start = 16.dp, end = 16.dp)
                            .fillMaxWidth()
                    )

                    Button(
                        onClick = {
                            if (userAnswer.value.equals(currentWord?.foreignWord, ignoreCase = true)){
                                score.value++
                            }

                            if(currentIndex.value == (wordsToUse.value?.size ?: 0) - 1){
                                quizFinished.value = true
                                viewModel.insertResults(Results(0, "Scramble Quiz", "${score.value}/${wordsToUse.value?.size}"))
                            } else {
                                currentIndex.value++
                                currentWord = wordsToUse.value?.get(currentIndex.value)
                            }

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
