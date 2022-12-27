package uk.ac.aber.dcs.cs31620.languageapp.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [WordPair::class], version = 1, exportSchema = false)
abstract class WordPairDatabase : RoomDatabase() {
    abstract fun wordPairDao(): WordPairDao

    companion object{
        @Volatile
        private var INSTANCE: WordPairDatabase? = null

        fun getDatabase(context: Context): WordPairDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WordPairDatabase::class.java,
                    "words_table"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}