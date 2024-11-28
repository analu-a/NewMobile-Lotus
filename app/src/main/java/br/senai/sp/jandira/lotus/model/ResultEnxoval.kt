package br.senai.sp.jandira.lotus.model

import androidx.compose.runtime.MutableState

data class ResultEnxoval(
    var status_code : Int = 0,
    var quantidade : Int = 0,
    var enxovalDados : List<Checklist>
)
