package br.senai.sp.jandira.lotus.service

import br.senai.sp.jandira.lotus.model.Results
import retrofit2.Call
import retrofit2.http.GET

interface ChecklistService {

    @GET("v1/Lotus/enxoval")
    fun getAllEnxoval(): Call<Results>

}