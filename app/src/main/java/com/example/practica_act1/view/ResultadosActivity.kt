package com.example.practica_act1.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.practica_act1.model.ResultadoSalario
import com.example.practica_act1.ui.theme.Practica_Act1Theme

class ResultadosActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val resultado = ResultadoSalario(
            salarioBruto = intent.getDoubleExtra("salarioBruto", 0.0),
            salarioNeto = intent.getDoubleExtra("salarioNeto", 0.0),
            retencionIrpf = intent.getDoubleExtra("retencionIrpf", 0.0),
            deducciones = intent.getDoubleExtra("deducciones", 0.0),
            salarioNetoPorPagas = intent.getDoubleExtra("salarioNetoPorPagas", 0.0)
        )

        setContent {
            Practica_Act1Theme {
                VistaResultados(
                    resultado = resultado,
                    onVolver = { finish() }
                )
            }
        }
    }
}