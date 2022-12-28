package uk.ac.aber.dcs.cs31620.languageapp.ui.wordList

import android.annotation.SuppressLint
import android.app.Application
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.Deferred
import uk.ac.aber.dcs.cs31620.languageapp.datasource.WordPairRepository
import uk.ac.aber.dcs.cs31620.languageapp.model.WordPair
import uk.ac.aber.dcs.cs31620.languageapp.model.WordPairViewModel
import uk.ac.aber.dcs.cs31620.languageapp.ui.components.TopLevelScaffold
import uk.ac.aber.dcs.cs31620.languageapp.ui.theme.LanguageAppTheme
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AddWordScreen(navController: NavHostController) {
    val repository = WordPairRepository(Application())
    val firstWordPair = repository.getFirstWordPair()
    val viewModel: WordPairViewModel = viewModel()



    var nativeLanguageText by remember { mutableStateOf(firstWordPair?.nativeLanguage ?: "Native Language") }
    var foreignLanguageText by remember { mutableStateOf(firstWordPair?.foreignLanguage ?: "Foreign Language") }
    var nativeLanguage by remember { mutableStateOf("") }
    var foreignLanguage by remember { mutableStateOf("") }


    TopLevelScaffold(
        navController = navController
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Column(){
                Text(nativeLanguageText, modifier = Modifier.padding(top = 24.dp, start = 10.dp))
                TextField(
                    value = nativeLanguage,
                    onValueChange = { nativeLanguage = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    label = { Text("Native Language") }
                )

                Text(foreignLanguageText, modifier = Modifier.padding(top = 24.dp, start = 10.dp))
                TextField(
                    value = foreignLanguage,
                    onValueChange = { foreignLanguage = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    label = { Text("Foreign Language") }
                )
                //Make the button add the word pair to the database
                Button(onClick = {viewModel.insertWordPair(WordPair(0, nativeLanguageText, nativeLanguage, foreignLanguageText,foreignLanguage))
                        nativeLanguage = ""
                        foreignLanguage = ""},
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