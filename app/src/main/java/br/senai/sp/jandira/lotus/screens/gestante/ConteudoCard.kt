package br.senai.sp.jandira.lotus.screens.gestante

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
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
fun CardConteudo(controleNavegacao: NavHostController) {


    Surface(modifier = Modifier.fillMaxSize()) {

        Column (modifier = Modifier
            .padding(vertical = 28.dp)
            .fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
            Column {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowLeft,
                        contentDescription = "Buscar",
                        tint = Color(0xff7C7C7C),
                        modifier = Modifier
                            .height(50.dp)
                            .width(50.dp)
                            .clickable {
                                controleNavegacao.navigate("conteudoCard")
                            }
                    )
                    Text(
                        text = "Conteúdos",
                        color = Color(0xffFFAEBF),
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


                Text("Desvendando a amamentação")
                Text("O roteiro de ouro deve ser: parto normal, bebê no peito, amamentação na primeira hora de vida, livre demanda daí em diante, aleitamento materno exclusivo até os seis meses, e, segundo a Organização Mundial da Saúde, manutenção da amamentação até os dois anos ou mais.\n" +
                        "Assim como no parto, eu queria o melhor, racionalmente o melhor, ou seja, aleitamento materno exclusivo. E se existem mil perfis na internet, cursos, livros para os diversos assuntos ligados ao universo da parentalidade, aqui ainda existem profissões e ramificações de profissões (as consultoras em amamentação) destinadas a ajudar no roteiro que seria tão natural. O que mostra que não é tão natural assim. Aliás, já não somos naturais há um bom tempo. É claro que o instinto fica mais presente ao sermos tão mamíferos quanto no ato de dar de mamar, mas, eu ouvi mais relatos de pessoas com dificuldades do que aqueles em que tudo correu simplesmente 100%, beleza pura, mamão com açúcar.")
            }
        }

    }
}

@Preview
@Composable
private fun CardConteudoPreview() {
    CardConteudo(controleNavegacao = rememberNavController())
    
}
