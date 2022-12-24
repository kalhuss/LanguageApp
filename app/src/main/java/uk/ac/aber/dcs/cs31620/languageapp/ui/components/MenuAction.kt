package uk.ac.aber.dcs.cs31620.languageapp.ui.components

import uk.ac.aber.dcs.cs31620.languageapp.R
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class MenuAction(
    val label: Int,
    val icon: ImageVector,
){
    object Settings : MenuAction(R.string.settings, Icons.Filled.Settings)
}

