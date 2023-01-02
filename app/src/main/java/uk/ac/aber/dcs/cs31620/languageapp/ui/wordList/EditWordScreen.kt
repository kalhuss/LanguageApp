package uk.ac.aber.dcs.cs31620.languageapp.ui.wordList

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import uk.ac.aber.dcs.cs31620.languageapp.model.Language
import uk.ac.aber.dcs.cs31620.languageapp.model.Word
import uk.ac.aber.dcs.cs31620.languageapp.model.WordLanguageViewModel
import uk.ac.aber.dcs.cs31620.languageapp.ui.components.TopLevelScaffold
import uk.ac.aber.dcs.cs31620.languageapp.ui.navigation.Screen

//@OptIn(ExperimentalMaterial3Api::class)
//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "NotConstructor")
//@Composable
//fun EditWordScreen(navController : NavHostController, wordID: Int){
//    val viewModel: WordLanguageViewModel = viewModel()
//    val allLanguages: LiveData<List<Language>> = viewModel.allLanguages
//    val language = allLanguages.observeAsState().value?.firstOrNull()
//    val getWord: LiveData<Word> = viewModel.getWordById(wordID)
//
//    val word = getWord.observeAsState().value
//
//    val nativeText = TextFieldValue(word?.nativeWord ?: "")
//    val foreignText = TextFieldValue(word?.foreignWord ?: "")
//
//
//    TopLevelScaffold(
//        navController = navController,
//        titleName = "Edit Word"
//    ) { innerPadding ->
//        Surface(
//            modifier = Modifier
//                .padding(innerPadding)
//                .fillMaxSize()
//        ) {
//            Column() {
//                Text(language?.nativeLanguage ?: "")
//                TextField(word?.nativeWord ?: "",
//                    { word?.nativeWord = it }
//                )
//                Text(language?.foreignLanguage ?: "")
//                TextField(word?.foreignWord ?: "",
//                    {word?.foreignWord = it})
//
//                Button(onClick = { /*TODO*/ }) {
//                    Text(text = "Submit")
//                }
//            }
//
//        }
//    }
//}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "NotConstructor")
@Composable
fun EditWordScreen(navController : NavHostController, wordID: Int){
    val viewModel: WordLanguageViewModel = viewModel()
    val allLanguages: LiveData<List<Language>> = viewModel.allLanguages
    val language = allLanguages.observeAsState().value?.firstOrNull()
    val getWord: LiveData<Word> = viewModel.getWordById(wordID)

    val word = getWord.observeAsState().value

    var nativeText = remember { mutableStateOf(word?.nativeWord)}
    var foreignText = remember { mutableStateOf(word?.foreignWord)}

    if (nativeText.value == null || foreignText.value == null) {
        // Update nativeText and foreignText until they are not null
        nativeText.value = word?.nativeWord
        foreignText.value = word?.foreignWord
    }

    TopLevelScaffold(
        navController = navController,
        titleName = "Edit Word"
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Column() {
                Text(language?.nativeLanguage ?: "", modifier = Modifier.padding(top = 24.dp, start = 10.dp))
                TextField(nativeText.value ?: "",
                    {newValue -> nativeText.value = newValue},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                )
                Text(language?.foreignLanguage ?: "", modifier = Modifier.padding(top = 24.dp, start = 10.dp))
                TextField(
                    foreignText.value ?: "",
                    { newValue -> foreignText.value = newValue },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                )

                Button(onClick = {
                    if (foreignText.value != null && nativeText.value != null) {
                        viewModel.updateWord(Word(wordID, nativeText.value!!, foreignText.value!!))
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
                    Text("Submit Edit")
                }
            }

        }
    }
}
