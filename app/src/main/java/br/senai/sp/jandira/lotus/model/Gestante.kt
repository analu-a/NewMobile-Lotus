package br.senai.sp.jandira.lotus.model

data class Gestante(
    var id_usuario_gestante: Int = 0,
    var nome_gestante: String = "",
    var sobrenome_gestante: String = "",

    var idade_gestante: String = "",
    var peso_gestante: String = "",
    var altura_gestante: String = "",
    var email_gestante: String = "",
    var senha_gestante: String = "",
    var foto_gestante: String = "",
    var cpf_gestante: String = "",
    var data_nascimento_gestante: String = "",
    var profissao_gestante: String = "",
    var nome_bebe: String = "",
    var semanas_de_gravidez: String = "",
)
