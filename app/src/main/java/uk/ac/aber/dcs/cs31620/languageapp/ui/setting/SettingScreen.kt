package uk.ac.aber.dcs.cs31620.languageapp.ui.setting

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import uk.ac.aber.dcs.cs31620.languageapp.model.ThemeMode
import uk.ac.aber.dcs.cs31620.languageapp.model.WordLanguageViewModel
import uk.ac.aber.dcs.cs31620.languageapp.ui.components.TopLevelScaffold
import uk.ac.aber.dcs.cs31620.languageapp.ui.navigation.Screen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SettingScreen(navController: NavHostController) {

    val viewModel: WordLanguageViewModel = viewModel()
    val allTheme: LiveData<List<ThemeMode>> = viewModel.allTheme
    val getTheme = allTheme.observeAsState().value?.firstOrNull()
    val setTheme = remember { mutableStateOf(getTheme?.isDark)}

    TopLevelScaffold(
        navController = navController,
        titleName = "Settings"
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Column() {
                Text(
                    "This will remove all of the\n vocabulary in the list",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                    modifier = Modifier
                        .padding(top = 24.dp)
                        .wrapContentSize(Alignment.Center)
                        .align(Alignment.CenterHorizontally)
                )
                Button(
                    onClick = {
                        navController.navigate(Screen.SettingConfirmation.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    shape = RoundedCornerShape(4.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentSize(Alignment.Center)
                ) {
                    Text("Reset Language")
                }

                Button(
                    onClick = {
                        if (getTheme != null) {
                            setTheme.value = !getTheme.isDark
                        }
                        setTheme.value?.let { ThemeMode(1, it) }?.let { viewModel.updateTheme(it) }
                        println("SetTheme: ${setTheme.value}")
                        println("GetTheme: ${getTheme?.id} + ${getTheme?.isDark}")
                    },
                    shape = RoundedCornerShape(4.dp),
                    modifier = Modifier
                        .padding(top = 32.dp)
                        .fillMaxWidth()
                        .wrapContentSize(Alignment.Center)
                ){
                    if (getTheme != null) {
                        if(getTheme.isDark){
                            Text("Light Mode")
                        } else{
                            Text("Dark Mode")
                        }
                    }
                }
            }
        }
    }
}
