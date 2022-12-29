package uk.ac.aber.dcs.cs31620.languageapp.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface WordLanguageDao {

    // Language operations
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertLanguage(language: Language)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateLanguage(language: Language)

    @Delete
    suspend fun deleteLanguage(language: Language)

    @Query("DELETE FROM languages")
    suspend fun deleteAllLanguages()

    @Query("SELECT * FROM languages")
    fun getAllLanguages(): LiveData<List<Language>>

    @Query("SELECT * FROM languages WHERE id = :id")
    fun getLanguageById(id: Int): LiveData<Language>

    // Word operations
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertWord(word: Word)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateWord(word: Word)

    @Delete
    suspend fun deleteWord(word: Word)

    @Query("DELETE FROM words")
    suspend fun deleteAllWords()

    // Select operations for the Word entity
    @Query("SELECT * FROM words")
    fun getAllWords(): LiveData<List<Word>>

    @Query("SELECT * FROM words WHERE id = :id")
    fun getWordById(id: Int): LiveData<Word>

    @Query("SELECT * FROM words LIMIT 1")
    fun getFirstWord(): LiveData<Word>
}