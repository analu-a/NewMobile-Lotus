package br.senai.sp.jandira.lotus.model

data class ResultEnxoval(
    var status_code : Int = 0,
    var quantidade : Int = 0,
    var enxovalDados : List<Checklist>
)
