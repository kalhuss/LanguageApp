package uk.ac.aber.dcs.cs31620.languageapp.datasource

import android.app.Application
import androidx.lifecycle.LiveData
import uk.ac.aber.dcs.cs31620.languageapp.model.WordPair

class WordPairRepository(application: Application){
    private val wordPairDao = WordPairDatabase.getDatabase(application)!!.wordPairDao()

    suspend fun insertWordPair(wordPair: WordPair) {
        wordPairDao.insertWordPair(wordPair)
    }

    suspend fun updateWordPair(wordPair: WordPair) {
        wordPairDao.updateWordPair(wordPair)
    }

    suspend fun deleteWordPair(wordPair: WordPair) {
        wordPairDao.deleteWordPair(wordPair)
    }

    suspend fun deleteAllWordPairs() {
        wordPairDao.deleteAllWordPairs()
    }

    fun getAllWordPairs(): LiveData<List<WordPair>> {
        return wordPairDao.getAllWordPairs()
    }
}