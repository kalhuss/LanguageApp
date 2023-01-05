package uk.ac.aber.dcs.cs31620.languageapp.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.sqlite.db.SupportSQLiteQuery
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import uk.ac.aber.dcs.cs31620.languageapp.datasource.WordLanguageDatabase
import uk.ac.aber.dcs.cs31620.languageapp.datasource.WordLanguageRepository

class WordLanguageViewModel(application: Application) : AndroidViewModel(application) {

    private val wordLanguageRepository: WordLanguageRepository
    val allWords: LiveData<List<Word>>
    val allLanguages: LiveData<List<Language>>
    val allTheme: LiveData<List<ThemeMode>>
    val allResults: LiveData<List<Results>>

    init {
        WordLanguageDatabase.getDatabase(application)!!.wordLanguageDao()
        wordLanguageRepository = WordLanguageRepository(application)
        allWords = wordLanguageRepository.allWords
        allLanguages = wordLanguageRepository.allLanguages
        allTheme = wordLanguageRepository.allTheme
        allResults = wordLanguageRepository.allResults

    }

    //Language operations
    fun insertWord(word: Word) = viewModelScope.launch(Dispatchers.IO) {
        wordLanguageRepository.insertWord(word)
    }

    fun insertLanguage(language: Language) = viewModelScope.launch(Dispatchers.IO) {
        wordLanguageRepository.insertLanguage(language)
    }

    fun deleteAllLanguages() = viewModelScope.launch(Dispatchers.IO) {
        wordLanguageRepository.deleteAllLanguages()
    }

    // Word operations
    fun updateWord(word: Word) = viewModelScope.launch(Dispatchers.IO) {
        wordLanguageRepository.updateWord(word)
    }

    fun getWordById(id: Int): LiveData<Word> {
        return wordLanguageRepository.getWordById(id)
    }

    fun deleteWordById(id: Int) = viewModelScope.launch(Dispatchers.IO) {
        wordLanguageRepository.deleteWordById(id)
    }

    fun deleteAllWords() = viewModelScope.launch(Dispatchers.IO) {
        wordLanguageRepository.deleteAllWords()
    }

    fun countWords(): LiveData<Int> {
        return wordLanguageRepository.countWords()
    }

    //Theme operations
    fun insertTheme(theme: ThemeMode) = viewModelScope.launch(Dispatchers.IO) {
        wordLanguageRepository.insertTheme(theme)
    }

    fun updateTheme(theme: ThemeMode) = viewModelScope.launch(Dispatchers.IO) {
        wordLanguageRepository.updateTheme(theme)
    }

    //Results operations
    fun insertResults(results: Results) = viewModelScope.launch(Dispatchers.IO){
        wordLanguageRepository.insertResults(results)
    }

    fun deleteAllResults() = viewModelScope.launch(Dispatchers.IO) {
        wordLanguageRepository.deleteAllResults()
    }
}
