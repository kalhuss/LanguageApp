package uk.ac.aber.dcs.cs31620.languageapp.ui.wordList

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
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

/**
 * The screen that allows the user to edit a word.
 *
 * This function displays the details of a word and allows the user to edit a word pair or delete the word pair.
 *
 * @param navController The navigation controller for the app.
 * @param wordID The ID of the word to edit.
 */
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "NotConstructor")
@Composable
fun EditWordScreen(navController : NavHostController, wordID: Int) {

    // Accessing the databases
    val viewModel: WordLanguageViewModel = viewModel()
    val allLanguages: LiveData<List<Language>> = viewModel.allLanguages
    val language = allLanguages.observeAsState().value?.firstOrNull()
    val getWord: LiveData<Word> = viewModel.getWordById(wordID)

    // Storing the words as state variables
    val word = getWord.observeAsState().value

    // Snackbar
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    // Storing the live data
    val nativeText = remember { mutableStateOf(word?.nativeWord) }
    val foreignText = remember { mutableStateOf(word?.foreignWord) }

    // Error handling if null
    if (nativeText.value == null || foreignText.value == null) {
        nativeText.value = word?.nativeWord
        foreignText.value = word?.foreignWord
    }

    // Input validation
    val specialCharactersPattern = "[^\\p{L}\\p{N} ]".toRegex()

    TopLevelScaffold(
        navController = navController,
        titleName = "Edit Word"
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                Column {

                    Text(
                        language?.nativeLanguage ?: "",
                        modifier = Modifier.padding(top = 24.dp, start = 10.dp)
                    )

                    TextField(
                        nativeText.value ?: "",
                        { newValue -> nativeText.value = newValue },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                    )

                    Text(
                        language?.foreignLanguage ?: "",
                        modifier = Modifier.padding(top = 24.dp, start = 10.dp)
                    )

                    TextField(
                        foreignText.value ?: "",
                        { newValue -> foreignText.value = newValue },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .wrapContentSize(Alignment.Center)
                    ) {

                        Button(
                            onClick = {
                                // Update the word pair
                                if (foreignText.value?.isNotBlank() == true && nativeText.value?.isNotBlank() == true &&
                                    foreignText.value!!.length <= 20 && nativeText.value!!.length <= 20 &&
                                    !foreignText.value!!.contains(specialCharactersPattern) && !nativeText.value!!.contains(specialCharactersPattern)) {
                                    viewModel.updateWord(
                                        Word(
                                            wordID,
                                            nativeText.value!!,
                                            foreignText.value!!
                                        )
                                    )
                                    navController.navigate(Screen.WordList.route) {
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                } else{
                                    scope.launch {
                                        snackbarHostState.showSnackbar(
                                            "Input a word less than 20 characters",
                                            withDismissAction = false,
                                            duration = SnackbarDuration.Short
                                        )
                                    }
                                }
                            },
                            shape = RoundedCornerShape(4.dp), modifier = Modifier
                                .padding(top = 24.dp)
                                .padding(horizontal = 8.dp)
                                .wrapContentSize(Alignment.Center)
                        ) {
                            Text("Submit Edit")
                        }

                        Button(
                            onClick = {
                                // Delete the word pair
                                viewModel.deleteWordById(wordID)
                                navController.navigate(Screen.WordList.route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            },
                            shape = RoundedCornerShape(4.dp), modifier = Modifier
                                .padding(top = 24.dp)
                                .padding(horizontal = 8.dp)
                                .wrapContentSize(Alignment.Center)
                        ) {
                            Text("Delete")
                        }
                    }
                }
                SnackbarHost(snackbarHostState, modifier = Modifier.align(Alignment.BottomEnd))
            }
        }
    }
}