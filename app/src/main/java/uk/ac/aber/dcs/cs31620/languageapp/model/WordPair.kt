package uk.ac.aber.dcs.cs31620.languageapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "words_table")
data class WordPair(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val nativeWord: String,
    val foreignWord: String
)