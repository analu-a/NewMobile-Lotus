package br.senai.sp.jandira.lotus.screens.doula

import android.content.pm.ModuleInfo
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
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.senai.sp.jandira.lotus.R

@Composable
fun PerfilDoula(controleNavegacao: NavHostController) {

    var nomeState = remember {
        mutableStateOf("")
    }
    
    Surface(onClick = { /*TODO*/ }) {

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
                                    shape = RoundedCornerShape(50.dp),
                                    clip = false
                                )
                                .height(110.dp)
                                .width(110.dp)
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
                                .size(100.dp)
                                .clip(RoundedCornerShape(50.dp))

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
                    Text(text = "Perfil de Juliana",
                        color = Color(0xff7C7C7C),
                        fontSize = 20.sp)


                    // Outros dados do usuário


                }

                    Row(modifier = Modifier.height(160.dp)) {

                        Text(text = "NavBar")
                    }
            }





        }


        
    }

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PerfilDoulaPreview() {
    PerfilDoula(controleNavegacao = rememberNavController())
}
