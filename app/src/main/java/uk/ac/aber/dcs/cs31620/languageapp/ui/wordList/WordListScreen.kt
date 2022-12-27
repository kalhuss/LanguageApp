package uk.ac.aber.dcs.cs31620.languageapp.ui.wordList

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import uk.ac.aber.dcs.cs31620.languageapp.model.WordPair
import uk.ac.aber.dcs.cs31620.languageapp.model.WordPairViewModel
import uk.ac.aber.dcs.cs31620.languageapp.ui.components.TopLevelScaffold
import uk.ac.aber.dcs.cs31620.languageapp.ui.components.WordCard
import uk.ac.aber.dcs.cs31620.languageapp.ui.theme.LanguageAppTheme

//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "NotConstructor")
//@Composable
//fun WordListScreen(navController : NavHostController){
//
//    //val coroutineScope = rememberCoroutineScope()
//
//    TopLevelScaffold(
//        navController = navController,
//        //coroutineScope = coroutineScope,
//    ) { innerPadding ->
//        Surface(
//            modifier = Modifier
//                .padding(innerPadding)
//                .fillMaxSize()
//        ) {
//            WordListScreenContent(
//                modifier = Modifier.padding(8.dp)
//            )
//        }
//    }
//}
//
//@Composable
//private fun WordListScreenContent(modifier: Modifier = Modifier){
//    Column(modifier = modifier.fillMaxSize()){
//        WordCard(Modifier.fillMaxWidth())
//    }
//}
//
//@Composable
//private fun WordCard(modifier: Modifier = Modifier){
//    val context = LocalContext.current.applicationContext
//    LaunchedEffect(key1 = Unit){
//        val repository = WordPairRepository(context as Application)
//        repository.getAllWordPairs()
//    }
//}


@Composable
fun WordListScreen(navController: NavHostController) {
    val viewModel: WordPairViewModel = viewModel()
    val wordPairs: LiveData<List<WordPair>> = viewModel.allWordPairs

    TopLevelScaffold(
        navController = navController
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Column {
                wordPairs.observeAsState().value?.forEach { wordPair ->
                    WordCard(wordPair)
                }
            }
        }
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