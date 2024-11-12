package br.senai.sp.jandira.lotus.service

import br.senai.sp.jandira.lotus.model.Conteudo
import br.senai.sp.jandira.lotus.model.PerfilGestante
import br.senai.sp.jandira.lotus.model.Results
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GestanteService {

    @GET("v1/Lotus/cadastro/gestante")
    fun getAllGestante(): Call<Results>

    @GET("v1/Lotus/cadastro/gestante/{id}")
    fun getGestanteById(@Path("id") id: Int): Call<PerfilGestante>
}