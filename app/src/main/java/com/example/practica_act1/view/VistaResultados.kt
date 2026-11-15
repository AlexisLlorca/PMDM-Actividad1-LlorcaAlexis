package com.example.practica_act1.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practica_act1.model.ResultadoSalario

@Composable
fun VistaResultados(resultado: ResultadoSalario, onVolver: () -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Resultados del cálculo",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        FilaResultado("Salario bruto:", resultado.salarioBruto)
        FilaResultado("Salario neto:", resultado.salarioNeto)
        FilaResultado("Retención de IRPF:", resultado.retencionIrpf)
        FilaResultado("Posibles deducciones:", resultado.deducciones)
        FilaResultado("Neto por paga:", resultado.salarioNetoPorPagas)

        Button(
            onClick = onVolver,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ){
            Text("Volver a calcular")
        }
    }
}

@Composable
private fun FilaResultado(etiqueta: String, valor: Double) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = etiqueta, fontWeight = FontWeight.Bold)
        Text(text = formatearEuros(valor))
    }
}

private fun formatearEuros(valor: Double): String = "%.2f €".format(valor)