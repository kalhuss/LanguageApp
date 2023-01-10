package uk.ac.aber.dcs.cs31620.languageapp.model

import androidx.lifecycle.LiveData
import androidx.room.*

/**
 * Data access object (DAO) for the language app database. Provides methods for inserting, updating,
 * deleting, and querying data in the database.
 */
@Dao
interface WordLanguageDao {

    // Language operations
    @Query("SELECT * FROM languages")
    fun allLanguages(): LiveData<List<Language>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertLanguage(language: Language)

    @Query("DELETE FROM languages")
    suspend fun deleteAllLanguages()

    // Word operations
    @Query("SELECT * FROM words")
    fun allWords(): LiveData<List<Word>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertWord(word: Word)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateWord(word: Word)

    @Query("SELECT * FROM words WHERE id = :id")
    fun getWordById(id: Int): LiveData<Word>

    @Query("DELETE FROM words WHERE id = :id")
    suspend fun deleteWordById(id: Int)

    @Query("DELETE FROM words")
    suspend fun deleteAllWords()

    // Theme operations
    @Query("SELECT * FROM theme")
    fun getAllTheme(): LiveData<List<ThemeMode>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTheme(theme: ThemeMode)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateTheme(theme: ThemeMode)

    // Results operations
    @Query("SELECT * FROM results")
    fun getAllResults(): LiveData<List<Results>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertResults(results: Results)

    @Query("DELETE FROM results")
    suspend fun deleteAllResults()

}