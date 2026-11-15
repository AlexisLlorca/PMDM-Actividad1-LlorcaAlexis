package com.example.practica_act1.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.practica_act1.model.CalculadoraSalario
import com.example.practica_act1.ui.theme.Practica_Act1Theme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val calculadora = CalculadoraSalario()

        setContent {
            Practica_Act1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    Column(modifier = Modifier.padding(innerPadding)) {

                        VistaPeticionDatos(
                            onCalcular = { datos ->
                                val resultado = calculadora.calcular(datos)

                                val intent = Intent(this@MainActivity, ResultadosActivity::class.java)
                                intent.putExtra("salarioBruto", resultado.salarioBruto)
                                intent.putExtra("salarioNeto", resultado.salarioNeto)
                                intent.putExtra("retencionIrpf", resultado.retencionIrpf)
                                intent.putExtra("deducciones", resultado.deducciones)
                                intent.putExtra("salarioNetoPorPagas", resultado.salarioNetoPorPagas)

                                startActivity(intent)
                            }
                        )
                    }
                }
            }
        }
    }
}