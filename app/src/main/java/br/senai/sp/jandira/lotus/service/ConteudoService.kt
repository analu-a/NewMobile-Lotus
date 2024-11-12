package br.senai.sp.jandira.lotus.service

import br.senai.sp.jandira.lotus.model.Conteudo
import br.senai.sp.jandira.lotus.model.Results
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface  ConteudoService {

    @GET("v1/Lotus/conteudos/gestante")
    fun getAllConteudo(): Call<Results>

    @GET("v1/Lotus/conteudos/gestante/{id}")
    fun getContreudoById(@Path("id") id: Int): Call<Conteudo>

}