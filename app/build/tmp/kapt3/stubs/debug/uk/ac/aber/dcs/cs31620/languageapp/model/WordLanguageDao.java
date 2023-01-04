package uk.ac.aber.dcs.cs31620.languageapp.model;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0019\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0019\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u0014\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00140\u0013H\'J\u0014\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00140\u0013H\'J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u0013H\'J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u00132\u0006\u0010\u000f\u001a\u00020\u0010H\'J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\'J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u00132\u0006\u0010\u000f\u001a\u00020\u0010H\'J\u0019\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0019\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0019H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001eJ\u0019\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0019\u0010 \u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0019\u0010!\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\""}, d2 = {"Luk/ac/aber/dcs/cs31620/languageapp/model/WordLanguageDao;", "", "deleteAllLanguages", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAllWords", "deleteLanguage", "language", "Luk/ac/aber/dcs/cs31620/languageapp/model/Language;", "(Luk/ac/aber/dcs/cs31620/languageapp/model/Language;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteWord", "word", "Luk/ac/aber/dcs/cs31620/languageapp/model/Word;", "(Luk/ac/aber/dcs/cs31620/languageapp/model/Word;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteWordById", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllLanguages", "Landroidx/lifecycle/LiveData;", "", "getAllWords", "getFirstWord", "getLanguageById", "getTheme", "Luk/ac/aber/dcs/cs31620/languageapp/model/ThemeMode;", "getWordById", "insertLanguage", "insertTheme", "theme", "(Luk/ac/aber/dcs/cs31620/languageapp/model/ThemeMode;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertWord", "updateLanguage", "updateWord", "app_debug"})
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
    public abstract androidx.lifecycle.LiveData<java.util.List<uk.ac.aber.dcs.cs31620.languageapp.model.Language>> getAllLanguages();
    
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
    @androidx.room.Delete()
    public abstract java.lang.Object deleteWord(@org.jetbrains.annotations.NotNull()
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
    public abstract androidx.lifecycle.LiveData<java.util.List<uk.ac.aber.dcs.cs31620.languageapp.model.Word>> getAllWords();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM words WHERE id = :id")
    public abstract androidx.lifecycle.LiveData<uk.ac.aber.dcs.cs31620.languageapp.model.Word> getWordById(int id);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM words LIMIT 1")
    public abstract androidx.lifecycle.LiveData<uk.ac.aber.dcs.cs31620.languageapp.model.Word> getFirstWord();
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract java.lang.Object insertTheme(@org.jetbrains.annotations.NotNull()
    uk.ac.aber.dcs.cs31620.languageapp.model.ThemeMode theme, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM theme LIMIT 1")
    public abstract uk.ac.aber.dcs.cs31620.languageapp.model.ThemeMode getTheme();
}