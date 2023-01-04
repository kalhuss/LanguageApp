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

    init {
        val wordLanguageDao = WordLanguageDatabase.getDatabase(application)!!.wordLanguageDao()
        wordLanguageRepository = WordLanguageRepository(application)
        allWords = wordLanguageRepository.allWords
        allLanguages = wordLanguageRepository.allLanguages
        allTheme = wordLanguageRepository.allTheme
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

    fun updateLanguage(language: Language) = viewModelScope.launch(Dispatchers.IO) {
        wordLanguageRepository.updateLanguage(language)
    }

    fun deleteLanguage(language: Language) = viewModelScope.launch(Dispatchers.IO) {
        wordLanguageRepository.deleteLanguage(language)
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
}
