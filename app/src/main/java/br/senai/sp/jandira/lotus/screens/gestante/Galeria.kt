package br.senai.sp.jandira.lotus.screens.gestante

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun GaleriaGestante(controleNavegacao: NavHostController) {

    Surface(onClick = { /*TODO*/ }) {

        Column {
            Text(text = "Home", style =  MaterialTheme.typography.headlineLarge)


        }

    }

}


@Preview(showBackground = true)
@Composable
fun GaleriaPreview() {

    GaleriaGestante(controleNavegacao = rememberNavController())
}