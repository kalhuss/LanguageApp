package uk.ac.aber.dcs.cs31620.languageapp.ui.components

import androidx.compose.ui.graphics.vector.ImageVector

/**
 * A group of icons used in the app.
 *
 * @param filledIcon The filled version of the icon.
 * @param outlineIcon The outline version of the icon.
 * @param label The label for the icon group.
 */
data class IconGroup(
    val filledIcon: ImageVector,
    val outlineIcon: ImageVector,
    val label: String
)