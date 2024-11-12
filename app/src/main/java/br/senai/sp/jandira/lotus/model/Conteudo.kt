package br.senai.sp.jandira.lotus.model

data class Conteudo(
    var id_conteudos: Int = 0,
    var foto_capa: String = "",
    var titulo_conteudo: String = "",
    var data_conteudo: String = "",
    var conteudo: String = "",
    var id_gestante_conteudo_usuario: Int = 0
)