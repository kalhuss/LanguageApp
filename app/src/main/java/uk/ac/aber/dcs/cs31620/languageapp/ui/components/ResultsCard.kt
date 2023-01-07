package uk.ac.aber.dcs.cs31620.languageapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ResultsCard(quizName: String, quizScore: String){

    val textStyle = TextStyle(fontSize = 18.sp)

    Card(
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp).fillMaxWidth().shadow(4.dp, RoundedCornerShape(4.dp))
    ){
        Row {
            Text(text = quizName, style = textStyle, modifier = Modifier.padding(16.dp).weight(2f))
            Spacer(Modifier.weight(1f))
            Text(text = quizScore, style = textStyle, modifier = Modifier.padding(16.dp).weight(1f).align(Alignment.CenterVertically))
        }
    }
}