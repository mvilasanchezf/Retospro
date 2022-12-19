package com.example.retospro

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.retospro.navigation.AppScreens

var nombreUsuario=""

@Composable
fun Login(navController: NavHostController){
    nombreUsuario="Canela"
    val passwordUsuario = "magenta"
    var enabled by remember { mutableStateOf(false) }
    var mostrarAlerta by remember { mutableStateOf(false) }
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
    ){


        Column(){
            val bannerhead = painterResource(R.drawable.logo)
            Image(
                painter = bannerhead,
                contentDescription = null,
                modifier = Modifier
                    .height(90.dp)
                    .fillMaxWidth(),

                )
        }

        Column(modifier = Modifier.padding(top = 50.dp)) {


            var nombreUsuario2 = rellenarDatosUsuario(text = "Nombre")
            var passwordUsuario2 = rellenarDatosUsuario(text = "Password")


            if ((nombreUsuario == nombreUsuario2) && (passwordUsuario == passwordUsuario2)){
                enabled = true
            }
        }


        ExtendedFloatingActionButton(
            onClick = {if (enabled) {
                navController.navigate(AppScreens.Cuestionario.ruta)
            }else{
                mostrarAlerta = true
            }
            },
            icon = {
            },
            text = { Text ("Login") },
            modifier = Modifier
                .padding(top = 60.dp)
        )
        if (mostrarAlerta) {
            AlertDialog(
                onDismissRequest = { mostrarAlerta = false },
                title = { Text(text = "Usuario o contraseña incorrectos") },
                text = { Text(text = "Por favor, introdúcelos de nuevo") },
                confirmButton = {
                    Button(onClick = { mostrarAlerta = false },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.LightGray)
                    ) {
                        Text(text = "Confirmar", color = Color.Blue)
                    }
                }
            )
        }
    }

}

@Composable
fun rellenarDatosUsuario(text: String): String {

    var myText by remember { mutableStateOf("") }
    OutlinedTextField(
        value= myText,
        onValueChange = {myText = it },
        modifier = Modifier
            .padding(50.dp, 20.dp)
            .background(color = Color.White.copy(alpha = 0.4f)),
        label = { Text(text = text, color = Color.Black, fontWeight = FontWeight.Bold) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Cyan,
            unfocusedBorderColor = Color.Magenta
        
        )
    )

    return myText
}