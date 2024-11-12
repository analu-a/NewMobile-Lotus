package br.senai.sp.jandira.lotus.screens.gestante

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.senai.sp.jandira.lotus.R
import br.senai.sp.jandira.lotus.model.Gestante
import br.senai.sp.jandira.lotus.service.RetrofitFactory
import br.senai.sp.jandira.lotus.model.Results
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


@Composable
fun PerfilGestante(controleNavegacao: NavHostController) {
    val context = LocalContext.current
    var gestante by remember { mutableStateOf(Gestante()) }
    val id = 1

    val callGestante = RetrofitFactory().getGestanteService().getGestanteById(id)
    callGestante.enqueue(object : Callback<Gestante> {
        override fun onResponse(call: Call<Gestante>, response: Response<Gestante>) {
            if (response.isSuccessful && response.body() != null) {
                gestante = response.body()!!
            } else {
                Toast.makeText(context, "Erro ao obter dados!", Toast.LENGTH_SHORT).show()
            }
        }

        override fun onFailure(call: Call<Gestante>, t: Throwable) {
            Toast.makeText(context, "Ocorreu um erro!", Toast.LENGTH_SHORT).show()
        }
    })

    Surface() {

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Column {
                Surface(
                    modifier = Modifier.height(100.dp)) {

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                color = Color(0xFFFEB491),
                                shape = RoundedCornerShape(
                                    bottomEnd = 45.dp
                                )
                            )
                    ) {}

                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(260.dp)
                            .background(
                                color = Color(0xFFFEC7AC),
                                shape = RoundedCornerShape(
                                    bottomEnd = 85.dp
                                )
                            )
                    ) {}

                    Box(
                        modifier = Modifier
                            .height(10.dp)
                            .width(140.dp)
                            .offset(y = -30.dp)
                            .background(
                                color = Color(0xFFFFD8C6),
                                shape = RoundedCornerShape(
                                    bottomEnd = 85.dp
                                )
                            )
                    ) {}
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(y = -60.dp,),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center

                ) {

                    Box(
                        contentAlignment = Alignment.Center ) {
                        Box(
                            modifier = Modifier
                                .shadow(
                                    elevation = 8.dp,
                                    shape = RoundedCornerShape(200.dp),
                                    clip = false
                                )
                                .height(160.dp)
                                .width(160.dp)
                                .background(
                                    color = Color(0xFFFFFFFF),
                                    shape = RoundedCornerShape(
                                        100.dp
                                    )
                                )
                        ) {}
                        Image(
                            painter = painterResource(id = R.drawable.mulher),
                            contentDescription = "",
                            modifier = Modifier
                                .size(150.dp)
                                .clip(RoundedCornerShape(200.dp))

                        )
                    }
                }
            }


            Column (
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxSize()
                //.background(color = Color.Blue)
            )
            {

                Column (horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize()

                ){

                    // Nome do usuário
//                    Text(text = "Perfil de Juliana",
//                        color = Color(0xff7C7C7C),
//                        fontSize = 20.sp)

                    Spacer(modifier = Modifier.height(12.dp), )

                    Card(
                        modifier = Modifier
                            .width(330.dp)
                            .height(350.dp)
                            .padding(16.dp),
                        shape = MaterialTheme.shapes.medium,
                        colors = androidx.compose.material3.CardDefaults.cardColors(
                            containerColor = Color(0xffF6F6F6))
                        ) {

                        Column (modifier = Modifier.padding(18.dp)){

                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .padding(4.dp)
                                    .fillMaxWidth()
                                    .height(32.dp)
                                    .clip(RoundedCornerShape(16.dp))
                                    .background(color = Color(0xffFFFFFF))) {
                                Spacer(modifier = Modifier.width(12.dp))
                                Text(text = "Nome:",
                                    color = Color(0xff7C7C7C))
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(text = "${gestante.nome_gestante}")
                            }

                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .padding(4.dp)
                                    .fillMaxWidth()
                                    .height(32.dp)
                                    .clip(RoundedCornerShape(16.dp))
                                    .background(color = Color(0xffFFFFFF))) {
                                Spacer(modifier = Modifier.width(12.dp))
                                Text(text = "Sobrenome:",
                                    color = Color(0xff7C7C7C))
                                Spacer(modifier = Modifier.width(6.dp))
                                Text("${gestante.sobrenome_gestante}")
                            }

                            Row (
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .padding(4.dp)
                                    .fillMaxWidth()
                                    .height(32.dp)
                                    .clip(RoundedCornerShape(16.dp))
                                    .background(color = Color(0xffFFFFFF))) {
                                Spacer(modifier = Modifier.width(12.dp))
                                Text(text = "CPF:",
                                    color = Color(0xff7C7C7C))
                                Spacer(modifier = Modifier.width(6.dp))
                                Text("${gestante.cpf_gestante}")
                            }

                            Row (
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .padding(4.dp)
                                    .fillMaxWidth()
                                    .height(32.dp)
                                    .clip(RoundedCornerShape(16.dp))
                                    .background(color = Color(0xffFFFFFF))) {
                                Spacer(modifier = Modifier.width(12.dp))
                                Text(text = "Profissao:",
                                    color = Color(0xff7C7C7C))
                                Spacer(modifier = Modifier.width(6.dp))
                                Text("${gestante.profissao_gestante}")
                            }
                            Row (
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .padding(4.dp)
                                    .fillMaxWidth()
                                    .height(32.dp)
                                    .clip(RoundedCornerShape(16.dp))
                                    .background(color = Color(0xffFFFFFF))) {
                                Spacer(modifier = Modifier.width(12.dp))
                                Text(text = "Nascimento:",
                                    color = Color(0xff7C7C7C))
                                Spacer(modifier = Modifier.width(6.dp))
                                Text("${gestante.data_nascimento_gestante}")
                            }
                            Row (
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .padding(4.dp)
                                    .fillMaxWidth()
                                    .height(32.dp)
                                    .clip(RoundedCornerShape(16.dp))
                                    .background(color = Color(0xffFFFFFF))) {
                                Spacer(modifier = Modifier.width(12.dp))
                                Text(text = "Nome do bebe:",
                                    color = Color(0xff7C7C7C))
                                Spacer(modifier = Modifier.width(6.dp))
                                Text("${gestante.nome_bebe}")
                            }
                            Row (
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .padding(4.dp)
                                    .fillMaxWidth()
                                    .height(32.dp)
                                    .clip(RoundedCornerShape(16.dp))
                                    .background(color = Color(0xffFFFFFF))) {
                                Spacer(modifier = Modifier.width(12.dp))
                                Text(text = "Semanas de gravidez:",
                                    color = Color(0xff7C7C7C))
                                Spacer(modifier = Modifier.width(6.dp))
                                Text("${gestante.semanas_de_gravidez}")
                            }
                        }

                    }

                    Button(
                        modifier = Modifier.height(40.dp),
                        onClick = { /* Ação do botão */ },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xffFFAEBF),
                            contentColor = Color.White
                        )) {

                        Icon(imageVector = Icons.Default.Create,
                            contentDescription = "",
                            tint = Color(0xffFFFFFF),
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = "Editar perfil")
                        
                    }



                    Row(modifier = Modifier
                        .height(160.dp)
                        .fillMaxWidth(), verticalAlignment = Alignment.Bottom, horizontalArrangement = Arrangement.Center) {

                       Row {

                           Column(horizontalAlignment = Alignment.CenterHorizontally){

                               Icon(imageVector = Icons.Default.Home,
                                   contentDescription = "",
                                   tint = Color(0xffBFBFBF),
                                   modifier = Modifier
                                       .height(40.dp)
                                       .width(40.dp)
                               )
                               Spacer(modifier = Modifier.height(12.dp))
                               Box(
                                   modifier = Modifier
                                       .width(60.dp)
                                       .height(4.dp)
                                       .background(Color(0xffBFBFBF))
                               )

                           }

                           Column(horizontalAlignment = Alignment.CenterHorizontally){

                               Icon(imageVector = Icons.Default.Menu,
                                   contentDescription = "",
                                   tint = Color(0xffBFBFBF),
                                   modifier = Modifier
                                       .height(40.dp)
                                       .width(40.dp)
                               )
                               Spacer(modifier = Modifier.height(12.dp))
                               Box(
                                   modifier = Modifier
                                       .width(60.dp)
                                       .height(4.dp)
                                       .background(Color(0xffBFBFBF))
                               )
                           }

                           Column(horizontalAlignment = Alignment.CenterHorizontally){

                               Icon(imageVector = Icons.Default.Favorite,
                                   contentDescription = "",
                                   tint = Color(0xffBFBFBF),
                                   modifier = Modifier
                                       .height(40.dp)
                                       .width(40.dp)
                               )
                               Spacer(modifier = Modifier.height(12.dp))
                               Box(
                                   modifier = Modifier
                                       .width(60.dp)
                                       .height(4.dp)
                                       .background(Color(0xffBFBFBF))
                               )

                           }

                           Column(horizontalAlignment = Alignment.CenterHorizontally){

                               Icon(imageVector = Icons.Default.Person,
                                   contentDescription = "",
                                   tint = Color(0xffFEB491),
                                   modifier = Modifier
                                       .height(40.dp)
                                       .width(40.dp)
                               )
                               Spacer(modifier = Modifier.height(12.dp))
                               Box(
                                   modifier = Modifier
                                       .width(60.dp)
                                       .height(4.dp)
                                       .background(Color(0xffFEB491)) // Cor personalizada
                               )

                           }
                       }
                    }
                }


            }





        }



    }



}



@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PerfilGestantePreview() {
    PerfilGestante(controleNavegacao = rememberNavController())
}
