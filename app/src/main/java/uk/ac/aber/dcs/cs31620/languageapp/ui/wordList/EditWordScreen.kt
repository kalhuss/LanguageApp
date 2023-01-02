package uk.ac.aber.dcs.cs31620.languageapp.ui.wordList

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import uk.ac.aber.dcs.cs31620.languageapp.model.Word
import uk.ac.aber.dcs.cs31620.languageapp.model.WordLanguageViewModel
import uk.ac.aber.dcs.cs31620.languageapp.ui.components.TopLevelScaffold

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "NotConstructor")
@Composable
fun EditWordScreen(navController : NavHostController, wordID: Int){
    println("Edit Screen: $wordID")
    val viewModel: WordLanguageViewModel = viewModel()
    val getWord: LiveData<Word> = viewModel.getWordById(wordID)
    val word = getWord.observeAsState().value

    println("Word List: $word")
    TopLevelScaffold(
        navController = navController,
        titleName = "Edit Word"
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            if (word?.nativeWord != null) {
                Text(text = word.nativeWord, modifier = Modifier.padding(start = 8.dp))
            }

        }
    }
}