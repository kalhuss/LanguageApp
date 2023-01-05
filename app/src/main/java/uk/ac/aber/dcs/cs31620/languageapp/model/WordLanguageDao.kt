package uk.ac.aber.dcs.cs31620.languageapp.model

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteQuery

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
    fun allLanguages(): LiveData<List<Language>>

    @Query("SELECT * FROM languages WHERE id = :id")
    fun getLanguageById(id: Int): LiveData<Language>

    // Word operations
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertWord(word: Word)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateWord(word: Word)

    @Query("DELETE FROM words WHERE id = :id")
    suspend fun deleteWordById(id: Int)

    @Query("DELETE FROM words")
    suspend fun deleteAllWords()

    // Select operations for the Word entity
    @Query("SELECT * FROM words")
    fun allWords(): LiveData<List<Word>>

    @Query("SELECT * FROM words WHERE id = :id")
    fun getWordById(id: Int): LiveData<Word>

    @Query("SELECT * FROM words LIMIT 1")
    fun getFirstWord(): LiveData<Word>

    @Query("SELECT COUNT(nativeWord) FROM words WHERE nativeWord IS NOT NULL")
    fun countWords(): LiveData<Int>

    // Theme operations
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTheme(theme: ThemeMode)

    @Query("SELECT * FROM theme")
    fun getAllTheme(): LiveData<List<ThemeMode>>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateTheme(theme: ThemeMode)

    // Results operations
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertResults(results: Results)

    @Query("SELECT * FROM results")
    fun getAllResults(): LiveData<List<Results>>

    @Query("DELETE FROM results")
    suspend fun deleteAllResults()


}