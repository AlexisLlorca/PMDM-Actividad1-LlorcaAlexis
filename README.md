# Actividad 1 — Calculadora de salario neto

Aplicación Android en Kotlin con Jetpack Compose para la asignatura
**Programación Multimedia y Dispositivos Móviles (PMDM)** del ciclo de DAM.

## Funcionalidad

- **Pantalla de datos**: recoge edad, grupo profesional, salario bruto anual,
  número de pagas, número de hijos, estado civil y grado de discapacidad.
  Valida los campos y muestra un mensaje de error si algo no es correcto.
- **Pantalla de resultados**: muestra salario bruto, salario neto, retención de
  IRPF, deducciones aplicadas y neto por paga.

El cálculo es **simulado**, como permite el enunciado: tramos de IRPF, ajuste
según el grupo profesional y deducciones por hijos, discapacidad, edad y estado
civil.

## Estructura

```
app/src/main/java/com/example/practica_act1/
├── model/                       Kotlin puro, sin dependencias de Android
│   ├── DatosSalario.kt          Datos que introduce el usuario
│   ├── ResultadoSalario.kt      Resultado del cálculo
│   └── CalculadoraSalario.kt    Lógica de negocio
├── view/                        Interfaz con Jetpack Compose
│   ├── MainActivity.kt          Punto de entrada y navegación
│   ├── ResultadosActivity.kt    Segunda pantalla
│   ├── VistaPeticionDatos.kt    Formulario
│   └── VistaResultados.kt       Tarjeta de resultados
└── ui/theme/                    Tema de Compose (generado por la plantilla)
```

## Cómo ejecutarlo

1. Abrir el proyecto en Android Studio.
2. Sincronizar Gradle.
3. Ejecutar en un emulador o dispositivo con Android 7.0 (API 24) o superior.

Por consola:

```bash
./gradlew :app:assembleDebug
./gradlew :app:installDebug
```

## Decisiones de diseño

- **Dos `Activity`**: navegación con `Intent` explícito y paso de datos mediante
  `putExtra` / `getDoubleExtra`, siguiendo el patrón del Tema 3.
- **Lógica separada de la interfaz**: `CalculadoraSalario` no depende de Android,
  por lo que se puede probar sin emulador.
- **Estado del formulario con `rememberSaveable`**: los valores sobreviven a la
  rotación de pantalla.
- **Lista con `LazyColumn`**: el contenido del formulario es desplazable, como
  se explica en el Tema 4.
- **`ResultadosActivity` con `exported="false"`**: solo esta aplicación puede
  abrirla.

## Uso de herramientas de IA

He utilizado asistencia de IA como apoyo para revisar la estructura del código,
detectar errores y aplicar buenas prácticas. El código final está revisado y
comprendido por el autor, que puede explicar cada una de sus decisiones.

## Autor

Alexis Llorca — DAM, PMDM.
