package com.example.retospro

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun Resultado (navController: NavHostController) {
    Column(
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

            )

            if(contador <5 ){
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(50.dp,50.dp)
                    .border(width = 8.dp, color = Color.Cyan)
                    .clip(RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp))) {
                    Image(painter = painterResource(R.drawable.terrible),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(100.dp,30.dp))
                    Text(text = " Has obtenido $contador /20 puntos. Por las barbas de Kelek muchacho dedicate a otra cosa ",
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(25.dp,20.dp,25.dp,20.dp))
                }
            }else if (contador >=5 && contador <10){
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(50.dp,50.dp)
                    .border(width = 8.dp, color = Color.Cyan)
                    .clip(RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp))) {
                    Image(painter = painterResource(R.drawable.malardo),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(100.dp,30.dp))
                    Text(text = " Has obtenido $contador /20 puntos. Condenacion no pierdas la esperanza, joven ",
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(25.dp,20.dp,25.dp,20.dp))
                }
            }else if (contador >=10 && contador <15) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(50.dp, 50.dp)
                        .border(width = 8.dp, color = Color.Cyan)
                        .clip(RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp))) {
                    Image(
                        painter = painterResource(R.drawable.bien),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(100.dp, 30.dp))
                    Text(
                        text = " Has obtenido $contador /20 puntos. Estas a la altura de un cremlino ",
                        textAlign = TextAlign.Center,
                        fontSize = 25.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(25.dp, 20.dp, 25.dp, 20.dp)
                    )
                }
            }else{
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(50.dp,50.dp)
                    .border(width = 8.dp, color = Color.Cyan)
                    .clip(RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp))) {
                    Image(painter = painterResource(R.drawable.excelente),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(100.dp,30.dp))
                    Text(text = " Has obtenido $contador /20 puntos. Eres todo un Radiante de las orden de desarrolladores ",
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(25.dp,20.dp,25.dp,20.dp))
                }
            }
        }
    }}