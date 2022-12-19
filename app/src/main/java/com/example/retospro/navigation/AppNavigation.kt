package com.example.retospro.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import com.example.retospro.*


@Composable
fun AppNavigation(){
    val navigationController = rememberNavController()
    NavHost(navController = navigationController, startDestination = AppScreens.Inicio.ruta)
    {
        composable(AppScreens.Inicio.ruta){Inicio(navigationController)}
        composable(AppScreens.Login.ruta){ Login(navigationController)}
        composable(AppScreens.Cuestionario.ruta) { Cuestionario(navigationController)}
        composable(AppScreens.Resultado.ruta) {Resultado(navigationController)}
    }
}

