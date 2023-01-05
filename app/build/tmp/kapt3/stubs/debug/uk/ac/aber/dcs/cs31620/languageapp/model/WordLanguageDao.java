package uk.ac.aber.dcs.cs31620.languageapp.model;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\'J\u0014\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00040\u0003H\'J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003H\'J\u0011\u0010\n\u001a\u00020\u000bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\u0011\u0010\r\u001a\u00020\u000bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\u0011\u0010\u000e\u001a\u00020\u000bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\u0019\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J\u0014\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00040\u0003H\'J\u0014\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00040\u0003H\'J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003H\'J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0013\u001a\u00020\tH\'J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00032\u0006\u0010\u0013\u001a\u00020\tH\'J\u0019\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u0010\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u0016H\'J\u0019\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u0018H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010!J\u0019\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010$J\u0019\u0010%\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u0019\u0010&\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u0018H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010!J\u0019\u0010\'\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010$\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006("}, d2 = {"Luk/ac/aber/dcs/cs31620/languageapp/model/WordLanguageDao;", "", "allLanguages", "Landroidx/lifecycle/LiveData;", "", "Luk/ac/aber/dcs/cs31620/languageapp/model/Language;", "allWords", "Luk/ac/aber/dcs/cs31620/languageapp/model/Word;", "countWords", "", "deleteAllLanguages", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAllResults", "deleteAllWords", "deleteLanguage", "language", "(Luk/ac/aber/dcs/cs31620/languageapp/model/Language;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteWordById", "id", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllResults", "Luk/ac/aber/dcs/cs31620/languageapp/model/Results;", "getAllTheme", "Luk/ac/aber/dcs/cs31620/languageapp/model/ThemeMode;", "getFirstWord", "getLanguageById", "getWordById", "insertLanguage", "insertResults", "results", "insertTheme", "theme", "(Luk/ac/aber/dcs/cs31620/languageapp/model/ThemeMode;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertWord", "word", "(Luk/ac/aber/dcs/cs31620/languageapp/model/Word;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateLanguage", "updateTheme", "updateWord", "app_debug"})
public abstract interface WordLanguageDao {
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.IGNORE)
    public abstract java.lang.Object insertLanguage(@org.jetbrains.annotations.NotNull()
    uk.ac.aber.dcs.cs31620.languageapp.model.Language language, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Update(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract java.lang.Object updateLanguage(@org.jetbrains.annotations.NotNull()
    uk.ac.aber.dcs.cs31620.languageapp.model.Language language, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Delete()
    public abstract java.lang.Object deleteLanguage(@org.jetbrains.annotations.NotNull()
    uk.ac.aber.dcs.cs31620.languageapp.model.Language language, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "DELETE FROM languages")
    public abstract java.lang.Object deleteAllLanguages(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM languages")
    public abstract androidx.lifecycle.LiveData<java.util.List<uk.ac.aber.dcs.cs31620.languageapp.model.Language>> allLanguages();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM languages WHERE id = :id")
    public abstract androidx.lifecycle.LiveData<uk.ac.aber.dcs.cs31620.languageapp.model.Language> getLanguageById(int id);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.IGNORE)
    public abstract java.lang.Object insertWord(@org.jetbrains.annotations.NotNull()
    uk.ac.aber.dcs.cs31620.languageapp.model.Word word, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Update(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract java.lang.Object updateWord(@org.jetbrains.annotations.NotNull()
    uk.ac.aber.dcs.cs31620.languageapp.model.Word word, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "DELETE FROM words WHERE id = :id")
    public abstract java.lang.Object deleteWordById(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "DELETE FROM words")
    public abstract java.lang.Object deleteAllWords(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM words")
    public abstract androidx.lifecycle.LiveData<java.util.List<uk.ac.aber.dcs.cs31620.languageapp.model.Word>> allWords();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM words WHERE id = :id")
    public abstract androidx.lifecycle.LiveData<uk.ac.aber.dcs.cs31620.languageapp.model.Word> getWordById(int id);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM words LIMIT 1")
    public abstract androidx.lifecycle.LiveData<uk.ac.aber.dcs.cs31620.languageapp.model.Word> getFirstWord();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT COUNT(nativeWord) FROM words WHERE nativeWord IS NOT NULL")
    public abstract androidx.lifecycle.LiveData<java.lang.Integer> countWords();
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.IGNORE)
    public abstract java.lang.Object insertTheme(@org.jetbrains.annotations.NotNull()
    uk.ac.aber.dcs.cs31620.languageapp.model.ThemeMode theme, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM theme")
    public abstract androidx.lifecycle.LiveData<java.util.List<uk.ac.aber.dcs.cs31620.languageapp.model.ThemeMode>> getAllTheme();
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Update(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract java.lang.Object updateTheme(@org.jetbrains.annotations.NotNull()
    uk.ac.aber.dcs.cs31620.languageapp.model.ThemeMode theme, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.IGNORE)
    public abstract void insertResults(@org.jetbrains.annotations.NotNull()
    uk.ac.aber.dcs.cs31620.languageapp.model.Results results);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM results")
    public abstract androidx.lifecycle.LiveData<java.util.List<uk.ac.aber.dcs.cs31620.languageapp.model.Results>> getAllResults();
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "DELETE FROM results")
    public abstract java.lang.Object deleteAllResults(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
}