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
import uk.ac.aber.dcs.cs31620.languageapp.ui.components.TopLevelScaffold
import uk.ac.aber.dcs.cs31620.languageapp.model.Language
import uk.ac.aber.dcs.cs31620.languageapp.model.Word
import uk.ac.aber.dcs.cs31620.languageapp.model.WordLanguageViewModel
import uk.ac.aber.dcs.cs31620.languageapp.ui.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AddWordScreen(navController: NavHostController) {

    val viewModel: WordLanguageViewModel = viewModel()
    val allLanguages: LiveData<List<Language>> = viewModel.allLanguages
    val language = allLanguages.observeAsState(initial = listOf()).value.firstOrNull() ?: return

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    val nativeLanguage by remember { mutableStateOf(language.nativeLanguage)}
    val foreignLanguage by remember { mutableStateOf(language.foreignLanguage)}
    var nativeWord by remember { mutableStateOf("") }
    var foreignWord by remember { mutableStateOf("") }

    TopLevelScaffold(
        navController = navController,
        titleName = "Add New Word Pair"
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                Column {
                    Text(nativeLanguage, modifier = Modifier.padding(top = 24.dp, start = 10.dp))
                    TextField(
                        value = nativeWord,
                        onValueChange = { nativeWord = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                    )

                    Text(foreignLanguage, modifier = Modifier.padding(top = 24.dp, start = 10.dp))

                    TextField(
                        value = foreignWord,
                        onValueChange = { foreignWord = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                    )

                    //Make the button add the word pair to the database
                    Button(
                        onClick = {
                            if (nativeWord.isNotBlank() && foreignWord.isNotBlank() && nativeWord.length <= 20 && foreignWord.length <= 20) {
                                viewModel.insertWord(Word(0, nativeWord, foreignWord))
                                nativeWord = ""
                                foreignWord = ""
                                navController.navigate(Screen.WordList.route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            } else {
                                scope.launch {
                                    snackbarHostState.showSnackbar(
                                        "Input a word less than 20 characters",
                                        "Dismiss",
                                        false,
                                        SnackbarDuration.Short
                                    )
                                }
                            }
                        },
                        shape = RoundedCornerShape(4.dp), modifier = Modifier
                            .padding(top = 24.dp)
                            .fillMaxWidth()
                            .wrapContentSize(Alignment.Center)
                    ) {
                        Text("Add")
                    }
                }
                SnackbarHost(snackbarHostState, modifier = Modifier.align(Alignment.BottomEnd))
            }
        }
    }
}
