package uk.ac.aber.dcs.cs31620.languageapp.datasource

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uk.ac.aber.dcs.cs31620.languageapp.model.*

/**
 * Room database for the language app. This database is used to store and retrieve language, word,
 * theme mode, and results data.
 */
@Database(entities = [Language::class, Word::class, ThemeMode::class, Results::class],
    exportSchema = true, version = 1)
abstract class WordLanguageDatabase : RoomDatabase() {
    /**
     * Provides access to the data access object (DAO) for this database.
     */
    abstract fun wordLanguageDao(): WordLanguageDao

    companion object {
        private var instance: WordLanguageDatabase? = null
        private val coroutineScope = CoroutineScope(Dispatchers.IO)

        /**
         * Deletes the entire database.
         *
         * @param context the context in which the database is being deleted
         */
        fun deleteDatabase(context: Context){
            Room.databaseBuilder(context, WordLanguageDatabase::class.java,
                "word_language_database")
                .allowMainThreadQueries()
                .build()
                .clearAllTables()
            instance = null
        }

        /**
         * Returns the singleton instance of the database. If the instance does not exist yet,
         * it will be created using the provided context.
         *
         * @param context the context in which the database is being accessed
         * @return the singleton instance of the database
         */
        @Synchronized
        fun getDatabase(context: Context): WordLanguageDatabase? {
            //context.deleteDatabase("word_language_database")
            if (instance == null) {
                instance =
                    Room.databaseBuilder(
                        context.applicationContext,
                        WordLanguageDatabase::class.java,
                        "word_language_database"
                    )
                        .allowMainThreadQueries()
                        .addCallback(roomDatabaseCallback(context))
                        .build()
            }
            return instance
        }

        /**
         * Returns a RoomDatabase.Callback object that is called when the database is created for
         * the first time. This callback is responsible for populating the database with a default
         * theme mode.
         *
         * @param context the context in which the database is being created
         * @return a RoomDatabase.Callback object
         */
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

        /**
         * Populates the database with a default theme mode.
         *
         * @param context the context in which the database is being created
         * @param instance the instance of the database being created
         */
        private suspend fun populateDatabase(context: Context, instance: WordLanguageDatabase){
            val defaultTheme = ThemeMode(0, false)
            val dao = instance.wordLanguageDao()
            dao.insertTheme(defaultTheme)
        }
    }
}
