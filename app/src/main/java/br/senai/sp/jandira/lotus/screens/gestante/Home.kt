package br.senai.sp.jandira.lotus.screens.gestante

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.senai.sp.jandira.lotus.R

@Composable
fun HomeGestante(controleNavegacao: NavHostController, id : String) {
Log.i("CALMA",id.toString())
    Surface(onClick = { /*TODO*/ }) {

        Column(verticalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxSize().padding(vertical = 24.dp)) {

            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically

            ){

                Column(verticalArrangement = Arrangement.SpaceBetween
                ){

                    Surface(modifier = Modifier
                        .width(50.dp)
                        .height(50.dp)
                        )
                    {
                        Image(painter = painterResource(id = R.drawable.lotus), contentDescription = "Lotus Icon")
                    }
                    Text(text = "Home Gestante")

                }

                Image(
                    painter = painterResource(id = R.drawable.mulher),
                    contentDescription = "",
                    modifier = Modifier
                        .size(50.dp)
                        .clip(RoundedCornerShape(50.dp))
                        .clickable {
                            controleNavegacao.navigate("perfilgestante/${id}")

                        },
                )
            }

            Column(modifier = Modifier.fillMaxWidth().padding(vertical = 28.dp) , horizontalAlignment = Alignment.CenterHorizontally) {


                Row() {

                    Button(onClick = { controleNavegacao.navigate("agendagestante") },
                        Modifier
                            .height(120.dp)
                            .width(120.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color((0xffFEB491)))) {
                        Text(text = "Agenda")

                    }
                    Spacer(modifier = Modifier.width(28.dp))
                    Button(onClick = { controleNavegacao.navigate("checklistgestante") },
                        Modifier
                            .height(120.dp)
                            .width(120.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color((0xffFFAEBF)))) {
                        Text(text = "CheckList")

                    }
                }
                Spacer(modifier = Modifier.height(14.dp))
                Row() {

                    Button(onClick = { controleNavegacao.navigate("conteudogestante") },
                        Modifier
                            .height(120.dp)
                            .width(120.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color((0xffFFAEBF)))) {
                        Text(text = "Conteúdos")

                    }
                    Spacer(modifier = Modifier.width(28.dp))
                    Button(onClick = { controleNavegacao.navigate("galeriagestante") },
                        Modifier
                            .height(120.dp)
                            .width(120.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color((0xffFEB491)))) {
                        Text(text = "Galeria")

                    }
                }
                Spacer(modifier = Modifier.height(14.dp))
                Row() {

                    Button(onClick = { controleNavegacao.navigate("monitoramentogestante") },
                        Modifier
                            .height(60.dp)
                            .width(260.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color((0xffFFAEBF)))) {
                        Text(text = "Monitoramento")

                    }

                }



            }


        }

    }

}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun HomeGestantePreview() {
    HomeGestante(controleNavegacao = rememberNavController(), id = "1")
}
