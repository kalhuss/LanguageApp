package uk.ac.aber.dcs.cs31620.languageapp.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uk.ac.aber.dcs.cs31620.languageapp.datasource.WordLanguageDatabase
import uk.ac.aber.dcs.cs31620.languageapp.datasource.WordLanguageRepository

class WordLanguageViewModel(application: Application) : AndroidViewModel(application) {

    private val wordLanguageRepository: WordLanguageRepository
    val allWords: LiveData<List<Word>>
    val allLanguages: LiveData<List<Language>>

    init {
        val wordLanguageDao = WordLanguageDatabase.getDatabase(application)!!.wordLanguageDao()
        wordLanguageRepository = WordLanguageRepository(application)
        allWords = wordLanguageRepository.allWords
        allLanguages = wordLanguageRepository.allLanguages
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

    fun updateLanguage(language: Language) = viewModelScope.launch(Dispatchers.IO) {
        wordLanguageRepository.updateLanguage(language)
    }

    fun getWordById(id: Int): LiveData<Word> {
        return wordLanguageRepository.getWordById(id)
    }


    fun deleteWord(word: Word) = viewModelScope.launch(Dispatchers.IO) {
        wordLanguageRepository.deleteWord(word)
    }

    fun deleteLanguage(language: Language) = viewModelScope.launch(Dispatchers.IO) {
        wordLanguageRepository.deleteLanguage(language)
    }

    fun deleteAllWords() = viewModelScope.launch(Dispatchers.IO) {
        wordLanguageRepository.deleteAllWords()
    }
}
