package uk.ac.aber.dcs.cs31620.languageapp.ui.quiz

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import uk.ac.aber.dcs.cs31620.languageapp.model.Word
import uk.ac.aber.dcs.cs31620.languageapp.model.WordLanguageViewModel
import uk.ac.aber.dcs.cs31620.languageapp.ui.components.TopLevelScaffold
import uk.ac.aber.dcs.cs31620.languageapp.ui.navigation.Screen
import kotlin.math.min

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "NotConstructor")
@Composable
fun TranslationQuizScreen(navController : NavHostController) {

    val viewModel: WordLanguageViewModel = viewModel()
    val allWords: LiveData<List<Word>> = viewModel.allWords

    val wordsToUse = remember { mutableStateOf<List<Word>?>(null) }
    if (wordsToUse.value == null) {
        val wordsToUseState =
            allWords.observeAsState().value?.shuffled()?.take(min(10, allWords.value?.size ?: 0))
        wordsToUse.value = wordsToUseState
    }

    val currentIndex = remember { mutableStateOf(0) }
    var currentWord = wordsToUse.value?.get(currentIndex.value)
    val userAnswer = remember { mutableStateOf("") }

    val score = remember { mutableStateOf(0) }
    val quizFinished = remember { mutableStateOf(false) }

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
                if (quizFinished.value) {
                    Text(
                        text = "Your score is: ${score.value}/${wordsToUse.value?.size ?: 0}",
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                            .align(Alignment.CenterHorizontally)
                    )

                    Button(
                        onClick = {
                            navController.navigate(Screen.Quiz.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    inclusive = true
                                }
                            }
                        },
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                            .align(Alignment.CenterHorizontally)
                    ) {
                        Text("go back to menu")
                    }
                } else {
                    println("Word List: $wordsToUse")
                    // Display the current word
                    Text(
                        text = currentWord?.nativeWord ?: "",
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                            .align(Alignment.CenterHorizontally)
                    )

                    // Display the text field for the user to enter their answer
                    TextField(
                        value = userAnswer.value,
                        onValueChange = { userAnswer.value = it },
                        label = { Text("Enter your answer here") },
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                            .align(Alignment.CenterHorizontally)
                    )

                    // Display the button to submit the answer
                    Button(
                        onClick = {
                            // Check if the answer is correct and update the score
                            if (userAnswer.value == currentWord?.foreignWord) {
                                score.value++
                            }

                            // Check if we have reached the end of the list
                            if (currentIndex.value == (wordsToUse.value?.size ?: 0) - 1) {
                                quizFinished.value = true
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
                            .fillMaxWidth()
                            .align(Alignment.CenterHorizontally)
                    ) {
                        Text(text = "Submit")
                    }
                }
            }
        }
    }
}


































//@OptIn(ExperimentalMaterial3Api::class)
//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "NotConstructor")
//@Composable
//fun TranslationQuizScreen(navController : NavHostController){
//    val viewModel : WordLanguageViewModel = viewModel()
//    val allWords : LiveData<List<Word>> = viewModel.allWords
//
//    val wordsToUse = allWords.value?.shuffled()?.take(min(10, allWords.value?.size ?: 0))
//
//    TopLevelScaffold(navController = navController, titleName = "Translation Quiz"){ innerPadding ->
//        Surface (
//            modifier = Modifier
//                .padding(innerPadding)
//                .fillMaxSize()
//        ){
//            Column(){
//
//            }
//        }
//    }
//}












