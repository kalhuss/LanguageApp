package uk.ac.aber.dcs.cs31620.languageapp.datasource

import android.app.Application
import androidx.lifecycle.LiveData
import uk.ac.aber.dcs.cs31620.languageapp.model.Language
import uk.ac.aber.dcs.cs31620.languageapp.model.ThemeMode
import uk.ac.aber.dcs.cs31620.languageapp.model.Word
import uk.ac.aber.dcs.cs31620.languageapp.model.Results

/**
 * Repository for the language app. This repository is responsible for managing data operations
 * such as inserting, updating, and deleting data in the database. It also provides access to
 * LiveData objects for the UI to observe.
 */
class WordLanguageRepository(application: Application) {
    private val wordLanguageDao = WordLanguageDatabase.getDatabase(application)!!.wordLanguageDao()

    // Get all
    val allLanguages: LiveData<List<Language>> = wordLanguageDao.allLanguages()
    val allWords: LiveData<List<Word>> = wordLanguageDao.allWords()
    val allTheme: LiveData<List<ThemeMode>> = wordLanguageDao.getAllTheme()
    val allResults: LiveData<List<Results>> = wordLanguageDao.getAllResults()

    // Language operations
    suspend fun insertLanguage(language: Language) {
        wordLanguageDao.insertLanguage(language)
    }

    suspend fun deleteAllLanguages() {
        wordLanguageDao.deleteAllLanguages()
    }

    // Word operations
    suspend fun insertWord(word: Word) {
        wordLanguageDao.insertWord(word)
    }

    suspend fun updateWord(word: Word) {
        wordLanguageDao.updateWord(word)
    }

    fun getWordById(id: Int): LiveData<Word> {
        return wordLanguageDao.getWordById(id)
    }

    suspend fun deleteWordById(id: Int) {
        wordLanguageDao.deleteWordById(id)
    }

    suspend fun deleteAllWords() {
        wordLanguageDao.deleteAllWords()
    }

    // Theme operations
    suspend fun insertTheme(theme: ThemeMode) {
        wordLanguageDao.insertTheme(theme)
    }

    suspend fun updateTheme(theme: ThemeMode) {
        wordLanguageDao.updateTheme(theme)
    }

    // Results operations
    fun insertResults(results: Results){
        wordLanguageDao.insertResults(results)
    }

    suspend fun deleteAllResults(){
        wordLanguageDao.deleteAllResults()
    }
}
