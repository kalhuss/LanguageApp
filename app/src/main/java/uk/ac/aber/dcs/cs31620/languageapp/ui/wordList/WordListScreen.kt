package uk.ac.aber.dcs.cs31620.languageapp.ui.wordList

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import uk.ac.aber.dcs.cs31620.languageapp.model.WordPair
import uk.ac.aber.dcs.cs31620.languageapp.model.WordPairViewModel
import uk.ac.aber.dcs.cs31620.languageapp.ui.components.TopLevelScaffold
import uk.ac.aber.dcs.cs31620.languageapp.ui.components.WordCard
import uk.ac.aber.dcs.cs31620.languageapp.ui.navigation.Screen
import uk.ac.aber.dcs.cs31620.languageapp.ui.theme.LanguageAppTheme

@Composable
fun WordListScreen(navController: NavHostController) {
    val viewModel: WordPairViewModel = viewModel()
    val wordPairs: LiveData<List<WordPair>> = viewModel.allWordPairs

    TopLevelScaffold(
        navController = navController
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Column {
                wordPairs.observeAsState().value?.let { list ->
                    if(list.isNotEmpty()){
                        list.drop(1).forEach{ wordPair ->
                            WordCard(wordPair)
                        }
                    }
                }
            }

            FloatingActionButton(
                onClick = {
                    navController.navigate(Screen.AddWord.route){
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                modifier = Modifier
                    .padding(top = 24.dp)
                    .fillMaxWidth()
                    .wrapContentSize(Alignment.Center),
                shape = CircleShape
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = stringResource(uk.ac.aber.dcs.cs31620.languageapp.R.string.add_word))
            }
        }
    }
}






@Preview
@Composable
fun WordListScreenPreview() {
    val navController = rememberNavController()
    LanguageAppTheme(dynamicColor = false) {
        WordListScreen(navController)
    }
}