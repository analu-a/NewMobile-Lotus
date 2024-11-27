package br.senai.sp.jandira.lotus.model

data class Checklist(
    var id_enxoval: Int = 0,
    var produtos_enxoval: String = "",
    var id_gestante_usuario_enxoval: Int = 0,
    val resultsEnxoval: List<Checklist>
)
