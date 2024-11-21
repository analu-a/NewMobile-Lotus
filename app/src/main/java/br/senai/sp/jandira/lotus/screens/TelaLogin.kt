package br.senai.sp.jandira.lotus.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.senai.sp.jandira.lotus.R
import br.senai.sp.jandira.lotus.model.Gestante
import br.senai.sp.jandira.lotus.model.loginValidado
import br.senai.sp.jandira.lotus.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun Login(controleNavegacao: NavHostController) {

    Surface(onClick = { /*TODO*/ }) {

        var emailState = remember {
            mutableStateOf("")
        }
        var passwordState = remember {
            mutableStateOf("")
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()

        ) {

            Text(text = "Bem vindo-a",
                color = Color(0xff7C7C7C),
                fontSize = 16.sp,)
            Text(text = "Lótus.",
                color = Color(0xffFFAEBF),
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold,)

            Surface(modifier = Modifier
                .width(260.dp)
                .height(260.dp),

            )
            {
                Image(painter = painterResource(id = R.drawable.cegonha), contentDescription = "Cegonha")

            }

            OutlinedTextField(
                value = emailState.value,
                onValueChange = {
                    emailState.value = it
                },
                label = {
                    Text(text = "Email")
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Email,
                        contentDescription = "",
                        tint = Color(0xffFFAEBF),
                    )
                },
                colors = OutlinedTextFieldDefaults
                    .colors(
                        focusedBorderColor = Color(0xffFFAEBF),
                        unfocusedBorderColor = Color(0xffFFAEBF),
                        focusedPlaceholderColor = Color(0x00FFAEBF),
                        focusedContainerColor =  Color(0x2FFFAEBF),
                    ),
                shape = RoundedCornerShape(36.dp),
                maxLines = 1
            )


            OutlinedTextField(
                value = passwordState.value,
                onValueChange = {
                    passwordState.value = it
                },
                label = {
                    Text(text = "Password")
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Lock,
                        contentDescription = "",
                        tint = Color(0xffFFAEBF),
                    )
                },
                colors = OutlinedTextFieldDefaults
                    .colors(
                        focusedBorderColor = Color(0xffFFAEBF),
                        unfocusedBorderColor = Color(0xffFFAEBF),
                        focusedContainerColor =  Color(0x2FFFAEBF),
                    ),
                shape = RoundedCornerShape(36.dp),
                maxLines = 1,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = PasswordVisualTransformation()
            )

            Spacer(modifier = Modifier.height(34.dp))


            Button(onClick = {
val autentication = RetrofitFactory().getGestanteService().addLogin(loginUsuario = Gestante(nome_gestante = "", sobrenome_gestante = "", idade_gestante = null, peso_gestante = null, altura_gestante = null, email_gestante = emailState.value, senha_gestante = passwordState.value, foto_gestante = "", cpf_gestante = "", data_nascimento_gestante = "", profissao_gestante = "", nome_bebe = "", semanas_de_gravidez = ""))
                if(emailState.value == "" || passwordState.value == ""){}else{
                autentication.enqueue(object : Callback<loginValidado>{
                    override fun onResponse(p0: Call<loginValidado>, p1: Response<loginValidado>) {
                        Log.i("tag", p1.body().toString())
controleNavegacao.navigate("homegestante/${p1.body()?.usuario!![0].id_usuario_gestante}")
                }

                    override fun onFailure(p0: Call<loginValidado>, p1: Throwable) {
                        TODO("Not yet implemented")
                        Log.i("tag", p1.message.toString())
                    }
                })


            }},
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

            Text(text = "Criar uma conta",
                Modifier.clickable { controleNavegacao.navigate("register")})
            
        }

    }

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun LoginPreview() {
    Login(controleNavegacao = rememberNavController())
}