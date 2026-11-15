package com.example.practica_act1.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practica_act1.model.DatosSalario

@Composable
fun VistaPeticionDatos(onCalcular: (DatosSalario) -> Unit) {

    var edad by rememberSaveable { mutableStateOf("") }
    var grupo by rememberSaveable { mutableStateOf("") }
    var salario by rememberSaveable { mutableStateOf("") }
    var pagas by rememberSaveable { mutableStateOf("") }
    var hijos by rememberSaveable { mutableStateOf("") }
    var estadoCivil by rememberSaveable { mutableStateOf("") }
    var discapacidad by rememberSaveable { mutableStateOf("") }
    var mensajeError by rememberSaveable { mutableStateOf("") }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        item {
            Text(
                text = "Calculadora de salario",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 12.dp)
            )
        }

        item {
            TextField(
                value = edad,
                onValueChange = { edad = it },
                label = { Text("Edad:") },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 6.dp)
            )
        }

        item {
            TextField(
                value = grupo,
                onValueChange = { grupo = it },
                label = { Text("Grupo profesional:") },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 6.dp)
            )
        }

        item {
            TextField(
                value = salario,
                onValueChange = { salario = it },
                label = { Text("Salario bruto anual (€):") },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 6.dp)
            )
        }

        item {
            TextField(
                value = pagas,
                onValueChange = { pagas = it },
                label = { Text("Número de pagas:") },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 6.dp)
            )
        }

        item {
            TextField(
                value = hijos,
                onValueChange = { hijos = it },
                label = { Text("Número de hijos:") },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 6.dp)
            )
        }

        item {
            TextField(
                value = estadoCivil,
                onValueChange = { estadoCivil = it },
                label = { Text("Estado civil:") },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 6.dp)
            )
        }

        item {
            TextField(
                value = discapacidad,
                onValueChange = { discapacidad = it },
                label = { Text("Grado de discapacidad (%):") },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 6.dp)
            )
        }

        item {
            if (mensajeError != "") {
                Text(text = mensajeError, modifier = Modifier.padding(bottom = 8.dp))
            }
        }

        item {
            Button(
                onClick = {
                    try {
                        val edadNumero = edad.toInt()
                        val pagasNumero = pagas.toInt()
                        val salarioNumero = salario.replace(",", ".").toDouble()
                        val hijosNumero = hijos.toInt()
                        val discapacidadNumero = discapacidad.toInt()

                        if (edadNumero < 16 || edadNumero > 100) {
                            mensajeError = "La edad debe estar entre 16 y 100 años."
                        } else if (pagasNumero < 1 || pagasNumero > 14) {
                            mensajeError = "El número de pagas debe estar entre 1 y 14."
                        } else if (salarioNumero <= 0.0) {
                            mensajeError = "El salario bruto debe ser mayor que 0."
                        } else {
                            mensajeError = ""
                            onCalcular(
                                DatosSalario(
                                    edad = edadNumero,
                                    numeroPagas = pagasNumero,
                                    salarioBrutoAnual = salarioNumero,
                                    grupoProfesional = grupo,
                                    gradoDiscapacidad = discapacidadNumero,
                                    estadoCivil = estadoCivil,
                                    numeroHijos = hijosNumero
                                )
                            )
                        }
                    } catch (e: Exception) {
                        mensajeError = "Revisa que los campos numéricos sean correctos."
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Calcular")
            }
        }

    }
}
