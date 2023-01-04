package uk.ac.aber.dcs.cs31620.languageapp.datasource

import android.app.Application
import androidx.lifecycle.LiveData
import uk.ac.aber.dcs.cs31620.languageapp.model.Language
import uk.ac.aber.dcs.cs31620.languageapp.model.ThemeMode
import uk.ac.aber.dcs.cs31620.languageapp.model.Word


class WordLanguageRepository(application: Application) {
    private val wordLanguageDao = WordLanguageDatabase.getDatabase(application)!!.wordLanguageDao()
    val allLanguages: LiveData<List<Language>> = wordLanguageDao.getAllLanguages()
    val allWords: LiveData<List<Word>> = wordLanguageDao.getAllWords()

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

    suspend fun deleteWord(word: Word) {
        wordLanguageDao.deleteWord(word)
    }

    suspend fun deleteWordById(id: Int) {
        wordLanguageDao.deleteWordById(id)
    }

    suspend fun deleteAllWords() {
        wordLanguageDao.deleteAllWords()
    }

    //Theme operations
    suspend fun setTheme(theme: ThemeMode) {
        wordLanguageDao.insertTheme(theme)
    }

    fun getTheme(): ThemeMode? {
        return wordLanguageDao.getTheme()
    }
}
