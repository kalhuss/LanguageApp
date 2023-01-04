package uk.ac.aber.dcs.cs31620.languageapp.ui.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import uk.ac.aber.dcs.cs31620.languageapp.model.Language
import uk.ac.aber.dcs.cs31620.languageapp.model.Word
import uk.ac.aber.dcs.cs31620.languageapp.model.WordLanguageViewModel
import uk.ac.aber.dcs.cs31620.languageapp.ui.components.TopLevelScaffold

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavHostController) {
    val viewModel: WordLanguageViewModel = viewModel()
    val allLanguages: LiveData<List<Language>> = viewModel.allLanguages
    val allWords: LiveData<List<Word>> = viewModel.allWords

    var numWords = allWords.observeAsState().value?.size
    if(numWords == null){
        numWords = allWords.observeAsState().value?.size
    }

    var nativeLanguage by remember { mutableStateOf("") }
    var foreignLanguage by remember { mutableStateOf("") }
    val language = allLanguages.observeAsState().value?.firstOrNull()

    val welcomeText = buildAnnotatedString {
        append("Welcome Back To\n Your ")
        withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)){
            append("${language?.foreignLanguage} ")
        }
        append("Journey")
    }

    TopLevelScaffold(
        navController = navController,
        titleName  = "Home"
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Column(modifier = Modifier.fillMaxHeight()){
                if (language == null) {
                    Text("Native Language:", modifier = Modifier.padding(top = 24.dp, start = 10.dp))
                    TextField(
                        value = nativeLanguage,
                        onValueChange = { nativeLanguage = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        label = { Text("Native Language") }
                    )

                    Text("Foreign Language:", modifier = Modifier.padding(top = 24.dp, start = 10.dp))
                    TextField(
                        value = foreignLanguage,
                        onValueChange = { foreignLanguage = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        label = { Text("Foreign Language") }
                    )
                    Button(onClick = {
                        viewModel.insertLanguage(Language(0, nativeLanguage, foreignLanguage))
                    }, shape = RoundedCornerShape(4.dp), modifier = Modifier
                        .padding(top = 24.dp)
                        .fillMaxWidth()
                        .wrapContentSize(Alignment.Center)) {
                        Text("Next")
                    }
                } else {
                    Text(
                        welcomeText,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Bold),
                        modifier = Modifier
                            .padding(top = 10.dp)
                            .wrapContentSize(Alignment.Center)
                            .align(Alignment.CenterHorizontally)
                    )
                    Text(
                        "Words learnt: $numWords",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.headlineSmall,
                        modifier = Modifier
                            .padding(top = 16.dp)
                            .wrapContentSize(Alignment.Center)
                            .align(Alignment.CenterHorizontally)
                    )
                }
            }
        }
    }
}
