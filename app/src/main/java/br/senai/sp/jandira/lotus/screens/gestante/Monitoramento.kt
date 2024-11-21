package br.senai.sp.jandira.lotus.screens.gestante

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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

        }

    }

}

@Composable
fun ModalMonitoramento(modifier: Modifier = Modifier) {

    Surface (modifier = Modifier.fillMaxWidth()){
        Column(modifier = Modifier.padding(16.dp).height(55.dp).background(Color(0xFFE7DADB)).width(80.dp)) {
            Text("24/09")
            Text("Feliz")
        }
    }
    
}


@Preview(showBackground = true)
@Composable
fun MonitoramentoGestantePreview() {
    MonitoramentoGestante(controleNavegacao = rememberNavController())
}