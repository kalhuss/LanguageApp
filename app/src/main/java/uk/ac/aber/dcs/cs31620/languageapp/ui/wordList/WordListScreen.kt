package uk.ac.aber.dcs.cs31620.languageapp.ui.wordList

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
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
import uk.ac.aber.dcs.cs31620.languageapp.ui.components.WordCard
import uk.ac.aber.dcs.cs31620.languageapp.ui.navigation.Screen

@Composable
fun WordListScreen(navController: NavHostController) {
    val viewModel: WordLanguageViewModel = viewModel()
    val allWords: LiveData<List<Word>> = viewModel.allWords
    val allLanguages: LiveData<List<Language>> = viewModel.allLanguages
    val language = allLanguages.observeAsState().value?.firstOrNull()


    val snackbarHostState = remember { SnackbarHostState()}
    val scope = rememberCoroutineScope()

    TopLevelScaffold(
        navController = navController,
        titleName = "Word List"
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
        ) {
            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                allWords.observeAsState().value?.let { list ->
                    if(list.isNotEmpty()){
                        list.forEach{ word ->
                            if (language != null) {
                                WordCard(navController ,word, language)
                            }
                        }
                    }
                }
            }
            Box(modifier = Modifier.fillMaxSize()) {
                FloatingActionButton(
                    onClick = {
                        if (language != null) {
                            navController.navigate(Screen.AddWord.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        } else {
                            scope.launch {
                                snackbarHostState.showSnackbar(
                                    "Input a language",
                                    "Dismiss",
                                    false,
                                    SnackbarDuration.Short
                                )
                            }
                        }
                    },
                    modifier = Modifier
                        .padding(bottom = 16.dp, end = 16.dp)
                        .align(Alignment.BottomEnd),
                    shape = CircleShape,
                    containerColor = MaterialTheme.colorScheme.primary
                ) {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = stringResource(uk.ac.aber.dcs.cs31620.languageapp.R.string.add_word)
                    )
                }

                SnackbarHost(snackbarHostState, modifier = Modifier.align(Alignment.BottomEnd))
            }
        }
    }
}
