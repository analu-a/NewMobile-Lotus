package br.senai.sp.jandira.lotus.model

data class Gestante(
    val id_usuario_gestante: Int = 0,
    val nome_gestante: String = "",
    val sobrenome_gestante: String = "",
    val idade_gestante: Int = 0,
    val peso_gestante: Double = 0.0,
    val altura_gestante: Double = 0.0,
    val email_gestante: String = "",
    val senha_gestante: String = "",
    val foto_gestante: String = "",
    val cpf_gestante: String = "",
    val data_nascimento_gestante: String = "",
    val profissao_gestante: String = "",
    val nome_bebe: String = "",
    val semanas_de_gravidez: String = ""
)

