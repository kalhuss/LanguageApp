@file:Suppress("OPT_IN_IS_NOT_ENABLED")

package uk.ac.aber.dcs.cs31620.languageapp.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import uk.ac.aber.dcs.cs31620.languageapp.R
import uk.ac.aber.dcs.cs31620.languageapp.ui.home.HomeScreen
import uk.ac.aber.dcs.cs31620.languageapp.ui.navigation.Screen
import uk.ac.aber.dcs.cs31620.languageapp.ui.quiz.QuizScreen
import uk.ac.aber.dcs.cs31620.languageapp.ui.setting.SettingScreen
import uk.ac.aber.dcs.cs31620.languageapp.ui.theme.LanguageAppTheme
import uk.ac.aber.dcs.cs31620.languageapp.ui.wordList.WordListScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainPageTopAppBar(navController: NavController, titleName: String){

    TopAppBar(
        title = { Text(text = (titleName)) },
        actions = {
            IconButton(onClick = {navController.navigate(Screen.Setting.route){
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            }}) {
                Icon(
                    imageVector = Icons.Filled.Settings,
                    contentDescription = stringResource(R.string.settings)
                )
            }
        }
    )
}