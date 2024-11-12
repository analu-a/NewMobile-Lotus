package br.senai.sp.jandira.lotus.screens
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Person
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.senai.sp.jandira.lotus.R

@Composable
fun Register(controleNavegacao: NavHostController) {

    Surface() {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()

        ){
            Text(text = "Crie sua conta na",
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
                Image(painter = painterResource(id = R.drawable.berco), contentDescription = "Cegonha")

            }

            Spacer(modifier = Modifier.height(14.dp))
            Text(text = "Como gostaria de prosseguir o cadastro?",
                    color = Color(0xff7C7C7C),)
            Spacer(modifier = Modifier.height(14.dp))

            Row() {
                Button(onClick = { controleNavegacao.navigate("registerGestante") },
                    Modifier
                        .height(120.dp)
                        .width(120.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color((0xffFFAEBF)))) {
                    Text(text = "Gestante")

                }
                Spacer(modifier = Modifier.width(28.dp))
                Button(onClick = { controleNavegacao.navigate("registerDoula") },
                    Modifier
                        .height(120.dp)
                        .width(120.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color((0xffFEB491)))) {
                    Text(text = "Doula")

                }
            }
        }



    }

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun RegisterPreview() {
    Register(controleNavegacao = rememberNavController())
}
