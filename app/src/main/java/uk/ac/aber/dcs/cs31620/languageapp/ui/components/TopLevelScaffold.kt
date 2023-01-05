package uk.ac.aber.dcs.cs31620.languageapp.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import kotlinx.coroutines.CoroutineScope

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopLevelScaffold(
    navController: NavHostController,
    titleName: String,
    snackbarContent: @Composable (SnackbarData) -> Unit = {},
    snackbarHostState: SnackbarHostState? = null,
    pageContent: @Composable (innerPadding : PaddingValues) -> Unit = { },

    ) {
    Scaffold(
        topBar = {
            MainPageTopAppBar(navController, titleName)
        },
        bottomBar = {
            MainPageNavigationBar(navController)
        },
        snackbarHost = {
            snackbarHostState?.let {
                SnackbarHost(hostState = snackbarHostState) { data ->
                    snackbarContent(data)
                }
            }
        },
        content = { innerPadding ->
            pageContent(innerPadding)
        }
    )
}
