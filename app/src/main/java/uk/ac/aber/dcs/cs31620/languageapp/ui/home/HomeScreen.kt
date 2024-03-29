package uk.ac.aber.dcs.cs31620.languageapp.ui.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import kotlinx.coroutines.launch
import uk.ac.aber.dcs.cs31620.languageapp.model.Language
import uk.ac.aber.dcs.cs31620.languageapp.model.Results
import uk.ac.aber.dcs.cs31620.languageapp.model.Word
import uk.ac.aber.dcs.cs31620.languageapp.model.WordLanguageViewModel
import uk.ac.aber.dcs.cs31620.languageapp.ui.components.ResultsCard
import uk.ac.aber.dcs.cs31620.languageapp.ui.components.TopLevelScaffold

/**
 * The home screen of the app.
 *
 * This displays a welcome message with some statistics like word count and recent results, or it displays an input for language.
 *
 * @param navController The navigation controller for the app.
 */
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavHostController) {

    // Accessing the databases
    val viewModel: WordLanguageViewModel = viewModel()
    val allLanguages: LiveData<List<Language>> = viewModel.allLanguages
    val allWords: LiveData<List<Word>> = viewModel.allWords
    val allResults: LiveData<List<Results>> = viewModel.allResults

    // Snack bar
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    // Check if there are words in the words database, if not search again
    var numWords = allWords.observeAsState().value?.size
    if (numWords == null) {
        numWords = allWords.observeAsState().value?.size
    }

    // Storing the live data
    var nativeLanguage by remember { mutableStateOf("") }
    var foreignLanguage by remember { mutableStateOf("") }
    val language = allLanguages.observeAsState().value?.firstOrNull()

    // Input validation
    val specialCharactersPattern = "[^\\p{L}\\p{N} ]".toRegex()

    // Creating the welcome text
    val welcomeText = buildAnnotatedString {
        append("Welcome Back To\n Your ")
        withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)) {
            append("${language?.foreignLanguage} ")
        }
        append("Journey")
    }

    TopLevelScaffold(
        navController = navController,
        titleName = "Home"
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Box(modifier = Modifier.fillMaxSize()) {

                // Check if there is a language
                if (language == null) {
                    Column(modifier = Modifier.fillMaxHeight()) {

                        Text(
                            "Native Language:",
                            modifier = Modifier.padding(top = 24.dp, start = 10.dp)
                        )

                        TextField(
                            value = nativeLanguage,
                            onValueChange = { nativeLanguage = it },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                            label = { Text("Native Language") },
                        )

                        Text(
                            "Foreign Language:",
                            modifier = Modifier.padding(top = 24.dp, start = 10.dp)
                        )

                        TextField(
                            value = foreignLanguage,
                            onValueChange = { foreignLanguage = it },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                            label = { Text("Foreign Language") }
                        )

                        Button(
                            onClick = {
                                if (foreignLanguage.isNotEmpty() && nativeLanguage.isNotEmpty() &&
                                    foreignLanguage.length <= 20 && nativeLanguage.length <= 20 &&
                                    !foreignLanguage.contains(specialCharactersPattern) && !nativeLanguage.contains(specialCharactersPattern)) {
                                    viewModel.insertLanguage(
                                        Language(
                                            0,
                                            nativeLanguage,
                                            foreignLanguage
                                        )
                                    )
                                } else {
                                    scope.launch {
                                        snackbarHostState.showSnackbar(
                                            "Input a language less than 20 characters",
                                            withDismissAction = false,
                                            duration = SnackbarDuration.Short
                                        )
                                    }
                                }
                            }, shape = RoundedCornerShape(4.dp), modifier = Modifier
                                .padding(top = 24.dp)
                                .fillMaxWidth()
                                .wrapContentSize(Alignment.Center)
                        ) {
                            Text("Next")
                        }
                    }
                } else {
                    // Display language input
                    Column(modifier = Modifier.fillMaxSize()) {

                        Text(
                            welcomeText,
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Bold),
                            modifier = Modifier
                                .padding(top = 10.dp)
                                .align(Alignment.CenterHorizontally)
                        )

                        Text(
                            "Words learnt: $numWords",
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.headlineMedium,
                            modifier = Modifier
                                .padding(top = 16.dp)
                                .align(Alignment.CenterHorizontally)
                        )

                        if(allResults.observeAsState().value?.size != 0){
                            Text(
                                "Recent Quiz Results",
                                textAlign = TextAlign.Center,
                                style = MaterialTheme.typography.bodyLarge,
                                modifier = Modifier
                                    .padding(top = 70.dp)
                                    .align(Alignment.CenterHorizontally)
                            )

                            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                                allResults.observeAsState().value?.let { list ->
                                    if (list.isNotEmpty()) {
                                        list.reversed().forEach() { result ->
                                            ResultsCard(result.quizName, result.score)
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                SnackbarHost(snackbarHostState, modifier = Modifier.align(Alignment.BottomEnd))
            }
        }
    }
}
