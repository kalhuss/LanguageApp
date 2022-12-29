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
import uk.ac.aber.dcs.cs31620.languageapp.model.Word
import uk.ac.aber.dcs.cs31620.languageapp.model.WordLanguageDao


@Database(entities = [Language::class, Word::class], version = 1)
abstract class WordLanguageDatabase : RoomDatabase() {
    abstract fun wordLanguageDao(): WordLanguageDao

    companion object {
        private var instance: WordLanguageDatabase? = null
        private val coroutineScope = CoroutineScope(Dispatchers.IO)

        fun deleteDatabase(context: Context){
            Room.databaseBuilder(context, WordLanguageDatabase::class.java,
                "word_language_database")
                .allowMainThreadQueries()
                .build()
                .clearAllTables()
            instance = null
        }


        @Synchronized
        fun getDatabase(context: Context): WordLanguageDatabase? {
            //context.deleteDatabase("word_language_database")
            if (instance == null) {
                instance =
                    Room.databaseBuilder<WordLanguageDatabase>(
                        context.applicationContext,
                        WordLanguageDatabase::class.java,
                        "word_language_database"
                    )
                        .allowMainThreadQueries()
                        .addCallback(roomDatabaseCallback(context))
                        //.addMigrations(MIGRATION_1_2, MIGRATION_2_3
                        .build()
            } // if
            return instance
        }

        private fun roomDatabaseCallback(context: Context): Callback {
            return object : Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)

                    coroutineScope.launch {
                        populateDatabase(context, getDatabase(context)!!)
                    }
                }
            }
        }

        private suspend fun populateDatabase(context: Context, instance: WordLanguageDatabase){
            val wordpair1 = Word(0, "Cool", "Kul")
            val language1 = Language(0, "English", "Swedish")
            val dao = instance.wordLanguageDao()
            dao.insertLanguage(language1)
            dao.insertWord(wordpair1)
        }
    }
}
