package uk.ac.aber.dcs.cs31620.languageapp.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopLevelScaffold(
    pageContent:
    @Composable (innerPadding : PaddingValues) -> Unit = { }
) {
    Scaffold(
        topBar = {
            MainPageTopAppBar()
        },
        bottomBar = {
            MainPageNavigationBar()
        },
        content = { innerPadding ->
            pageContent(innerPadding)
        }
    )
}