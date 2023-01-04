package uk.ac.aber.dcs.cs31620.languageapp.datasource

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uk.ac.aber.dcs.cs31620.languageapp.model.Language
import uk.ac.aber.dcs.cs31620.languageapp.model.ThemeMode
import uk.ac.aber.dcs.cs31620.languageapp.model.Word
import uk.ac.aber.dcs.cs31620.languageapp.model.WordLanguageDao


@Database(entities = [Language::class, Word::class], version = 1)
abstract class WordLanguageDatabase : RoomDatabase() {
    abstract fun wordLanguageDao(): WordLanguageDao

    companion object {
        private var instance: WordLanguageDatabase? = null

        @Synchronized
        fun getDatabase(context: Context): WordLanguageDatabase? {
            if (instance == null) {
                instance =
                    Room.databaseBuilder<WordLanguageDatabase>(
                        context.applicationContext,
                        WordLanguageDatabase::class.java,
                        "word_language_database"
                    )
                        .allowMainThreadQueries()
                        .build()
            }
            return instance
        }

    }
}

