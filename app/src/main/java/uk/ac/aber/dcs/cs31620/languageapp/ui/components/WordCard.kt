package uk.ac.aber.dcs.cs31620.languageapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
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

//@Composable
//fun WordCard(word: Word, language: Language) {
//    Card(
//        shape = RoundedCornerShape(4.dp),
//        modifier = Modifier.padding(8.dp).fillMaxWidth()
//    ) {
//        Row {
//            Column(
//                modifier = Modifier.weight(1f)
//            ) {
//                Text(
//                    text = language.nativeLanguage,
//                    style = TextStyle(
//                        fontSize = 14.sp,
//                        fontWeight = FontWeight.Bold,
//                        color = MaterialTheme.colors.onBackground
//                    )
//                )
//                Text(
//                    text = word.nativeWord,
//                    style = TextStyle(
//                        fontSize = 18.sp,
//                        color = MaterialTheme.colors.onBackground
//                    )
//                )
//            }
//            Column(
//                modifier = Modifier.weight(1f)
//            ) {
//                Text(
//                    text = language.foreignLanguage,
//                    style = TextStyle(
//                        fontSize = 14.sp,
//                        fontWeight = FontWeight.Bold,
//                        color = MaterialTheme.colors.onBackground
//                    )
//                )
//                Text(
//                    text = word.foreignWord,
//                    style = TextStyle(
//                        fontSize = 18.sp,
//                        color = MaterialTheme.colors.onBackground
//                    )
//                )
//            }
//        }
//    }
//}

@Composable
fun WordCard(navController: NavHostController, word: Word, language: Language) {
    val textStyle = TextStyle(fontSize = 18.sp, color = MaterialTheme.colors.onBackground)
    val subheadStyle = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colors.onBackground)
    val isIconButtonClicked = remember { mutableStateOf(false) }
    Card(
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier.padding(8.dp).fillMaxWidth().shadow(4.dp, RoundedCornerShape(4.dp))
    ) {
        Row(){
            Column(modifier = Modifier.padding(16.dp).weight(1f)) {
                Text(text = language.nativeLanguage, style = subheadStyle)
                Text(text = word.nativeWord, style = textStyle)
            }
            Column(modifier = Modifier.padding(16.dp).weight(1f)){
                Text(text = language.foreignLanguage, style = subheadStyle)
                Text(text = word.foreignWord, style = textStyle)

            }
            IconButton(onClick = {
                navController.navigate(Screen.EditWord.route){
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
                    imageVector = (if(isIconButtonClicked.value)
                        Icons.Filled.Edit else Icons.Outlined.Edit),
                    contentDescription = stringResource(R.string.edit),
                )
            }
        }
    }
}


