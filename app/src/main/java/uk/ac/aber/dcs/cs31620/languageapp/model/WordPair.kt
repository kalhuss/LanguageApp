package uk.ac.aber.dcs.cs31620.languageapp.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.intellij.lang.annotations.Language

@Entity(tableName = "words_table")
data class WordPair(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    val id: Int,
    val nativeLanguage: String,
    val nativeWord: String,
    val foreignLanguage: String,
    val foreignWord: String
)