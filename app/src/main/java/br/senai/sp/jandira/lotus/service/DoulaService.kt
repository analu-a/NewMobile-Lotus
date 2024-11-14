package br.senai.sp.jandira.lotus.service

import br.senai.sp.jandira.lotus.model.Conteudo
import br.senai.sp.jandira.lotus.model.Results
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface DoulaService {

    @GET("v1/Lotus/conteudos/doula")
    fun getAllDoula(): Call<Conteudo>

    @GET("v1/Lotus/conteudos/doula/{id}")
    fun getDoulaById(@Path("id") id: Int): Call<Conteudo>

}