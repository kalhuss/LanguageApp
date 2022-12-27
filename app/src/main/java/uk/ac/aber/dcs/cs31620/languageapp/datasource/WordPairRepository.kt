package uk.ac.aber.dcs.cs31620.languageapp.datasource

import androidx.lifecycle.LiveData
import uk.ac.aber.dcs.cs31620.languageapp.model.WordPair
import uk.ac.aber.dcs.cs31620.languageapp.model.WordPairDao

class WordPairRepository(private val wordPairDao: WordPairDao) {

    val getAllData: LiveData<List<WordPair>> = wordPairDao.getAllWordPairs()

    fun addWords(wordPair: WordPair) {
        wordPairDao.insertWordPair(wordPair)
    }
}





//    suspend fun deleteWords(wordPair: WordPair) {
//        wordPairDao.deleteWord(wordPair.id)
//    }
//
//    suspend fun deleteAllWords() {
//        wordPairDao.deleteAllWords()
//    }
//
//    fun insert(wordPair: WordPair) {
//        wordPairDao.insertWordPair(wordPair)
//    }
