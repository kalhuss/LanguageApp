package uk.ac.aber.dcs.cs31620.languageapp.ui.navigation

var WORD_ID = "wordID"

sealed class Screen(
    var route: String
) {
    object Home : Screen("Home")
    object WordList : Screen("WordList")
    object Quiz : Screen("Quiz")
    object Setting : Screen("Setting")
    object AddWord : Screen("AddWord")
    object SettingConfirmation : Screen("SettingConfirmation")
    object EditWord : Screen("EditWord/{$WORD_ID}"){
        fun passID(wordID: String): String {
            EditWord.route = "EditWord/$wordID"
            return EditWord.route
        }
    }
    object TranslationQuiz : Screen("TranslationQuiz")
    object ScrambleQuiz : Screen("ScrambleQuiz")
}

val screens = listOf(
    Screen.Home,
    Screen.WordList,
    Screen.Quiz
)