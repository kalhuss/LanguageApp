package uk.ac.aber.dcs.cs31620.languageapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "languages")
data class Language(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val nativeLanguage: String,
    val foreignLanguage: String
)

@Entity(tableName = "words")
data class Word(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val nativeWord: String,
    val foreignWord: String
)