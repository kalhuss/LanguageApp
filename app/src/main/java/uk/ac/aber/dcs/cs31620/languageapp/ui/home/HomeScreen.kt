package uk.ac.aber.dcs.cs31620.languageapp.ui.home

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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import uk.ac.aber.dcs.cs31620.languageapp.model.Language
import uk.ac.aber.dcs.cs31620.languageapp.model.WordLanguageViewModel
import uk.ac.aber.dcs.cs31620.languageapp.ui.components.TopLevelScaffold
import uk.ac.aber.dcs.cs31620.languageapp.ui.theme.LanguageAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavHostController) {
    val viewModel: WordLanguageViewModel = viewModel()
    val allLanguages: LiveData<List<Language>> = viewModel.allLanguages

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
                val language = allLanguages.observeAsState().value?.firstOrNull()
                if (language == null) {
                    Text("Native Language:", modifier = Modifier.padding(top = 24.dp, start = 10.dp))
                    TextField(
                        value = nativeLanguage,
                        onValueChange = { nativeLanguage = it },
                        modifier = Modifier.fillMaxWidth().padding(10.dp),
                        label = { Text("Native Language") }
                    )

                    Text("Foreign Language:", modifier = Modifier.padding(top = 24.dp, start = 10.dp))
                    TextField(
                        value = foreignLanguage,
                        onValueChange = { foreignLanguage = it },
                        modifier = Modifier.fillMaxWidth().padding(10.dp),
                        label = { Text("Foreign Language") }
                    )
                    Button(onClick = {
                        viewModel.insertLanguage(Language(0, nativeLanguage, foreignLanguage))
                    }, shape = RoundedCornerShape(4.dp), modifier = Modifier.padding(top = 24.dp).fillMaxWidth().wrapContentSize(Alignment.Center)) {
                        Text("Next")
                    }
                } else {
                    Text("You are learning: ${language.foreignLanguage}", modifier = Modifier.padding(top = 24.dp))
                }
            }
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview(){
    val navController = rememberNavController()
    LanguageAppTheme(dynamicColor = false) {
        HomeScreen(navController)
    }
}
