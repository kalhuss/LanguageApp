package uk.ac.aber.dcs.cs31620.languageapp.ui.quiz

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import uk.ac.aber.dcs.cs31620.languageapp.model.Results
import uk.ac.aber.dcs.cs31620.languageapp.model.Word
import uk.ac.aber.dcs.cs31620.languageapp.model.WordLanguageViewModel
import uk.ac.aber.dcs.cs31620.languageapp.ui.components.QuizResults
import uk.ac.aber.dcs.cs31620.languageapp.ui.components.TopLevelScaffold
import uk.ac.aber.dcs.cs31620.languageapp.ui.navigation.Screen
import kotlin.math.min

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "NotConstructor",
    "MutableCollectionMutableState", "UnrememberedMutableState"
)
@Composable
fun WordMatchQuizScreen(navController : NavHostController) {

    val viewModel: WordLanguageViewModel = viewModel()
    val allWords: LiveData<List<Word>> = viewModel.allWords

    val wordsToUse = remember { mutableStateOf<List<Word>?>(null) }
    val wordObserve = allWords.observeAsState()
    LaunchedEffect(Unit) {
        wordsToUse.value = null
    }

    if (wordsToUse.value == null) {
        wordsToUse.value = wordObserve.value?.shuffled()
            ?.take(min(6, allWords.value?.size ?: 0))
    }

    val nativeWordID = remember { mutableStateOf(0) }
    val foreignWordID = remember { mutableStateOf(1) }

    var nativeWords = wordsToUse.value?.map { Pair(it.id, it.nativeWord) }
    var foreignWords = wordsToUse.value?.map { Pair(it.id, it.foreignWord) }
    nativeWords = nativeWords?.toMutableList()?.shuffled()
    foreignWords = foreignWords?.toMutableList()?.shuffled()

    val nativeButtonState = remember { mutableListOf<MutableState<Boolean>>() }
    val foreignButtonState = remember { mutableListOf<MutableState<Boolean>>() }

    val buttonsDisabled = remember { mutableStateOf(0) }
    val nativeButtonsEnabled = remember { mutableStateOf(true) }
    val foreignButtonsEnabled = remember { mutableStateOf(true) }

    val score = remember { mutableStateOf(0) }
    val quizFinished = remember { mutableStateOf(false) }
    val resultsInserted = remember { mutableStateOf(false) }

    TopLevelScaffold(
        navController = navController,
        titleName = "Word Match Quiz"
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            if (quizFinished.value) {
                Column {
                    if(!resultsInserted.value) {
                        viewModel.insertResults(
                            Results(
                                0,
                                "Word Match Quiz",
                                "${score.value}/${wordsToUse.value?.size}"
                            )
                        )
                        resultsInserted.value = true
                        println("results inserted: ${resultsInserted.value}")
                    }

                    QuizResults(score.value, wordsToUse.value?.size ?: 0) {
                        navController.navigate(Screen.Quiz.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                }
            } else {
                Column(modifier = Modifier.verticalScroll(rememberScrollState())){
                    if (nativeWords != null) {
                        Text(
                            text = "Match the words",
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 18.sp,
                                color = MaterialTheme.colorScheme.onBackground
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 8.dp)
                        )
                        for (i in nativeWords.indices) {
                            nativeButtonState.add(mutableStateOf(false))
                            foreignButtonState.add(mutableStateOf(false))
                            Card(
                                modifier = Modifier
                                    .padding(8.dp)
                                    .fillMaxWidth()
                                    .align(Alignment.CenterHorizontally)
                            ) {
                                Row(
                                    modifier = Modifier
                                        .padding(8.dp)
                                        .align(Alignment.CenterHorizontally)
                                        .wrapContentSize(Alignment.Center)
                                ) {
                                    Button(
                                        onClick = {
                                            nativeWordID.value = nativeWords[i].first
                                            nativeButtonState[i].value = true
                                            buttonsDisabled.value++

                                            nativeButtonsEnabled.value = false
                                            foreignButtonsEnabled.value = true

                                            if(buttonsDisabled.value % 2 == 0 && buttonsDisabled.value > 0){
                                                if (nativeWordID.value == foreignWordID.value) {
                                                    score.value++
                                                    nativeButtonState[i].value = true
                                                } else{
                                                    nativeWordID.value = 0
                                                    foreignWordID.value = 0
                                                }
                                            }
                                        },
                                        modifier = Modifier.weight(1f).padding(horizontal = 4.dp),
                                        enabled = !nativeButtonState[i].value && nativeButtonsEnabled.value
                                    ) {
                                        Text(nativeWords[i].second)
                                    }
                                    Button(
                                        onClick = {
                                            foreignWordID.value = foreignWords?.get(i)?.first ?: 0
                                            foreignButtonState[i].value = true
                                            buttonsDisabled.value++

                                            foreignButtonsEnabled.value = false
                                            nativeButtonsEnabled.value = true

                                            if(buttonsDisabled.value % 2 == 0 && buttonsDisabled.value > 0) {
                                                if (nativeWordID.value == foreignWordID.value) {
                                                    score.value++
                                                    foreignButtonState[i].value = true
                                                } else{
                                                    nativeWordID.value = 0
                                                    foreignWordID.value = 0
                                                }
                                            }


                                        },
                                        modifier = Modifier.weight(1f).padding(horizontal = 4.dp),
                                        enabled = !foreignButtonState[i].value && foreignButtonsEnabled.value
                                    ) {
                                        foreignWords?.get(i)?.let { Text(it.second) }
                                    }

                                }
                            }
                        }
                        if (buttonsDisabled.value == nativeWords.size * 2) {
                            quizFinished.value = true
                        }
                    }
                }
            }
        }
    }
}
