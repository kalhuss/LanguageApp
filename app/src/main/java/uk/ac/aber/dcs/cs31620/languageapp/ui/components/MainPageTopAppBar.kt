@file:Suppress("OPT_IN_IS_NOT_ENABLED")

package uk.ac.aber.dcs.cs31620.languageapp.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import uk.ac.aber.dcs.cs31620.languageapp.R
import uk.ac.aber.dcs.cs31620.languageapp.ui.theme.LanguageAppTheme

/**
 * Represents a top app bar component using M3 CenterAlignedTopAppBar.
 * Has a menu button icon and the app name.
 * @param onClick: provides the behaviour for the menu icon or
 * an empty lambda if not provided.
 * @author Chris Loftus
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainPageTopAppBar(
    onClick: () -> Unit = {}
){
    CenterAlignedTopAppBar(
        title = { Text(stringResource(id = R.string.app_name)) },
        // An example of changing the default colours
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
        ),
        navigationIcon = {
            IconButton(onClick = onClick) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = stringResource(R.string.nav_drawer_menu)
                )
            }
        }
    )
}

@Preview
@Composable
private fun MainPageTopAppBarPreview() {
    LanguageAppTheme(dynamicColor = false) {
        MainPageTopAppBar()
    }
}