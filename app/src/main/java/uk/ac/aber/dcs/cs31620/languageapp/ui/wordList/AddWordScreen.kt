package uk.ac.aber.dcs.cs31620.languageapp.ui.wordList

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import uk.ac.aber.dcs.cs31620.languageapp.ui.components.TopLevelScaffold
import uk.ac.aber.dcs.cs31620.languageapp.ui.theme.LanguageAppTheme
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
    val language = allLanguages.observeAsState(initial = listOf()).value?.firstOrNull()?: return

    val nativeLanguage by remember { mutableStateOf(language.nativeLanguage ?: "Native Language")}
    val foreignLanguage by remember { mutableStateOf(language.foreignLanguage ?: "Foreign Language")}
    var nativeWord by remember { mutableStateOf("") }
    var foreignWord by remember { mutableStateOf("") }


    TopLevelScaffold(
        navController = navController
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Column(){
                Text(nativeLanguage, modifier = Modifier.padding(top = 24.dp, start = 10.dp))
                TextField(
                    value = nativeWord,
                    onValueChange = { nativeWord = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    //label = { Text("Native Language") }
                )

                Text(foreignLanguage, modifier = Modifier.padding(top = 24.dp, start = 10.dp))
                TextField(
                    value = foreignWord,
                    onValueChange = { foreignWord = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    //label = { Text("Foreign Language") }
                )
                //Make the button add the word pair to the database
                Button(onClick = {
                    if (nativeWord.isNotBlank() || foreignWord.isNotBlank()) {
                        viewModel.insertWord(Word(0, nativeWord, foreignWord))
                        nativeWord = ""
                        foreignWord = ""
                        navController.navigate(Screen.WordList.route){
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                    shape = RoundedCornerShape(4.dp), modifier = Modifier
                        .padding(top = 24.dp)
                        .fillMaxWidth()
                        .wrapContentSize(Alignment.Center)) {
                    Text("Add")
                }
            }
        }
    }
}

@Preview
@Composable
private fun AddWordScreenPreview(){
    val navController = rememberNavController()
    LanguageAppTheme(dynamicColor = false) {
        AddWordScreen(navController)
    }
}