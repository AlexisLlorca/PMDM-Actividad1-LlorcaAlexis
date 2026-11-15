package com.example.practica_act1.model

class CalculadoraSalario {

    fun calcular(datos: DatosSalario): ResultadoSalario {

        val porcentajeIrpf = when {
            datos.salarioBrutoAnual < 15000.0 -> 0.08
            datos.salarioBrutoAnual < 30000.0 -> 0.15
            datos.salarioBrutoAnual < 45000.0 -> 0.22
            else -> 0.28
        }

        val grupo = datos.grupoProfesional.trim().lowercase()

        val ajusteGrupo = when (grupo) {
            "directivo", "grupo 1" -> 0.02
            "tecnico", "técnico", "grupo 2" -> 0.01
            else -> 0.0
        }

        val aplicarIrpf = porcentajeIrpf + ajusteGrupo

        var deducciones = datos.numeroHijos * 250.0

        if (datos.gradoDiscapacidad >= 33) {
            deducciones += 600.0
        }
        if (datos.edad >= 65) {
            deducciones += 300.0
        }

        val estadoCivil = datos.estadoCivil.trim().lowercase()

        if (estadoCivil == "casado/a"
            || estadoCivil == "casado"
            || estadoCivil == "casada"
        ) {
            deducciones += 200.0
        }

        val retencionCalculada = (datos.salarioBrutoAnual * aplicarIrpf) - deducciones
        val retencionFinal = if (retencionCalculada > 0.0) retencionCalculada else 0.0
        val salarioNeto = datos.salarioBrutoAnual - retencionFinal
        val netoPorPaga = if (datos.numeroPagas > 0) salarioNeto / datos.numeroPagas else 0.0

        return ResultadoSalario(
            salarioBruto = datos.salarioBrutoAnual,
            salarioNeto = salarioNeto,
            retencionIrpf =  retencionFinal,
            deducciones = deducciones,
            salarioNetoPorPagas = netoPorPaga
        )
    }
}