package br.senai.sp.jandira.lotus.model

data class Galeria(
    var id_galeria_gestante: Int = 0,
    var foto_galeria: String = "",
    var titulo_galeria: String = "",
    var descricao_galeria: String = "",
    var data_foto: String = "",
    var id_gestante_usuario_galeria: Int = 0,
)
