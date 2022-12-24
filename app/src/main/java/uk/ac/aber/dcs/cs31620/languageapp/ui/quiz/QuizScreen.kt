package uk.ac.aber.dcs.cs31620.languageapp.ui.quiz

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
//import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import uk.ac.aber.dcs.cs31620.languageapp.ui.components.MainPageNavigationBar
import uk.ac.aber.dcs.cs31620.languageapp.ui.components.MainPageTopAppBar
//import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
//import com.bumptech.glide.integration.compose.GlideImage
import uk.ac.aber.dcs.cs31620.languageapp.ui.components.TopLevelScaffold
import uk.ac.aber.dcs.cs31620.languageapp.ui.theme.LanguageAppTheme

class QuizScreen {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "NotConstructor")
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun QuizScreen(){
        TopLevelScaffold() {
                innerPadding ->
            Surface(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
            ) {
                Text(text = "Quiz Screen",
                    modifier = Modifier.padding(start = 8.dp))
            }
        }
    }

}