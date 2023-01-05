package uk.ac.aber.dcs.cs31620.languageapp.datasource

import android.app.Application
import androidx.lifecycle.LiveData
import uk.ac.aber.dcs.cs31620.languageapp.model.Language
import uk.ac.aber.dcs.cs31620.languageapp.model.ThemeMode
import uk.ac.aber.dcs.cs31620.languageapp.model.Word
import uk.ac.aber.dcs.cs31620.languageapp.model.Results

class WordLanguageRepository(application: Application) {
    private val wordLanguageDao = WordLanguageDatabase.getDatabase(application)!!.wordLanguageDao()
    val allLanguages: LiveData<List<Language>> = wordLanguageDao.allLanguages()
    val allWords: LiveData<List<Word>> = wordLanguageDao.allWords()
    val allTheme: LiveData<List<ThemeMode>> = wordLanguageDao.getAllTheme()
    val allResults: LiveData<List<Results>> = wordLanguageDao.getAllResults()

    //Language operations
    suspend fun insertLanguage(language: Language) {
        wordLanguageDao.insertLanguage(language)
    }

    suspend fun updateLanguage(language: Language) {
        wordLanguageDao.updateLanguage(language)
    }

    suspend fun deleteLanguage(language: Language) {
        wordLanguageDao.deleteLanguage(language)
    }

    suspend fun deleteAllLanguages() {
        wordLanguageDao.deleteAllLanguages()
    }

    //Word operations
    suspend fun insertWord(word: Word) {
        wordLanguageDao.insertWord(word)
    }

    fun getWordById(id: Int): LiveData<Word> {
        return wordLanguageDao.getWordById(id)
    }

    suspend fun updateWord(word: Word) {
        wordLanguageDao.updateWord(word)
    }

    suspend fun deleteWordById(id: Int) {
        wordLanguageDao.deleteWordById(id)
    }

    suspend fun deleteAllWords() {
        wordLanguageDao.deleteAllWords()
    }

    fun countWords(): LiveData<Int> {
        return wordLanguageDao.countWords()
    }

    //Theme operations
    suspend fun insertTheme(theme: ThemeMode) {
        wordLanguageDao.insertTheme(theme)
    }

    suspend fun updateTheme(theme: ThemeMode) {
        wordLanguageDao.updateTheme(theme)
    }

    //Results operations
    fun insertResults(results: Results){
        wordLanguageDao.insertResults(results)
    }

    suspend fun deleteAllResults(){
        wordLanguageDao.deleteAllResults()
    }



}
