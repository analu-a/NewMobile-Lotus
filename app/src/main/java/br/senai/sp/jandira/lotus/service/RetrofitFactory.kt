package br.senai.sp.jandira.lotus.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


//Esse arquivo que vai pro backend e requisitar os dados
class RetrofitFactory {

    private val baseUrl = "https://lotus-back-end.onrender.com/"

    private val retrofitFactory = Retrofit
        .Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getConteudoService(): ConteudoService{
        return retrofitFactory.create(ConteudoService::class.java)
    }
    fun getGestanteService(): GestanteService{
        return retrofitFactory.create(GestanteService::class.java)
    }
}