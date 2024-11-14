package br.senai.sp.jandira.lotus.service

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


//Esse arquivo que vai pro backend e requisitar os dados
class RetrofitFactory {

    private val baseUrl = "https://lotus-back-end.onrender.com/"

    private val retrofitFactory = Retrofit
        .Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val okHttpClient = OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)  // Timeout de conexão
        .writeTimeout(30, TimeUnit.SECONDS)    // Timeout de escrita
        .readTimeout(30, TimeUnit.SECONDS)     // Timeout de leitura
        .build()

    fun getConteudoService(): ConteudoService{
        return retrofitFactory.create(ConteudoService::class.java)
    }
    fun getGestanteService(): GestanteService{
        return retrofitFactory.create<GestanteService>(GestanteService::class.java)
    }
}