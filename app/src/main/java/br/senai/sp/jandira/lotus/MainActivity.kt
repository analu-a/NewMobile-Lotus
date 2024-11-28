package br.senai.sp.jandira.lotus

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import br.senai.sp.jandira.lotus.screens.Login
import br.senai.sp.jandira.lotus.screens.Register
import br.senai.sp.jandira.lotus.screens.doula.HomeDoula
import br.senai.sp.jandira.lotus.screens.doula.PerfilDoula
import br.senai.sp.jandira.lotus.screens.doula.RegisterDoula
import br.senai.sp.jandira.lotus.screens.gestante.AgendaGestante
import br.senai.sp.jandira.lotus.screens.gestante.CardConteudo
import br.senai.sp.jandira.lotus.screens.gestante.CheckListGestante
import br.senai.sp.jandira.lotus.screens.gestante.Conteudos
import br.senai.sp.jandira.lotus.screens.gestante.GaleriaGestante
import br.senai.sp.jandira.lotus.screens.gestante.HomeGestante
import br.senai.sp.jandira.lotus.screens.gestante.MonitoramentoGestante
import br.senai.sp.jandira.lotus.screens.gestante.PerfilGestante
import br.senai.sp.jandira.lotus.screens.gestante.RegisterGestante
import br.senai.sp.jandira.lotus.ui.theme.LotusTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LotusTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Login()
                    val controleNavegacao = rememberNavController()
                    NavHost(
                        navController = controleNavegacao,
                        startDestination = "login"
                    ) {
                        composable(route = "login") { Login(controleNavegacao) }
                        composable(route = "register") { Register(controleNavegacao) }

                        //Doula
                        composable(route = "registerdoula") { RegisterDoula(controleNavegacao) }
                        composable(route = "perfildoula") { PerfilDoula(controleNavegacao) }
                        composable(route = "homedoula") { HomeDoula(controleNavegacao) }

                        //Gestante
                        composable(route = "registergestante") { RegisterGestante(controleNavegacao) }
                        composable(route = "perfilgestante/{id}") { backStateEntry ->
                            val id =  backStateEntry.arguments?.getString("id")?.toIntOrNull() ?: 0
                            PerfilGestante(controleNavegacao, id.toString()) }
                        composable(route = "homegestante/{id}") { backStateEntry ->
                            val id =  backStateEntry.arguments?.getString("id")?.toIntOrNull() ?: 0
                            HomeGestante(controleNavegacao, id.toString()) }
                        composable(route = "agendagestante") { AgendaGestante(controleNavegacao, id.toString()
                        ) }
                        composable(route = "checklistgestante") { CheckListGestante(controleNavegacao) }
                        composable(route = "conteudosgestante") { Conteudos(controleNavegacao) }
                        composable(route = "monitoramentogestante") { MonitoramentoGestante(controleNavegacao) }
                        composable(route = "galeriagestante") { GaleriaGestante(controleNavegacao) }
                        composable(route = "conteudoCard") { CardConteudo(controleNavegacao, id) }


                        composable(
                            route = "conteudocard/{id}",
                            arguments = listOf(navArgument("id") { type = NavType.IntType })
                        ) { backStackEntry ->
                            val id = backStackEntry.arguments?.getInt("id")
                            if (id != null) {
                                CardConteudo(controleNavegacao, id)
                            }
                        }

                    }
                }
            }
        }
    }
}



