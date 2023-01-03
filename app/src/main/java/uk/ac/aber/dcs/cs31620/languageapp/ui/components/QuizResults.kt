package uk.ac.aber.dcs.cs31620.languageapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun QuizResults(score: Int, total: Int, onFinish: () -> Unit) {
    Column(modifier = Modifier.padding(16.dp).fillMaxHeight().wrapContentSize(Alignment.Center)) {
        Column(modifier = Modifier.padding(bottom = 40.dp)) {
            Text(
                text = "Your scored $score/$total",
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
            )
            val percentage = (score * 100f / total).toInt()
            Text(
                text = "$percentage%",
                style = MaterialTheme.typography.headlineSmall,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
        Button(
            onClick = onFinish,
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier
                .padding(top = 8.dp, bottom = 8.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text("BACK TO QUIZ")
        }
    }
}


