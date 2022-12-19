package com.example.retospro

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.compose.foundation.layout.*
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import com.example.retospro.navigation.AppScreens


@Composable
fun Inicio(navController: NavHostController){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
        .fillMaxSize()
        .paint(
            painter = painterResource(R.drawable.fondo),
            contentScale = ContentScale.FillWidth
        )
    ){
        Column() {
            val bannerhead = painterResource(R.drawable.logo)
            Image(painter = bannerhead, contentDescription = null,
            modifier = Modifier
                .height(90.dp)
                .fillMaxSize())
        }
        ColocarBotones(text = "Iniciar Reto", separacion = 300, navController, ruta = AppScreens.Login.ruta)
    }
}


@Composable
fun ColocarBotones(text: String, separacion: Int, navController: NavHostController, ruta: String){

    ExtendedFloatingActionButton(
        onClick = {navController.navigate(ruta)},
        icon = {
        },
        text = { Text (text) },
        modifier = Modifier
            .padding(top = separacion.dp)
    )
}