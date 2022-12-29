package uk.ac.aber.dcs.cs31620.languageapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uk.ac.aber.dcs.cs31620.languageapp.model.Language
import uk.ac.aber.dcs.cs31620.languageapp.model.Word

@Composable
fun WordCard(word: Word, language: Language) {
    Card(
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier.padding(8.dp).fillMaxWidth()
    ) {
        Row {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = language.nativeLanguage,
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colors.onBackground
                    )
                )
                Text(
                    text = word.nativeWord,
                    style = TextStyle(
                        fontSize = 18.sp,
                        color = MaterialTheme.colors.onBackground
                    )
                )
            }
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = language.foreignLanguage,
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colors.onBackground
                    )
                )
                Text(
                    text = word.foreignWord,
                    style = TextStyle(
                        fontSize = 18.sp,
                        color = MaterialTheme.colors.onBackground
                    )
                )
            }
        }
    }
}


