package uk.ac.aber.dcs.cs31620.languageapp.ui.quiz

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import uk.ac.aber.dcs.cs31620.languageapp.ui.components.TopLevelScaffold

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "NotConstructor")
@Composable
fun ScrambleQuizScreen(navController : NavHostController){
    TopLevelScaffold(
        navController = navController,
        titleName = "Translation Quiz"
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Text(text = "Translation Quiz Screen",
                modifier = Modifier.padding(start = 8.dp))
        }
    }
}