package br.senai.sp.jandira.lotus.screens.gestante

import androidx.compose.ui.tooling.preview.Preview


import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.senai.sp.jandira.lotus.model.Conteudo
import br.senai.sp.jandira.lotus.model.CounteudoResponse
import br.senai.sp.jandira.lotus.service.RetrofitFactory
import coil.compose.AsyncImage
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun Conteudos(controleNavegacao: NavHostController) {


    val context = LocalContext.current

    var conteudoList by remember { mutableStateOf<List<Conteudo>>(listOf()) }
    var isLoading by remember { mutableStateOf(true) } // Estado de carregamento

    // A chamada Retrofit é feita aqui, fora do composable
    LaunchedEffect(Unit) {
        val conteudoCall = RetrofitFactory()
            .getConteudoService()
            .getAllConteudo()

        conteudoCall.enqueue(object : Callback<CounteudoResponse> {
            override fun onResponse(
                call: Call<CounteudoResponse>, response: Response<CounteudoResponse>
            ) {
                if (response.isSuccessful) {
                    conteudoList = response.body()?.conteudosDados ?: listOf()
                    Log.d("Conteudos: ", "$conteudoList")
                }
                isLoading = false // Carregamento concluído
            }

            override fun onFailure(call: Call<CounteudoResponse>, t: Throwable) {
                // Caso haja erro na resposta, você pode mostrar um erro ou algo do tipo
                isLoading = false
                Log.e("Erro API", "Falha na requisição: ${t.message}")
            }
        })
    }

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .padding(vertical = 28.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Cabeçalho com botões e título
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
                Text(text = "Conteúdos",
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

            // Exibindo a lista de conteúdos
            if (isLoading) {
                // Exibe um carregando, pode ser um indicador de progresso
                Toast.makeText(context, "Carregando..", Toast.LENGTH_SHORT).show()
            } else {
                LazyColumn(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
                    items(conteudoList) { conteudo ->
                        // Para cada item da lista, vamos exibir um card
                        ConteudoCard(conteudo = conteudo, controleNavegacao = controleNavegacao)
                    }
                }
            }
        }
    }
}


fun <T> Call<T>.enqueue(callback: Callback<Results>) {

}


@Composable
fun ConteudoCard(conteudo: Conteudo, controleNavegacao: NavHostController) {


    Card(
        modifier = Modifier
            .padding(6.dp)
            .width(349.dp)
            .height(180.dp)
            .shadow(2.dp, RoundedCornerShape(12.dp), )
            .clickable {
                controleNavegacao.navigate("checklistgestante/${conteudo.id_conteudos}")
            },
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFFFF))
    ) {

        Surface(modifier = Modifier.fillMaxWidth().height(140.dp)) {

                AsyncImage(
                    model = conteudo.foto_capa,
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )
        }

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth().height(60.dp)
        ) {
            Text(
                text = conteudo.titulo_conteudo,
                fontSize = 16.sp,
            )
        }

    }

    Spacer(modifier = Modifier.height(12.dp))
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ConteudosPreview() {
    Conteudos(controleNavegacao = rememberNavController())
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
