package br.senai.sp.jandira.lotus.screens.doula

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


@Composable
fun ShowToast() {
    val context = LocalContext.current
    val text = "Cadastro concluido!"
    val duration = Toast.LENGTH_SHORT

    Toast.makeText(context, text, duration).show()
}


@Composable
fun RegisterDoula(controleNavegacao: NavHostController) {

    val context = LocalContext.current

    Surface(onClick = { /*TODO*/ }) {

        Surface(onClick = { /*TODO*/ }) {

            var nomeState = remember {
                mutableStateOf("")
            }
            var sobrenomeState = remember {
                mutableStateOf("")
            }
            var cpfState = remember {
                mutableStateOf("")
            }
            var profissaoState = remember {
                mutableStateOf("")
            }
            var nascimentoState = remember {
                mutableStateOf("")
            }


            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()

            ) {

                Row (modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)){
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowLeft,
                        contentDescription = "Buscar",
                        tint = Color(0xff7C7C7C),
                        modifier = Modifier
                            .height(50.dp)
                            .width(50.dp)
                            .clickable {
                                controleNavegacao.navigate("register")

                            }
                    )

                }
                Text(text = "Crie sua conta na",
                    color = Color(0xff7C7C7C),
                    fontSize = 16.sp,)
                Text(text = "Lótus.",
                    color = Color(0xffFFAEBF),
                    fontSize = 34.sp,
                    fontWeight = FontWeight.Bold,)

                Spacer(modifier = Modifier.height(14.dp))

                OutlinedTextField(
                    value = nomeState.value,
                    onValueChange = {
                        nomeState.value = it
                    },
                    label = {
                        Text(text = "Nome")
                    },
//                    leadingIcon = {
////                        Icon(imageVector = Icons.Default.Person,
////                            contentDescription = "",
////                            tint = Color(0xffFFAEBF),
////                        )
//                    },
                    colors = OutlinedTextFieldDefaults
                        .colors(
                            focusedBorderColor = Color(0xffBFBFBF),
                            unfocusedBorderColor = Color(0xffBFBFBF),
                        ),
                    shape = RoundedCornerShape(36.dp),
                    maxLines = 1
                )


                OutlinedTextField(
                    value = sobrenomeState.value,
                    onValueChange = {
                        sobrenomeState.value = it
                    },
                    label = {
                        Text(text = "Sobrenome")
                    },
//                    leadingIcon = {
//                        Icon(imageVector = Icons.Default.Person,
//                            contentDescription = "",
//                            tint = Color(0xffFFAEBF),
//                        )
//                    },
                    colors = OutlinedTextFieldDefaults
                        .colors(
                            focusedBorderColor = Color(0xffBFBFBF),
                            unfocusedBorderColor = Color(0xffBFBFBF),
                        ),
                    shape = RoundedCornerShape(36.dp),
                    maxLines = 1
                )

                OutlinedTextField(
                    value = cpfState.value,
                    onValueChange = {
                        cpfState.value = it
                    },
                    label = {
                        Text(text = "CPF")
                    },
                    colors = OutlinedTextFieldDefaults
                        .colors(
                            focusedBorderColor = Color(0xffBFBFBF),
                            unfocusedBorderColor = Color(0xffBFBFBF),
                        ),
                    shape = RoundedCornerShape(36.dp),
                    maxLines = 1
                )

                Spacer(modifier = Modifier.height(14.dp))

                OutlinedTextField(
                    value = profissaoState.value,
                    onValueChange = {
                        profissaoState.value = it
                    },
                    label = {
                        Text(text = "A quanto tempo é Doula")
                    },
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Create,
                            contentDescription = "",
                            tint = Color(0xffFFAEBF),
                        )
                    },
                    colors = OutlinedTextFieldDefaults
                        .colors(
                            focusedBorderColor = Color(0xffFFAEBF),
                            unfocusedBorderColor = Color(0xffFFAEBF),
                        ),
                    shape = RoundedCornerShape(36.dp),
                    maxLines = 1
                )

                TextField(
                    value = nascimentoState.value,
                    onValueChange = {
                        nascimentoState.value = it
                    },
                    label = {
                        Text(text = "Faça uma descrição sobre você para que outras mulheres possam te conhecer melhor! Conte sobre sua jornada,  vida e  carreira. ♡\n" +
                                "\n" +
                                "Essa descrição ficará visivel no seu perfil.")
                    },

                    colors = OutlinedTextFieldDefaults
                        .colors(
                            focusedBorderColor = Color(0xffFFAEBF),
                            unfocusedBorderColor = Color(0xffFFAEBF),
                        ),
                    shape = RoundedCornerShape(36.dp),
                    modifier = Modifier.width(280.dp),
                            maxLines = 5
                )


                Spacer(modifier = Modifier.height(22.dp))


                Button(onClick = {
                    if (nomeState.value.isBlank() || sobrenomeState.value.isBlank() ||
                        cpfState.value.isBlank() || profissaoState.value.isBlank() ||
                        nascimentoState.value.isBlank()) {
                        Toast.makeText(context, "Por favor, preencha todos os campos!", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(context, "Cadastro concluido!", Toast.LENGTH_SHORT).show()
                        // Navigate to next screen or perform registration
                    }

                },
                    shape = RoundedCornerShape(66.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color((0xffFFAEBF)))
                ) {
                    Row (
                        modifier = Modifier
                            .width(80.dp)
                            .height(28.dp)
                        ,
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceAround
                    ){
                        Text(text = "Próximo",
                            fontSize = 18.sp
                        )

                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                Text(text = "Ir para o  Login", Modifier.clickable { controleNavegacao.navigate("login")})


            }

        }

    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun RegisterDoulaPreview() {
    RegisterDoula(controleNavegacao = rememberNavController())
}
