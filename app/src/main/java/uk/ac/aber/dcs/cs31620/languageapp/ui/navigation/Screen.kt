package uk.ac.aber.dcs.cs31620.languageapp.ui.navigation

var WORD_ID = "wordID"

/**
 * A list of screens in the app.
 *
 * @param route The route for the screen.
 */
sealed class Screen(
    var route: String
) {
    // List of the different screens
    object Home : Screen("Home")
    object WordList : Screen("WordList")
    object Quiz : Screen("Quiz")
    object Setting : Screen("Setting")
    object AddWord : Screen("AddWord")
    object SettingConfirmation : Screen("SettingConfirmation")
    // Pass the word ID to the edit word screen so it can update data
    object EditWord : Screen("EditWord/{$WORD_ID}"){
        fun passID(wordID: String): String {
            EditWord.route = "EditWord/$wordID"
            return EditWord.route
        }
    }
    object TranslationQuiz : Screen("TranslationQuiz")
    object ScrambleQuiz : Screen("ScrambleQuiz")
    object WordMatchQuiz : Screen("WordMatchQuiz")
}

// The screens in the navigation bar
val screens = listOf(
    Screen.Home,
    Screen.WordList,
    Screen.Quiz
)