package uk.ac.aber.dcs.cs31620.languageapp.datasource;

import java.lang.System;

/**
 * Room database for the language app. This database is used to store and retrieve language, word,
 * theme mode, and results data.
 */
@androidx.room.Database(entities = {uk.ac.aber.dcs.cs31620.languageapp.model.Language.class, uk.ac.aber.dcs.cs31620.languageapp.model.Word.class, uk.ac.aber.dcs.cs31620.languageapp.model.ThemeMode.class, uk.ac.aber.dcs.cs31620.languageapp.model.Results.class}, exportSchema = true, version = 1)
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0006"}, d2 = {"Luk/ac/aber/dcs/cs31620/languageapp/datasource/WordLanguageDatabase;", "Landroidx/room/RoomDatabase;", "()V", "wordLanguageDao", "Luk/ac/aber/dcs/cs31620/languageapp/model/WordLanguageDao;", "Companion", "app_debug"})
public abstract class WordLanguageDatabase extends androidx.room.RoomDatabase {
    @org.jetbrains.annotations.NotNull()
    public static final uk.ac.aber.dcs.cs31620.languageapp.datasource.WordLanguageDatabase.Companion Companion = null;
    private static uk.ac.aber.dcs.cs31620.languageapp.datasource.WordLanguageDatabase instance;
    private static final kotlinx.coroutines.CoroutineScope coroutineScope = null;
    
    public WordLanguageDatabase() {
        super();
    }
    
    /**
     * Provides access to the data access object (DAO) for this database.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract uk.ac.aber.dcs.cs31620.languageapp.model.WordLanguageDao wordLanguageDao();
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\nJ!\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2 = {"Luk/ac/aber/dcs/cs31620/languageapp/datasource/WordLanguageDatabase$Companion;", "", "()V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "instance", "Luk/ac/aber/dcs/cs31620/languageapp/datasource/WordLanguageDatabase;", "deleteDatabase", "", "context", "Landroid/content/Context;", "getDatabase", "populateDatabase", "(Landroid/content/Context;Luk/ac/aber/dcs/cs31620/languageapp/datasource/WordLanguageDatabase;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "roomDatabaseCallback", "Landroidx/room/RoomDatabase$Callback;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        /**
         * Deletes the entire database.
         *
         * @param context the context in which the database is being deleted
         */
        public final void deleteDatabase(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
        }
        
        /**
         * Returns the singleton instance of the database. If the instance does not exist yet,
         * it will be created using the provided context.
         *
         * @param context the context in which the database is being accessed
         * @return the singleton instance of the database
         */
        @org.jetbrains.annotations.Nullable()
        @kotlin.jvm.Synchronized()
        public final synchronized uk.ac.aber.dcs.cs31620.languageapp.datasource.WordLanguageDatabase getDatabase(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        /**
         * Returns a RoomDatabase.Callback object that is called when the database is created for
         * the first time. This callback is responsible for populating the database with a default
         * theme mode.
         *
         * @param context the context in which the database is being created
         * @return a RoomDatabase.Callback object
         */
        private final androidx.room.RoomDatabase.Callback roomDatabaseCallback(android.content.Context context) {
            return null;
        }
        
        /**
         * Populates the database with a default theme mode.
         *
         * @param context the context in which the database is being created
         * @param instance the instance of the database being created
         */
        private final java.lang.Object populateDatabase(android.content.Context context, uk.ac.aber.dcs.cs31620.languageapp.datasource.WordLanguageDatabase instance, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
            return null;
        }
    }
}