package uk.ac.aber.dcs.cs31620.languageapp.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface WordPairDao{
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertWordPair(wordPair: WordPair)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateWordPair(wordPair: WordPair)

    @Delete
    suspend fun deleteWordPair(wordPair: WordPair)

    @Query("DELETE FROM words_table")
    suspend fun deleteAllWordPairs()

    @Query("SELECT * FROM words_table ORDER BY id ASC")
    fun getAllWordPairs(): LiveData<List<WordPair>>

    @Query("SELECT * FROM words_table LIMIT 1")
    fun getFirstWordPair(): WordPair?
}