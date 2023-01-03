package uk.ac.aber.dcs.cs31620.languageapp.datasource;

import java.lang.System;

@androidx.room.Database(entities = {uk.ac.aber.dcs.cs31620.languageapp.model.Language.class, uk.ac.aber.dcs.cs31620.languageapp.model.Word.class}, version = 1)
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0006"}, d2 = {"Luk/ac/aber/dcs/cs31620/languageapp/datasource/WordLanguageDatabase;", "Landroidx/room/RoomDatabase;", "()V", "wordLanguageDao", "Luk/ac/aber/dcs/cs31620/languageapp/model/WordLanguageDao;", "Companion", "app_debug"})
public abstract class WordLanguageDatabase extends androidx.room.RoomDatabase {
    @org.jetbrains.annotations.NotNull()
    public static final uk.ac.aber.dcs.cs31620.languageapp.datasource.WordLanguageDatabase.Companion Companion = null;
    private static uk.ac.aber.dcs.cs31620.languageapp.datasource.WordLanguageDatabase instance;
    private static final kotlinx.coroutines.CoroutineScope coroutineScope = null;
    
    public WordLanguageDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract uk.ac.aber.dcs.cs31620.languageapp.model.WordLanguageDao wordLanguageDao();
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Luk/ac/aber/dcs/cs31620/languageapp/datasource/WordLanguageDatabase$Companion;", "", "()V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "instance", "Luk/ac/aber/dcs/cs31620/languageapp/datasource/WordLanguageDatabase;", "getDatabase", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.Nullable()
        @kotlin.jvm.Synchronized()
        public final synchronized uk.ac.aber.dcs.cs31620.languageapp.datasource.WordLanguageDatabase getDatabase(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
    }
}