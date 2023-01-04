package uk.ac.aber.dcs.cs31620.languageapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import uk.ac.aber.dcs.cs31620.languageapp.model.ThemeMode
import uk.ac.aber.dcs.cs31620.languageapp.model.WordLanguageViewModel
import uk.ac.aber.dcs.cs31620.languageapp.ui.home.HomeScreen
import uk.ac.aber.dcs.cs31620.languageapp.ui.navigation.Screen
import uk.ac.aber.dcs.cs31620.languageapp.ui.quiz.QuizScreen
import uk.ac.aber.dcs.cs31620.languageapp.ui.quiz.ScrambleQuizScreen
import uk.ac.aber.dcs.cs31620.languageapp.ui.quiz.TranslationQuizScreen
import uk.ac.aber.dcs.cs31620.languageapp.ui.setting.SettingScreen
import uk.ac.aber.dcs.cs31620.languageapp.ui.setting.SettingConfirmationScreen
import uk.ac.aber.dcs.cs31620.languageapp.ui.theme.LanguageAppTheme
import uk.ac.aber.dcs.cs31620.languageapp.ui.wordList.AddWordScreen
import uk.ac.aber.dcs.cs31620.languageapp.ui.wordList.EditWordScreen
import uk.ac.aber.dcs.cs31620.languageapp.ui.wordList.WordListScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val viewModel: WordLanguageViewModel = viewModel()
            val allTheme: LiveData<List<ThemeMode>> = viewModel.allTheme
            val getTheme = allTheme.observeAsState().value?.firstOrNull()

            if (getTheme != null) {
                LanguageAppTheme(getTheme.isDark)  {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        BuildNavigationGraph()
                    }
                }
            }
        }
    }
}

@Composable
private fun BuildNavigationGraph() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    )
    {
        composable(Screen.Home.route) { HomeScreen(navController) }
        composable(Screen.WordList.route) { WordListScreen(navController) }
        composable(Screen.Quiz.route) { QuizScreen(navController) }
        composable(Screen.Setting.route) { SettingScreen(navController) }
        composable(Screen.SettingConfirmation.route) { SettingConfirmationScreen(navController) }
        composable(Screen.AddWord.route) { AddWordScreen(navController)}
        composable(Screen.EditWord.route){ EditWordScreen(navController, Screen.EditWord.route.substringAfterLast("/").toInt())}
        composable(Screen.TranslationQuiz.route) { TranslationQuizScreen(navController) }
        composable(Screen.ScrambleQuiz.route) { ScrambleQuizScreen(navController) }
    }
}