package br.senai.sp.jandira.lotus.screens.gestante

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
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import network.chaintech.kmp_date_time_picker.ui.datepicker.WheelDatePickerView
import network.chaintech.kmp_date_time_picker.ui.datepicker.WheelPicker
import network.chaintech.kmp_date_time_picker.utils.DateTimePickerView


@Composable
fun RegisterGestante(controleNavegacao: NavHostController) {



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
            var nomeBebeState = remember {
                mutableStateOf("")
            }
            var semanasState = remember {
                mutableStateOf("")
            }

            var dataNascimento by remember {
                mutableStateOf(false)
            }

            // https://github.com/Chaintech-Network/compose_multiplatform_date_time_picker

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
                        Text(text = "Profissão")
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

                WheelDatePickerView(
                    showDatePicker = dataNascimento,
                    height = 200.dp,
                    dateTimePickerView = DateTimePickerView.BOTTOM_SHEET_VIEW,
                )

                OutlinedTextField(
                    value = nascimentoState.value,
                    onValueChange = {
                        nascimentoState.value = it
                    },
                    label = {
                        Text(text = "Data de Nascimento")
                    },
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.DateRange,
                            contentDescription = "",
                            tint = Color(0xffFFAEBF),
                            modifier = Modifier
                                .clickable { dataNascimento = true }
                        )
                    },
                    colors = OutlinedTextFieldDefaults
                        .colors(
                            focusedBorderColor = Color(0xffFFAEBF),
                            unfocusedBorderColor = Color(0xffFFAEBF),
                        ),
                    shape = RoundedCornerShape(36.dp),
                    maxLines = 1,
                )

                OutlinedTextField(
                    value = nomeBebeState.value,
                    onValueChange = {
                        nomeBebeState.value = it
                    },
                    label = {
                        Text(text = "Nome do bebe")
                    },
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Face,
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

                OutlinedTextField(
                    value = semanasState.value,
                    onValueChange = {
                        semanasState.value = it
                    },
                    label = {
                        Text(text = "Semanas de  gravidez")
                    },
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Notifications,
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


                Spacer(modifier = Modifier.height(22.dp))


                Button(onClick = {

                    controleNavegacao.navigate("homegestante")

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
                        Text(text = "Entrar",
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
fun RegisterGestantePreview() {
    RegisterGestante(controleNavegacao = rememberNavController())
}
