package uk.ac.aber.dcs.cs31620.languageapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
//import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import uk.ac.aber.dcs.cs31620.languageapp.ui.home.HomeScreen
import uk.ac.aber.dcs.cs31620.languageapp.ui.home.HomeScreenPreview
//import uk.ac.aber.dcs.cs31620.faa.ui.home.HomeScreenTopLevel
import uk.ac.aber.dcs.cs31620.languageapp.ui.navigation.Screen
import uk.ac.aber.dcs.cs31620.languageapp.ui.theme.LanguageAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LanguageAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //BuildNavigationGraph()
                    HomeScreen()
                }
            }
        }
    }
}


//@Composable
//private fun BuildNavigationGraph(){
//    val navController = rememberNavController()
//
//    NavHost(
//        navController = navController,
//        startDestination = Screen.Home.route
//    ) {
//        composable(Screen.Home.route){ HomeScreen (navController) }
//        //composable(Screen.WordList.route){ WordListScreen (navController) }}
//    }
//}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LanguageAppTheme {
        //BuildNavigationGraph()
        HomeScreen()
    }
}