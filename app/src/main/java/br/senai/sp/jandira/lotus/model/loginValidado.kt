package br.senai.sp.jandira.lotus.model

data class loginValidado(
    var status : Boolean,
    var status_code : Int = 0,
    var message : String = "",
    var usuario : List<Gestante>?=null,
    var gestante : List<Gestante>?=null

)