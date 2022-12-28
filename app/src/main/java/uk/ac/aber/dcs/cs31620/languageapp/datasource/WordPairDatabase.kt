package uk.ac.aber.dcs.cs31620.languageapp.datasource

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uk.ac.aber.dcs.cs31620.languageapp.model.WordPair
import uk.ac.aber.dcs.cs31620.languageapp.model.WordPairDao

@Database(entities = [WordPair::class], version = 1)
abstract class WordPairDatabase : RoomDatabase() {
    abstract fun wordPairDao(): WordPairDao

    companion object {
        private var instance: WordPairDatabase? = null
        private val coroutineScope = CoroutineScope(Dispatchers.IO)

        fun deleteDatabase(context: Context){
            Room.databaseBuilder(context, WordPairDatabase::class.java,
            "word_pair_database")
                .allowMainThreadQueries()
                .build()
                .clearAllTables()
            instance = null
        }


        @Synchronized
        fun getDatabase(context: Context): WordPairDatabase? {
            //context.deleteDatabase("word_pair_database")
            if (instance == null) {
                instance =
                    Room.databaseBuilder<WordPairDatabase>(
                        context.applicationContext,
                        WordPairDatabase::class.java,
                        "word_pair_database"
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

        private suspend fun populateDatabase(context: Context, instance: WordPairDatabase){
            val wordpair1 = WordPair(2, "English", "Hey", "Swedish", "Hej")
            val wordpair2 = WordPair(3, "English", "I am eating", "Swedish", "Jag ater")
            val dao = instance.wordPairDao()
            dao.insertWordPair(wordpair1)
            dao.insertWordPair(wordpair2)
        }
    }
}