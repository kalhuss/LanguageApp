package uk.ac.aber.dcs.cs31620.languageapp.ui.navigation

sealed class Screen(
    val route: String
) {
    object Home : Screen("Home")
    object WordList : Screen("WordList")
    object Quiz : Screen("Quiz")
    object Setting : Screen("Setting")
    object AddWord : Screen("AddWord")
    object SettingConfirmation : Screen("SettingConfirmation")
}

val screens = listOf(
    Screen.Home,
    Screen.WordList,
    Screen.Quiz
)