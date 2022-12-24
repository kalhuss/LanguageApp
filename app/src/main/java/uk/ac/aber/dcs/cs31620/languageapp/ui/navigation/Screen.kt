package uk.ac.aber.dcs.cs31620.languageapp.ui.navigation

sealed class Screen(
    val route: String
) {
    object Home : Screen("Home")
    object WordList : Screen("WordList")
    object Quiz : Screen("Quiz")
}

val screens = listOf(
    Screen.Home,
    Screen.WordList,
    Screen.Quiz
)