package uk.ac.aber.dcs.cs31620.languageapp.ui.wordList

import android.annotation.SuppressLint
import android.app.Application
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import uk.ac.aber.dcs.cs31620.languageapp.datasource.WordPairRepository
import uk.ac.aber.dcs.cs31620.languageapp.ui.components.TopLevelScaffold
import uk.ac.aber.dcs.cs31620.languageapp.ui.theme.LanguageAppTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "NotConstructor")
@Composable
fun WordListScreen(navController : NavHostController){

    //val coroutineScope = rememberCoroutineScope()

    TopLevelScaffold(
        navController = navController,
        //coroutineScope = coroutineScope,
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            WordListScreenContent(
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
private fun WordListScreenContent(modifier: Modifier = Modifier){
    Column(modifier = modifier.fillMaxSize()){
        WordCard(Modifier.fillMaxWidth())
    }
}

@Composable
private fun WordCard(modifier: Modifier = Modifier){
    val context = LocalContext.current.applicationContext
    LaunchedEffect(key1 = Unit){
        val repository = WordPairRepository(context as Application)
        repository.getAllWordPairs()
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