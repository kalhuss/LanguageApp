package uk.ac.aber.dcs.cs31620.languageapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import uk.ac.aber.dcs.cs31620.languageapp.R
import uk.ac.aber.dcs.cs31620.languageapp.model.Language
import uk.ac.aber.dcs.cs31620.languageapp.model.Word
import uk.ac.aber.dcs.cs31620.languageapp.ui.navigation.Screen

@Composable
fun WordCard(navController: NavHostController, word: Word, language: Language) {
    val textStyle = TextStyle(fontSize = 18.sp)
    val subheadStyle = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Bold)
    val isIconButtonClicked = remember { mutableStateOf(false) }
    val wordID = remember { mutableStateOf(0)}

    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Card(
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier.padding(8.dp).fillMaxWidth().shadow(4.dp, RoundedCornerShape(4.dp))
        ) {
            Row() {
                Column(modifier = Modifier.padding(16.dp).weight(1f)) {
                    Text(text = language.nativeLanguage, style = subheadStyle)
                    Text(text = word.nativeWord, style = textStyle)
                }
                Column(modifier = Modifier.padding(16.dp).weight(1f)) {
                    Text(text = language.foreignLanguage, style = subheadStyle)
                    Text(text = word.foreignWord, style = textStyle)

                }
                IconButton(
                    onClick = {
                        wordID.value = word.id
                        navController.navigate(Screen.EditWord.passID(wordID.value.toString())) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                        isIconButtonClicked.value = !isIconButtonClicked.value
                    },
                    modifier = Modifier.align(Alignment.CenterVertically)
                ) {
                    Icon(
                        imageVector = (if (isIconButtonClicked.value)
                            Icons.Filled.Edit else Icons.Outlined.Edit),
                        contentDescription = stringResource(R.string.edit),
                    )
                }
            }
        }
    }
}


