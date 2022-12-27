package uk.ac.aber.dcs.cs31620.languageapp.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uk.ac.aber.dcs.cs31620.languageapp.datasource.WordPairDatabase
import uk.ac.aber.dcs.cs31620.languageapp.datasource.WordPairRepository

class WordPairViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: WordPairRepository
    val allWordPairs: LiveData<List<WordPair>>

    init {
        val wordPairDao = WordPairDatabase.getDatabase(application)!!.wordPairDao()
        repository = WordPairRepository(application)
        allWordPairs = repository.getAllWordPairs()
    }

    fun insertWordPair(wordPair: WordPair) = viewModelScope.launch(Dispatchers.IO) {
        repository.insertWordPair(wordPair)
    }

    fun updateWordPair(wordPair: WordPair) = viewModelScope.launch(Dispatchers.IO) {
        repository.updateWordPair(wordPair)
    }

    fun deleteWordPair(wordPair: WordPair) = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteWordPair(wordPair)
    }

    fun deleteAllWordPairs() = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteAllWordPairs()
    }


}