package uk.ac.aber.dcs.cs31620.languageapp.ui.quiz

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import uk.ac.aber.dcs.cs31620.languageapp.R
import uk.ac.aber.dcs.cs31620.languageapp.model.Language
import uk.ac.aber.dcs.cs31620.languageapp.model.Word
import uk.ac.aber.dcs.cs31620.languageapp.model.WordLanguageViewModel
import uk.ac.aber.dcs.cs31620.languageapp.ui.components.TopLevelScaffold
import uk.ac.aber.dcs.cs31620.languageapp.ui.navigation.Screen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "NotConstructor")
@Composable
fun QuizScreen(navController : NavHostController){

    val viewModel: WordLanguageViewModel = viewModel()
    val allLanguages: LiveData<List<Language>> = viewModel.allLanguages
    val language = allLanguages.observeAsState().value?.firstOrNull()

    TopLevelScaffold(
        navController = navController,
        titleName = "Quiz"
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Text(text = "Quiz Screen",
                modifier = Modifier.padding(start = 8.dp))

            Button(onClick = {
                if(language != null) {
                    navController.navigate(Screen.TranslationQuiz.route) {
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
                Text("Start Translation Quiz")
            }

        }
    }
}