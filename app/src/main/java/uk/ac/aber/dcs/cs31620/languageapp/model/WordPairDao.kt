package uk.ac.aber.dcs.cs31620.languageapp.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface WordPairDao{
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertWordPair(wordPair : WordPair)

    @Query("SELECT * FROM words_table ORDER BY id ASC")
    fun getAllWordPairs() : LiveData<List<WordPair>>

//    @Query("SELECT * FROM words_table")
//    fun getAllWords(): List<WordPair>
//
//    @Query("SELECT * FROM words_table WHERE id = :wordsId")
//    fun getWordsByID(wordsId: Int): List<WordPair>
//
//    @Query("DELETE FROM words_table WHERE id = :wordsId")
//    fun deleteWord(wordsId: Int)
//
//    @Query("DELETE FROM words_table")
//    fun deleteAllWords()
}
