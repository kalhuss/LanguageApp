package uk.ac.aber.dcs.cs31620.languageapp.ui.setting

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import uk.ac.aber.dcs.cs31620.languageapp.model.WordLanguageViewModel
import uk.ac.aber.dcs.cs31620.languageapp.ui.components.TopLevelScaffold
import uk.ac.aber.dcs.cs31620.languageapp.ui.navigation.Screen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SettingConfirmationScreen(navController: NavHostController) {

    val viewModel: WordLanguageViewModel = viewModel()

    TopLevelScaffold(
        navController = navController,
        titleName = "Settings"
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Column {
                Text(
                    "Are you sure\n you want to reset your language?",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                    modifier = Modifier
                        .padding(top = 24.dp)
                        .wrapContentSize(Alignment.Center)
                        .align(Alignment.CenterHorizontally)
                )
                Row(modifier = Modifier
                    .padding(top = 24.dp)
                    .fillMaxWidth()
                    .wrapContentSize(Alignment.Center)) {
                    Button(
                        onClick = {
                            navController.navigate(Screen.Setting.route){
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        shape = RoundedCornerShape(4.dp),
                        modifier = Modifier
                            .padding(horizontal = 8.dp)
                            .wrapContentSize(Alignment.Center)
                    ) {
                        Text("Cancel")
                    }
                    //Onclick deletes all values from word database and language database
                    Button(
                        onClick = {
                            viewModel.deleteAllLanguages()
                            viewModel.deleteAllWords()
                            viewModel.deleteAllResults()
                            navController.navigate(Screen.Home.route){
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        shape = RoundedCornerShape(4.dp),
                        modifier = Modifier
                            .padding(horizontal = 8.dp)
                            .wrapContentSize(Alignment.Center),
                        colors = ButtonDefaults.buttonColors(Color(0, 204, 0))
                    ) {
                        Text("Confirm")
                    }
                }
            }
        }
    }
}
