package br.senai.sp.jandira.lotus.service

import br.senai.sp.jandira.lotus.model.Gestante
import br.senai.sp.jandira.lotus.model.Results
import br.senai.sp.jandira.lotus.model.loginValidado
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

interface GestanteService {

    @GET("v1/Lotus/cadastro/gestante")
    fun getAllGestante(): Call<Gestante>

    @GET("v1/Lotus/cadastro/gestante/{id}")
    fun getGestanteById(
        @Path("id") id: Int
    ): Call<loginValidado>

    @Headers("Content-type: application/json")
    @POST("v1/Lotus/cadastro/gestante/login")
    fun addLogin(@Body loginUsuario : Gestante) : Call<loginValidado>

}