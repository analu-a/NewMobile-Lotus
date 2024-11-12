package br.senai.sp.jandira.lotus.screens.gestante

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import br.senai.sp.jandira.lotus.model.Conteudo
import br.senai.sp.jandira.lotus.model.Results
import br.senai.sp.jandira.lotus.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun Conteudos(controleNavegacao: NavHostController) {

    var conteudoList by remember { mutableStateOf(listOf<Conteudo>()) }
    var isLoading by remember { mutableStateOf(true) } // Estado de carregamento

    val conteudoCall = RetrofitFactory()
        .getConteudoService()
        .getAllConteudo()

    conteudoCall.enqueue(object : Callback<Results> {
        override fun onResponse(call: Call<Results>, response: Response<Results>) {
            if (response.isSuccessful) {
                conteudoList = response.body()?.results ?: listOf()
            }
            isLoading = false // Carregamento concluído
        }

        override fun onFailure(call: Call<Results>, t: Throwable) {
            // Caso haja erro na resposta, você pode mostrar um erro ou algo do tipo
            isLoading = false
        }
    })

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White) // Altere para uma cor mais neutra
        ) {
            if (isLoading) {
                // Exibe um carregamento enquanto os dados não chegam
                Text(
                    text = "Carregando...",
                    color = Color.Black,
                    modifier = Modifier.padding(16.dp)
                )
            } else {
                // Aqui, você chama o ConteudoCard para cada item da lista 'conteudoList'
                LazyColumn {
                    items(conteudoList) { conteudo ->
                        ConteudoCard()
                    }
                }
            }
        }
    }
}

@Composable
fun ConteudoCard() {

    val context = LocalContext.current

    var conteudo by remember {
        mutableStateOf("")
    }

    Card(
        modifier = Modifier
            .padding(6.dp)
            .fillMaxWidth()
            .height(160.dp)
            .clickable {
                // Aqui você pode adicionar a navegação para detalhes
                // controleDeNavegacao.navigate("conteudoDetalhes/${conteudo.id_conteudos}")
            },
        colors = CardDefaults.cardColors(containerColor = Color(0xff00b7ff))
    ) {
        Row {
            // Conteúdo do texto
            Column(
                modifier = Modifier.padding(start = 8.dp, top = 10.dp)
            ) {
                // Título do Conteúdo
                Text(

                    text = "nome",
                    color = Color(0xFFFF00F2),
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                )
                Text(
                    text = "oiiii",
                    color = Color(0xFFFF00F2),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                )

                Spacer(modifier = Modifier.height(4.dp))

                // Descrição do Conteúdo
                Text(
                    text = "Título:",
                    color = Color(0xFFFF00F2),
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                )
                Text(
                    text = "Título:",
                    color = Color(0xFFFF00F2),
                    fontSize = 14.sp,
                    modifier = Modifier.padding(top = 4.dp)
                )

                Spacer(modifier = Modifier.height(6.dp))

                // Data do Conteúdo
                Text(
                    text = "Data:",
                    color = Color(0xFFFF00F2),
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                )
                Text(
                    text = "Título:",
                    color = Color(0xFFFF00F2),
                    fontSize = 12.sp,
                )

                Text(
                    "test"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ConteudoCardPreview() {
    // Criando um exemplo de Conteudo fictício
    val conteudo = Conteudo(
        id_conteudos = 1,
        foto_capa = "https://lavembebe.com.br/blog/wp-content/uploads/2020/06/alimenta%C3%A7%C3%A3o-na-gravidez.jpg",
        titulo_conteudo = "O que comer durante a gestação",
        data_conteudo = "2024-04-02T00:00:00.000Z",
        conteudo = "Uma alimentação saudável ajuda a manter seu bebê bem.",
        id_gestante_conteudo_usuario = 1
    )

    // Criando um NavController fictício para o preview
    val navController = rememberNavController()
//
//    // Chama o ConteudoCard passando o conteudo fictício e o navController fictício
//    ConteudoCard(conteudo = conteudo, con = navController)
}
