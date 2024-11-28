package br.senai.sp.jandira.lotus.service

import br.senai.sp.jandira.lotus.model.Checklist
import br.senai.sp.jandira.lotus.model.Gestante
import br.senai.sp.jandira.lotus.model.ResultEnxoval
import br.senai.sp.jandira.lotus.model.Results
import br.senai.sp.jandira.lotus.model.cadastroFeito
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface ChecklistService {

    @GET("v1/Lotus/enxoval")
    fun getAllEnxoval(): Call<ResultEnxoval>

    @Headers("Content-type: application/json")
    @POST("v1/Lotus/enxoval")
    fun addEnxoval(@Body enxovalGestante: Checklist) : Call<ResultEnxoval>
}