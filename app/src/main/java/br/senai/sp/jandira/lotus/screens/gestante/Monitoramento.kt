package br.senai.sp.jandira.lotus.screens.gestante

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun MonitoramentoGestante(controleNavegacao: NavHostController) {

    Surface(modifier = Modifier.fillMaxSize()) {

        Column (modifier = Modifier
            .padding(vertical = 28.dp)
            .fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally){

            Row (verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()){
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
                Text(text = "Monitoramento",
                    color = Color(0xff807D7D),
                    fontSize = 24.sp)

                Icon(
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = "Buscar",
                    tint = Color(0x007C7C7C),
                    modifier = Modifier
                        .height(50.dp)
                        .width(50.dp)
                )

            }
            
            Spacer(modifier = Modifier.height(12.dp))

            Button(onClick = {



            },
                shape = RoundedCornerShape(66.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color((0xffFFAEBF)))
            ) {
                Row (
                    modifier = Modifier
                        .width(280.dp)
                        .height(28.dp)
                    ,
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ){
                    Text(text = "Adicionar Monitoramento",
                        fontSize = 18.sp
                    )

                }
            }

            ModalMonitoramento()

            ModalMonitoramento()


        }

    }

}

@Composable
fun ModalMonitoramento(modifier: Modifier = Modifier) {

    Surface (modifier = Modifier.fillMaxWidth()){
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
                    text = "09/12/2024",

                    color = Color(0xFFFEB491),
                    fontSize = 18.sp,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(bottom = 8.dp) // Espaçamento entre os textos
                )
                Row {
                    Text("Feliz",
                        color = Color(0xff807D7D),)
                    Spacer(modifier.width(6.dp))
                    Text("Enjoada",

                        color = Color(0xff807D7D),)
                    Spacer(modifier.width(6.dp))
                    Text("Sociavel",

                        color = Color(0xff807D7D),)
                }
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun MonitoramentoGestantePreview() {
    MonitoramentoGestante(controleNavegacao = rememberNavController())
}