package com.example.retospro.navigation

sealed class AppScreens (val ruta: String){
    object Inicio: AppScreens("inicio")
    object Login: AppScreens("login")
    object Cuestionario: AppScreens("cuestionario")
    object Resultado: AppScreens("resultado")
}