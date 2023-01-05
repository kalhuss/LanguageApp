package uk.ac.aber.dcs.cs31620.languageapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

//Table for languages
@Entity(tableName = "languages")
data class Language(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val nativeLanguage: String,
    val foreignLanguage: String
)

//Table for words
@Entity(tableName = "words")
data class Word(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    var nativeWord: String,
    var foreignWord: String
)

//Table for theme
@Entity(tableName = "theme")
data class ThemeMode(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val isDark: Boolean
)

//Table for results
@Entity(tableName = "results")
data class Results(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val quizName: String,
    val score: String
)