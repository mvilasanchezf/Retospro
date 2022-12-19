package com.example.retospro

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.retospro.navigation.AppScreens

@Composable
fun Cuestionario(navController: NavHostController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(R.drawable.fondo),
                contentScale = ContentScale.FillWidth
            )
            .verticalScroll(rememberScrollState())
    ) {

        Column {
            val bannerhead = painterResource(R.drawable.logo)
            Image(
                painter = bannerhead,
                contentDescription = null,
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth()
                    .background(color = Color.Black)

            )
            TiposScreen(listaTipos = ListaTipos.tipos, navController)
        }
    }
}
var contador = 0;

data class Pregunta(
    val titulo: String,
    val respuestas: List<String>
)

object ListaTipos{
    val tipos = listOf(
        Pregunta( "¿Cuál es el mejor lenguaje de programación para aprender siendo principiante?", respuestas = listOf("COW","Java","JavaFX")),
        Pregunta( "¿Cuál es el mejor ID para desarrollar Java?", respuestas = listOf("IntelliJ","Eclipse","VI")),
        Pregunta("¿Cuál es el primer programa por excelencia que lanza realiza un desarrollador?", respuestas =  listOf("Hello World","Calculadora","Algoritmo de la polaca inversa")),
        Pregunta("¿¿Cuál es el atajo en itelliJ para escribir rápidamente “system.out.println”??", respuestas = listOf("alt+f4","ctlr+alt+supr","Escribir “sout” + tabular")),
        Pregunta( "¿Cuál es la línea de código que bajo ningún concepto mucha gente quiere ver para cerrar un programa?", respuestas = listOf("Break","Break","Break")),
        Pregunta( "¿Cuál es la precisión de un tipo de dato int?", respuestas = listOf("8 bit","16 bit","32 bit")),
        Pregunta("¿Que tipo de estructura corresponde a la sintaxis for?", respuestas =  listOf("Condiciona","Bucle","Variable")),
        Pregunta("¿Que significan las siblas POO?", respuestas = listOf("Programacion Orbital Ordenada","Programacion Orientada a Objetos","Proposicion Objetiva y Obtusa")),
        Pregunta( "¿Cual es la principal cualidad que se espera de un desarrollador?", respuestas = listOf("Que este dispuesto a darlo todo","Que sepa buscar en StackOverflow","Que le haga caso siempre a Otero")),
        Pregunta( "¿Es JavaFX el sumon de los lenguajes de programacion modernos?", respuestas = listOf("¡Tormentas! Pues claro","no sé, yo...","¿esto es una broma? (Sí)")))
}

@Composable
fun TiposScreen (listaTipos: List<Pregunta>, navController: NavHostController) {

    listaTipos.forEach { Pregunta ->
        Cardlistas(
            titulo = Pregunta.titulo,
            respuestas = Pregunta.respuestas
        )
    }
    ColocarBotones(text = "Comprobar", separacion = 60, navController, ruta = AppScreens.Resultado.ruta)

}

@Composable
fun Cardlistas(titulo: String,respuestas: List<String>) {

    val selectedOption = rememberSaveable { mutableStateOf(" ") }

    Card(
        modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth()

    ) {
        Column(modifier = Modifier
            .border(BorderStroke(3.dp, color = Color.Magenta))
            .background(color = Color.Blue.copy(alpha = 0.8f))) {
            Text(
                text = titulo,
                fontSize = 25.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(30.dp,15.dp)
            )

            respuestas.forEach { item->
                Row(
                    modifier = Modifier
                        .selectable(
                            selected = (selectedOption.value == item),
                            onClick = { selectedOption.value = item },
                        )
                        .padding(horizontal = 16.dp)
                ){

                    IconToggleButton(
                        checked = selectedOption.value==item,
                        onCheckedChange = { selectedOption.value = item},

                        ) {
                        Icon(
                            painter = painterResource(
                                if (selectedOption.value==item) {
                                    R.drawable.ic_circle_checked
                                } else {
                                    R.drawable.ic_circle_outline
                                },
                            ),
                            contentDescription = null,
                            tint = Color(0xFF009688)

                        )
                    }
                    Text(
                        text = item,
                        style = MaterialTheme.typography.body1.merge(),
                        color=Color.White,
                        modifier = Modifier
                            .padding(start = 16.dp),
                        fontSize = 20.sp
                    )
                }
            }
            if (selectedOption.value.equals("Java")){

                contador++

            }
            if (selectedOption.value.equals("IntelliJ")){

                contador++

            }
            if (selectedOption.value.equals("Hello World")){

                contador++

            }
            if (selectedOption.value.equals("Escribir “sout” + tabular")){

                contador++

            }
            if (selectedOption.value.equals("Break")){

                contador++

            }
            if (selectedOption.value.equals("16 bit")){

                contador++

            }
            if (selectedOption.value.equals("Bucle")){

                contador++

            }
            if (selectedOption.value.equals("Programacion Orientada a Objetos")){

                contador++

            }
            if (selectedOption.value.equals("Que este dispuesto a darlo todo")){

                contador++

            }
            if (selectedOption.value.equals("¡Tormentas! Pues claro")){

                contador++

            }
        }
    }

}