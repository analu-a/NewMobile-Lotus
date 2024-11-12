package br.senai.sp.jandira.lotus.screens.gestante

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.senai.sp.jandira.lotus.R

@Composable
fun CheckListGestante(controleNavegacao: NavHostController) {

    Surface(onClick = { /*TODO*/ }) {

        var pesquisaState = remember {
            mutableStateOf("")
        }

        var checkState = remember {
            mutableStateOf(false)
        }

        Column (modifier = Modifier
            .padding(vertical = 28.dp)
            .fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween){

            Column {
                Row (verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()){
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowLeft,
                        contentDescription = "Buscar",
                        tint = Color(0xff7C7C7C),
                        modifier = Modifier
                            .height(50.dp)
                            .width(50.dp)
                            .clickable {
                                controleNavegacao.navigate("homegestante")
                            }
                    )
                    Text(text = "Monte seu enxoval",
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



                Column(modifier = Modifier.padding(horizontal = 28.dp)) {

                    Divider(modifier = Modifier.height(2.dp).background(Color(0xFFF6F6F6)))
                    Spacer(modifier = Modifier.height(12.dp))

                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp)
                        .shadow(2.dp, RoundedCornerShape(12.dp), ambientColor = Color(0xFF7C7778)),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,


                    ) {
                        Row( verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Checkbox(
                                checked = checkState.value,
                                onCheckedChange = {
                                    checkState.value = it
                                },
                                colors = CheckboxDefaults
                                    .colors(
                                        checkedColor = Color(0xffCF06F0),
                                        uncheckedColor = Color(0xffFEB491)
                                    )
                            )
                            Text(text = "Mamadeira")
                        }



                        Card( modifier = Modifier.padding(12.dp),colors = CardDefaults.cardColors(containerColor = Color(0xffFFAEBF))) {
                            Icon(
                                imageVector = Icons.Default.Clear,
                                contentDescription = "Buscar",
                                tint = Color(0xFFFFFFFF),
                                modifier = Modifier
                                    .height(20.dp)
                                    .width(20.dp)
                                    .clickable {

                                    }
                            )
                        }
                    }


                }
            }

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 28.dp)) {
                    OutlinedTextField(
                        value = pesquisaState.value,
                        onValueChange = {
                            pesquisaState.value = it
                        },
                        label = {
                            Text(text = "Adicionar novo item...")
                        },
                        colors = OutlinedTextFieldDefaults
                            .colors(
                                focusedBorderColor = Color(0xffFFAEBF),
                                unfocusedBorderColor = Color(0xffFFAEBF),
                                focusedPlaceholderColor = Color(0x00FFAEBF),
                                focusedContainerColor =  Color(0x2FFFAEBF),
                                focusedTextColor = Color(0xffFFAEBF),
                                unfocusedTextColor = Color(0xffFFAEBF),
                            ),
                        shape = RoundedCornerShape(36.dp),
                        maxLines = 1,
                        modifier = Modifier.width(210.dp)
                    )
                    Spacer(modifier = Modifier.width(12.dp))

                    Button(
                        modifier = Modifier.height(50.dp),
                        onClick = { /* Ação do botão */ },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xffFFAEBF),
                            contentColor = Color.White
                        )) {

                        Icon(imageVector = Icons.Default.Check,
                            contentDescription = "",
                            tint = Color(0xffFFFFFF),
                        )
                    }


                }
            }


        }

    }

}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun CheckListGestantePreview() {
    CheckListGestante(controleNavegacao = rememberNavController())
}

