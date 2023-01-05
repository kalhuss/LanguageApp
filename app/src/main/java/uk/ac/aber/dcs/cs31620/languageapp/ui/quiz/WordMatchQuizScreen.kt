package uk.ac.aber.dcs.cs31620.languageapp.ui.quiz

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import uk.ac.aber.dcs.cs31620.languageapp.model.Language
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
    val allLanguages: LiveData<List<Language>> = viewModel.allLanguages
    val language = allLanguages.observeAsState().value?.firstOrNull()
    val screenOpenedBefore = remember { mutableStateOf(false) }

    val wordsToUse = remember { mutableStateOf<List<Word>?>(null) }
    if (!screenOpenedBefore.value) {
        if (wordsToUse.value == null) {
            val wordsToUseState =
                allWords.observeAsState().value?.toMutableList()
                    ?.shuffled()
                    ?.take(min(6, allWords.value?.size ?: 0))
            wordsToUse.value = wordsToUseState
        }
    }

    val nativeWordID = remember { mutableStateOf(0) }
    val foreignWordID = remember { mutableStateOf(1) }

    var nativeWords = wordsToUse.value?.map { Pair(it.id, it.nativeWord) }
    var foreignWords = wordsToUse.value?.map { Pair(it.id, it.foreignWord) }
    nativeWords = nativeWords?.toMutableList()?.shuffled()
    foreignWords = foreignWords?.toMutableList()?.shuffled()

    println("nativeWords $nativeWords")
    println("foreignWords $foreignWords")

    val nativeButtonState = remember { mutableListOf<MutableState<Boolean>>() }
    val foreignButtonState = remember { mutableListOf<MutableState<Boolean>>() }

    val nativeButtonPressedFirst = remember { mutableStateOf(false) }
    val foreignButtonPressedFirst = remember { mutableStateOf(false) }

    val buttonsDisabled = remember { mutableStateOf(0) }
    val nativeButtonsEnabled = remember { mutableStateOf(true) }
    val foreignButtonsEnabled = remember { mutableStateOf(true) }

    val score = remember { mutableStateOf(0) }
    val quizFinished = remember { mutableStateOf(false) }

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
                Column() {
                    QuizResults(score.value, wordsToUse.value?.size ?: 0) {
                        navController.navigate(Screen.Quiz.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                inclusive = true
                            }
                        }
                    }
                }
            } else {
                Column(modifier = Modifier.verticalScroll(rememberScrollState())){
                    if (nativeWords != null) {
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
                                            nativeButtonPressedFirst.value = true

                                            nativeButtonsEnabled.value = false
                                            foreignButtonsEnabled.value = true

                                            if (nativeWordID.value == foreignWordID.value) {
                                                score.value++
                                                println("Score: ${score.value}")
                                                nativeButtonState[i].value = true
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
                                            foreignButtonPressedFirst.value = true

                                            foreignButtonsEnabled.value = false
                                            nativeButtonsEnabled.value = true

                                            if (nativeWordID.value == foreignWordID.value) {
                                                score.value++
                                                println("Score: ${score.value}")
                                                foreignButtonState[i].value = true
                                            }
                                        },
                                        modifier = Modifier.weight(1f).padding(horizontal = 4.dp),
                                        enabled = !foreignButtonState[i].value && foreignButtonsEnabled.value
                                    ) {
                                        foreignWords?.get(i)?.let { Text(it.second) }
                                    }
                                }
                                if (buttonsDisabled.value == nativeWords.size * 2) {
                                    quizFinished.value = true
                                    viewModel.insertResults(Results(0, "Word Match Quiz", "${score.value}/${wordsToUse.value?.size}"))
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}