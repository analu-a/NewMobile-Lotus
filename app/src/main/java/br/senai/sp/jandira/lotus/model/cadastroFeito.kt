package br.senai.sp.jandira.lotus.model

data class cadastroFeito(
    var status : Boolean,
    var status_code : Int = 0,
    var message : String = "",
    var cadastro : Gestante ?= null
)
