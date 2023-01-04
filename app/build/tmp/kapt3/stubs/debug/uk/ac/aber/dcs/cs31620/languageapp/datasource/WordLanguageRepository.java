package uk.ac.aber.dcs.cs31620.languageapp.datasource;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0011\u0010\u0010\u001a\u00020\u0011H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J\u0011\u0010\u0013\u001a\u00020\u0011H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J\u0019\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\u0019\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019J\u0019\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001cH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001dJ\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\f0\u00062\u0006\u0010\u001b\u001a\u00020\u001cJ\u0019\u0010!\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\u0019\u0010\"\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019J\u0019\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\u001fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010%J\u0019\u0010&\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\u0019\u0010\'\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006("}, d2 = {"Luk/ac/aber/dcs/cs31620/languageapp/datasource/WordLanguageRepository;", "", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "allLanguages", "Landroidx/lifecycle/LiveData;", "", "Luk/ac/aber/dcs/cs31620/languageapp/model/Language;", "getAllLanguages", "()Landroidx/lifecycle/LiveData;", "allWords", "Luk/ac/aber/dcs/cs31620/languageapp/model/Word;", "getAllWords", "wordLanguageDao", "Luk/ac/aber/dcs/cs31620/languageapp/model/WordLanguageDao;", "deleteAllLanguages", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAllWords", "deleteLanguage", "language", "(Luk/ac/aber/dcs/cs31620/languageapp/model/Language;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteWord", "word", "(Luk/ac/aber/dcs/cs31620/languageapp/model/Word;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteWordById", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTheme", "Luk/ac/aber/dcs/cs31620/languageapp/model/ThemeMode;", "getWordById", "insertLanguage", "insertWord", "setTheme", "theme", "(Luk/ac/aber/dcs/cs31620/languageapp/model/ThemeMode;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateLanguage", "updateWord", "app_debug"})
public final class WordLanguageRepository {
    private final uk.ac.aber.dcs.cs31620.languageapp.model.WordLanguageDao wordLanguageDao = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<uk.ac.aber.dcs.cs31620.languageapp.model.Language>> allLanguages = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<uk.ac.aber.dcs.cs31620.languageapp.model.Word>> allWords = null;
    
    public WordLanguageRepository(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<uk.ac.aber.dcs.cs31620.languageapp.model.Language>> getAllLanguages() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<uk.ac.aber.dcs.cs31620.languageapp.model.Word>> getAllWords() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object insertLanguage(@org.jetbrains.annotations.NotNull()
    uk.ac.aber.dcs.cs31620.languageapp.model.Language language, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateLanguage(@org.jetbrains.annotations.NotNull()
    uk.ac.aber.dcs.cs31620.languageapp.model.Language language, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteLanguage(@org.jetbrains.annotations.NotNull()
    uk.ac.aber.dcs.cs31620.languageapp.model.Language language, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteAllLanguages(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object insertWord(@org.jetbrains.annotations.NotNull()
    uk.ac.aber.dcs.cs31620.languageapp.model.Word word, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<uk.ac.aber.dcs.cs31620.languageapp.model.Word> getWordById(int id) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateWord(@org.jetbrains.annotations.NotNull()
    uk.ac.aber.dcs.cs31620.languageapp.model.Word word, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteWord(@org.jetbrains.annotations.NotNull()
    uk.ac.aber.dcs.cs31620.languageapp.model.Word word, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteWordById(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteAllWords(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object setTheme(@org.jetbrains.annotations.NotNull()
    uk.ac.aber.dcs.cs31620.languageapp.model.ThemeMode theme, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final uk.ac.aber.dcs.cs31620.languageapp.model.ThemeMode getTheme() {
        return null;
    }
}