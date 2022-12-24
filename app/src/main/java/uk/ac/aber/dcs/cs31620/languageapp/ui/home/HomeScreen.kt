package uk.ac.aber.dcs.cs31620.languageapp.ui.home

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

//@Composable
//fun HomeScreen(navController: NavController){
//
//    TopLevelScaffold(navController = navController as NavHostController) {
//        innerPadding ->
//        Surface(
//            modifier = Modifier
//                .padding(innerPadding)
//                .fillMaxSize()
//        ) {
//            Text(text = "Home Screen",
//                modifier = Modifier.padding(start = 8.dp))
//        }
//    }
//}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(){
    TopLevelScaffold() {
        innerPadding ->
        Surface(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Text(text = "Home Screen",
                modifier = Modifier.padding(start = 8.dp))
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview(){
    LanguageAppTheme(dynamicColor = false) {
        HomeScreen()
    }
}
