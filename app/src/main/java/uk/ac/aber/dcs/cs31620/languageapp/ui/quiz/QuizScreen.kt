package uk.ac.aber.dcs.cs31620.languageapp.ui.quiz

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import kotlinx.coroutines.launch
import uk.ac.aber.dcs.cs31620.languageapp.model.Language
import uk.ac.aber.dcs.cs31620.languageapp.model.Word
import uk.ac.aber.dcs.cs31620.languageapp.model.WordLanguageViewModel
import uk.ac.aber.dcs.cs31620.languageapp.ui.components.TopLevelScaffold
import uk.ac.aber.dcs.cs31620.languageapp.ui.navigation.Screen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "NotConstructor",
    "CoroutineCreationDuringComposition"
)
@Composable
fun QuizScreen(navController : NavHostController) {

    val viewModel: WordLanguageViewModel = viewModel()
    val allLanguages: LiveData<List<Language>> = viewModel.allLanguages
    val language = allLanguages.observeAsState().value?.firstOrNull()
    val allWords: LiveData<List<Word>> = viewModel.allWords

    val snackbarHostState = remember { SnackbarHostState()}
    val scope = rememberCoroutineScope()

    var empty = true
    allWords.observeAsState().value?.let { list ->
        if(list.isNotEmpty()){
            if(language != null){
                empty = false
            }
        }
    }

    TopLevelScaffold(
        navController = navController,
        titleName = "Quiz"
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                Column {

                    Button(
                        onClick = {
                            if ((language != null) && !empty) {
                                navController.navigate(Screen.TranslationQuiz.route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            } else if (language == null) {
                                scope.launch {
                                    snackbarHostState.showSnackbar("Input a language", "Dismiss", false, SnackbarDuration.Short)
                                }
                            } else {
                                scope.launch {
                                    snackbarHostState.showSnackbar("Add a word to the word list", "Dismiss", false, SnackbarDuration.Short)
                                }
                            }
                        },
                        shape = RoundedCornerShape(4.dp),
                        modifier = Modifier
                            .padding(top = 32.dp, start = 90.dp, end = 90.dp)
                            .fillMaxWidth()
                            .align(Alignment.CenterHorizontally)
                    ) {
                        Text("Start Translation Quiz")
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        onClick = {
                            if ((language != null) && !empty) {
                                navController.navigate(Screen.ScrambleQuiz.route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            } else if (language == null) {
                                scope.launch {
                                    snackbarHostState.showSnackbar("Input a language", "Dismiss", false, SnackbarDuration.Short)
                                }
                            } else {
                                scope.launch {
                                    snackbarHostState.showSnackbar("Add a word to the word list", "Dismiss", false, SnackbarDuration.Short)
                                }
                            }
                        },
                        shape = RoundedCornerShape(4.dp), modifier = Modifier
                            .padding(top = 32.dp, start = 90.dp, end = 90.dp)
                            .fillMaxWidth()
                            .align(Alignment.CenterHorizontally)
                    ) {
                        Text("Start Scramble Quiz")
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        onClick = {
                            if ((language != null) && !empty) {
                                navController.navigate(Screen.WordMatchQuiz.route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            } else if (language == null) {
                                scope.launch {
                                    snackbarHostState.showSnackbar("Input a language", "Dismiss", false, SnackbarDuration.Short)
                                }
                            } else {
                                scope.launch {
                                    snackbarHostState.showSnackbar("Add a word to the word list", "Dismiss", false, SnackbarDuration.Short)
                                }
                            }
                        },
                        shape = RoundedCornerShape(4.dp), modifier = Modifier
                            .padding(top = 32.dp, start = 90.dp, end = 90.dp)
                            .fillMaxWidth()
                            .align(Alignment.CenterHorizontally)
                    ) {
                        Text("Start Word Match Quiz")
                    }
                }
                SnackbarHost(snackbarHostState, modifier = Modifier.align(Alignment.BottomEnd))
            }
        }
    }
}