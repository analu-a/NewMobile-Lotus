package br.senai.sp.jandira.lotus.screens.gestante

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import java.util.Calendar
import java.util.Locale

@Composable
fun AgendaGestante(controleNavegacao: NavHostController) {

    Surface(modifier = Modifier.fillMaxSize()) {

        Column (modifier = Modifier
            .padding(vertical = 28.dp)
            .fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = "Voltar",
                    tint = Color(0xff7C7C7C),
                    modifier = Modifier
                        .height(50.dp)
                        .width(50.dp)
                        .clickable {
                            controleNavegacao.navigate("homegestante")
                        }
                )
                Text(
                    text = "Agenda",
                    color = Color(0xff807D7D),
                    fontSize = 24.sp
                )

                Icon(
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = "Buscar",
                    tint = Color(0x007C7C7C),
                    modifier = Modifier
                        .height(50.dp)
                        .width(50.dp)
                )

            }

            Spacer(modifier = Modifier.height(16.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(12.dp)
                    .border(4.dp, Color(0xFFFFDAE0), RoundedCornerShape(16.dp))){
                CalendarView()

                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    modifier = Modifier.height(50.dp),
                    onClick = { /* Ação do botão */ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xffFFAEBF),
                        contentColor = Color.White
                    )) {

                  Text("Adicionar evento")
                }

                Spacer(modifier = Modifier.height(12.dp))
            }

            Spacer(modifier = Modifier.height(12.dp))
          Row (modifier = Modifier.fillMaxWidth().padding(start = 12.dp)) {
              Text("Eventos marcados:",
                      color = Color(0xff807D7D),
                      fontSize = 18.sp)
          }

            Box (
                modifier = Modifier
                    .fillMaxWidth() // Preenche a largura total
                    .padding(16.dp) // Adiciona padding externo
                    .background(Color(0x20FEB491), shape = RoundedCornerShape(16.dp)) // Define a cor de fundo rosa claro com cantos arredondados
                    .border(2.dp, Color(0xFFFEB491), RoundedCornerShape(16.dp)) // Adiciona borda laranja
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp), // Padding interno do Card
                    horizontalAlignment = Alignment.CenterHorizontally // Alinha os textos ao centro
                ) {
                    Text(
                        text = "Consulta Hospitalis",

                        color = Color(0xFFFEB491),
                        fontSize = 18.sp,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(bottom = 8.dp) // Espaçamento entre os textos
                    )
                    Text(
                        text = "24/12/2023",
                        color = Color(0xff807D7D),
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }

        }

    }

}

@Composable
fun CalendarView() {
    val currentMonth = Calendar.getInstance()
    val daysOfWeek = listOf("Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat")
    val currentMonthDays = getDaysInMonth(currentMonth)

    Column(modifier = Modifier.padding(16.dp)) {
        // Header: Show the current month and year
        Text(
            text = "${currentMonth.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault())} ${currentMonth.get(Calendar.YEAR)}",
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp, color = Color(
                0xFFFFBFC7
            )
            ),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Days of the week
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            daysOfWeek.forEach { day ->
                Text(text = day, modifier = Modifier.weight(1f), style = TextStyle(fontWeight = FontWeight.Bold, color = Color(0xff807D7D)))
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Calendar grid with the days
        LazyVerticalGrid (
            columns = GridCells.Fixed(7), // 7 columns for 7 days of the week
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(4.dp)
        ) {
            items(currentMonthDays.size) { index ->
                val day = currentMonthDays[index]
                DayCell(day)
            }
        }
    }
}

@Composable
fun DayCell(day: Int) {
    Box(
        modifier = Modifier
            .padding(4.dp)
            .size(40.dp) .let { boxModifier ->
                if (day == 10) {

                    boxModifier.background(Color(0xffFFAEBF) , shape = RoundedCornerShape(30.dp))
                       // Highlighting day 1
                } else {
                    boxModifier
                }
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = day.toString(),
            style = TextStyle(fontWeight = FontWeight.Bold, color = Color(0xff807D7D))
        )
    }
}

fun getDaysInMonth(calendar: Calendar): List<Int> {
    val daysInMonth = mutableListOf<Int>()
    calendar.set(Calendar.DAY_OF_MONTH, 1)
    val firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1 // Calendar's first day of the week starts on Sunday, adjust to 0-6 range
    val maxDaysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)

    // Fill in the leading empty days before the first day of the month
    for (i in 0 until firstDayOfWeek) {
        daysInMonth.add(0)
    }

    // Add the actual days of the month
    for (day in 1..maxDaysInMonth) {
        daysInMonth.add(day)
    }

    return daysInMonth
}


@Preview(showBackground = true)
@Composable
fun AgendaGestantePreview() {
    AgendaGestante(controleNavegacao = rememberNavController())
}