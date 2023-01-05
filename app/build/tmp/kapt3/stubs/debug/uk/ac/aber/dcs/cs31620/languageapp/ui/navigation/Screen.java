package uk.ac.aber.dcs.cs31620.languageapp.ui.navigation;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\n\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011B\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004\u0082\u0001\n\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u00a8\u0006\u001c"}, d2 = {"Luk/ac/aber/dcs/cs31620/languageapp/ui/navigation/Screen;", "", "route", "", "(Ljava/lang/String;)V", "getRoute", "()Ljava/lang/String;", "setRoute", "AddWord", "EditWord", "Home", "Quiz", "ScrambleQuiz", "Setting", "SettingConfirmation", "TranslationQuiz", "WordList", "WordMatchQuiz", "Luk/ac/aber/dcs/cs31620/languageapp/ui/navigation/Screen$Home;", "Luk/ac/aber/dcs/cs31620/languageapp/ui/navigation/Screen$WordList;", "Luk/ac/aber/dcs/cs31620/languageapp/ui/navigation/Screen$Quiz;", "Luk/ac/aber/dcs/cs31620/languageapp/ui/navigation/Screen$Setting;", "Luk/ac/aber/dcs/cs31620/languageapp/ui/navigation/Screen$AddWord;", "Luk/ac/aber/dcs/cs31620/languageapp/ui/navigation/Screen$SettingConfirmation;", "Luk/ac/aber/dcs/cs31620/languageapp/ui/navigation/Screen$EditWord;", "Luk/ac/aber/dcs/cs31620/languageapp/ui/navigation/Screen$TranslationQuiz;", "Luk/ac/aber/dcs/cs31620/languageapp/ui/navigation/Screen$ScrambleQuiz;", "Luk/ac/aber/dcs/cs31620/languageapp/ui/navigation/Screen$WordMatchQuiz;", "app_debug"})
public abstract class Screen {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String route;
    
    private Screen(java.lang.String route) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRoute() {
        return null;
    }
    
    public final void setRoute(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Luk/ac/aber/dcs/cs31620/languageapp/ui/navigation/Screen$Home;", "Luk/ac/aber/dcs/cs31620/languageapp/ui/navigation/Screen;", "()V", "app_debug"})
    public static final class Home extends uk.ac.aber.dcs.cs31620.languageapp.ui.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final uk.ac.aber.dcs.cs31620.languageapp.ui.navigation.Screen.Home INSTANCE = null;
        
        private Home() {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Luk/ac/aber/dcs/cs31620/languageapp/ui/navigation/Screen$WordList;", "Luk/ac/aber/dcs/cs31620/languageapp/ui/navigation/Screen;", "()V", "app_debug"})
    public static final class WordList extends uk.ac.aber.dcs.cs31620.languageapp.ui.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final uk.ac.aber.dcs.cs31620.languageapp.ui.navigation.Screen.WordList INSTANCE = null;
        
        private WordList() {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Luk/ac/aber/dcs/cs31620/languageapp/ui/navigation/Screen$Quiz;", "Luk/ac/aber/dcs/cs31620/languageapp/ui/navigation/Screen;", "()V", "app_debug"})
    public static final class Quiz extends uk.ac.aber.dcs.cs31620.languageapp.ui.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final uk.ac.aber.dcs.cs31620.languageapp.ui.navigation.Screen.Quiz INSTANCE = null;
        
        private Quiz() {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Luk/ac/aber/dcs/cs31620/languageapp/ui/navigation/Screen$Setting;", "Luk/ac/aber/dcs/cs31620/languageapp/ui/navigation/Screen;", "()V", "app_debug"})
    public static final class Setting extends uk.ac.aber.dcs.cs31620.languageapp.ui.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final uk.ac.aber.dcs.cs31620.languageapp.ui.navigation.Screen.Setting INSTANCE = null;
        
        private Setting() {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Luk/ac/aber/dcs/cs31620/languageapp/ui/navigation/Screen$AddWord;", "Luk/ac/aber/dcs/cs31620/languageapp/ui/navigation/Screen;", "()V", "app_debug"})
    public static final class AddWord extends uk.ac.aber.dcs.cs31620.languageapp.ui.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final uk.ac.aber.dcs.cs31620.languageapp.ui.navigation.Screen.AddWord INSTANCE = null;
        
        private AddWord() {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Luk/ac/aber/dcs/cs31620/languageapp/ui/navigation/Screen$SettingConfirmation;", "Luk/ac/aber/dcs/cs31620/languageapp/ui/navigation/Screen;", "()V", "app_debug"})
    public static final class SettingConfirmation extends uk.ac.aber.dcs.cs31620.languageapp.ui.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final uk.ac.aber.dcs.cs31620.languageapp.ui.navigation.Screen.SettingConfirmation INSTANCE = null;
        
        private SettingConfirmation() {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u0006"}, d2 = {"Luk/ac/aber/dcs/cs31620/languageapp/ui/navigation/Screen$EditWord;", "Luk/ac/aber/dcs/cs31620/languageapp/ui/navigation/Screen;", "()V", "passID", "", "wordID", "app_debug"})
    public static final class EditWord extends uk.ac.aber.dcs.cs31620.languageapp.ui.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final uk.ac.aber.dcs.cs31620.languageapp.ui.navigation.Screen.EditWord INSTANCE = null;
        
        private EditWord() {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String passID(@org.jetbrains.annotations.NotNull()
        java.lang.String wordID) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Luk/ac/aber/dcs/cs31620/languageapp/ui/navigation/Screen$TranslationQuiz;", "Luk/ac/aber/dcs/cs31620/languageapp/ui/navigation/Screen;", "()V", "app_debug"})
    public static final class TranslationQuiz extends uk.ac.aber.dcs.cs31620.languageapp.ui.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final uk.ac.aber.dcs.cs31620.languageapp.ui.navigation.Screen.TranslationQuiz INSTANCE = null;
        
        private TranslationQuiz() {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Luk/ac/aber/dcs/cs31620/languageapp/ui/navigation/Screen$ScrambleQuiz;", "Luk/ac/aber/dcs/cs31620/languageapp/ui/navigation/Screen;", "()V", "app_debug"})
    public static final class ScrambleQuiz extends uk.ac.aber.dcs.cs31620.languageapp.ui.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final uk.ac.aber.dcs.cs31620.languageapp.ui.navigation.Screen.ScrambleQuiz INSTANCE = null;
        
        private ScrambleQuiz() {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Luk/ac/aber/dcs/cs31620/languageapp/ui/navigation/Screen$WordMatchQuiz;", "Luk/ac/aber/dcs/cs31620/languageapp/ui/navigation/Screen;", "()V", "app_debug"})
    public static final class WordMatchQuiz extends uk.ac.aber.dcs.cs31620.languageapp.ui.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final uk.ac.aber.dcs.cs31620.languageapp.ui.navigation.Screen.WordMatchQuiz INSTANCE = null;
        
        private WordMatchQuiz() {
            super(null);
        }
    }
}