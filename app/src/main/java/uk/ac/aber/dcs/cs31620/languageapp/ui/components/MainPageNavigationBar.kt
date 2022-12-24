package uk.ac.aber.dcs.cs31620.languageapp.ui.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import uk.ac.aber.dcs.cs31620.languageapp.ui.navigation.Screen
import uk.ac.aber.dcs.cs31620.languageapp.ui.navigation.screens
import uk.ac.aber.dcs.cs31620.languageapp.ui.theme.LanguageAppTheme
import uk.ac.aber.dcs.cs31620.languageapp.R

//@Composable
//fun MainPageNavigationBar(navController: NavController) {
//    val icons = mapOf(
//        Screen.Home to IconGroup(
//            filledIcon = Icons.Filled.Home,
//            outlineIcon = Icons.Outlined.Home,
//            label = stringResource(id = R.string.home)
//        ),
//        Screen.WordList to IconGroup(
//            filledIcon = Icons.Filled.Pets,
//            outlineIcon = Icons.Outlined.Pets,
//            label = stringResource(id = R.string.word_list)
//        )
//    )
//
//    NavigationBar {
//        val navBackStackEntry by navController.currentBackStackEntryAsState()
//        val currentDestination = navBackStackEntry?.destination
//        screens.forEach { screen ->
//            val isSelected = currentDestination?.hierarchy?.any { it.route == screen.route } == true
//            val labelText = icons[screen]!!.label
//            NavigationBarItem(
//                icon = {
//                    Icon(
//                        imageVector = (if (isSelected)
//                            icons[screen]!!.filledIcon
//                        else
//                            icons[screen]!!.outlineIcon),
//                        contentDescription = labelText
//                    )
//                },
//                label = { Text(labelText) },
//                selected = isSelected,
//                onClick = {
//                    navController.navigate(screen.route) {
//                        // Pop up to the start destination of the graph to
//                        // avoid building up a large stack of destinations
//                        // on the back stack as users select items
//                        popUpTo(navController.graph.findStartDestination().id) {
//                            saveState = true
//                        }
//                        // Avoid multiple copies of the same destination when
//                        // reselecting the same item
//                        launchSingleTop = true
//                        // Restore state when reselecting a previously selected item
//                        restoreState = true
//                    }
//                }
//            )
//        }
//    }
//}

@Composable
fun MainPageNavigationBar(){
    val icons = listOf(
        IconGroup(
            filledIcon = Icons.Filled.Home,
            outlineIcon = Icons.Outlined.Home,
            label = stringResource(id = R.string.home)
        ),
        IconGroup(
            filledIcon = Icons.Filled.List,
            outlineIcon = Icons.Outlined.List,
            label = stringResource(id = R.string.word_list)
        ),
        IconGroup(
            filledIcon = Icons.Filled.ChatBubble,
            outlineIcon = Icons.Outlined.ChatBubble,
            label = stringResource(id = R.string.quiz)
        )
    )

    NavigationBar{
        icons.forEach {
            iconGroup ->
            val isSelected = false
            val labelText = iconGroup.label
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = (
                                if (isSelected)
                                    iconGroup.filledIcon
                                else
                                    iconGroup.outlineIcon
                                ),
                        contentDescription = labelText
                    )
                },
                label = { Text(labelText) },
                selected = isSelected,
                onClick = { }
            )

        }
    }
}



@Preview
@Composable
private fun MainPageNavigationBarPreview() {
    val navController = rememberNavController()
    LanguageAppTheme(dynamicColor = false) {
        MainPageNavigationBar()
    }
}