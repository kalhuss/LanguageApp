package uk.ac.aber.dcs.cs31620.languageapp.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

/**
 * A top-level scaffold for the app.
 *
 * This function creates a top app bar, a main content area, and a bottom navigation bar and puts them together in a
 * [Scaffold] layout.
 *
 * @param navController The navigation controller for the app.
 * @param titleName The title to display in the top app bar.
 * @param pageContent A composable that creates the main content of the app. It takes a [PaddingValues] parameter to
 * specify the inner padding of the content.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopLevelScaffold(
    navController: NavHostController,
    titleName: String,
    pageContent: @Composable (innerPadding : PaddingValues) -> Unit = { },

    ) {
    Scaffold(
        topBar = {
            MainPageTopAppBar(navController, titleName)
        },
        bottomBar = {
            MainPageNavigationBar(navController)
        },

        content = { innerPadding ->
            pageContent(innerPadding)
        }
    )
}
