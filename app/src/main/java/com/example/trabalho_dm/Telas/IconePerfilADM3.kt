package com.example.trabalho_dm.Telas

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.trabalho_dm.R
import com.example.trabalho_dm.Screen

@Composable
fun IconePerfilADM3(navController: NavController){
    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "Background image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column (
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            val borderWidth = 4.dp
            Image(
                painter = painterResource(R.drawable.foto_de_perfil_2),
                contentDescription = "Foto de perfil para caracterizar o ADM",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(150.dp)
                    .border(
                        BorderStroke(borderWidth, Color.Yellow),
                        CircleShape
                    )
                    .padding(borderWidth)
                    .clip(CircleShape)
            )
            Text(
                text = "\n\nSou admnistrador e desejo logar",
                fontSize = 21.sp,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier,
                contentAlignment = Alignment.Center
            ) {
                Button(onClick = {
                    navController.navigate(Screen.logasrse3_2.route)
                }) {
                    Text(text = "Login")
                }
            }
        }
        // Ícones na parte inferior, alinhados em sequência
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter) // Alinha a Row na parte inferior da tela
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly // Distribui os ícones igualmente
        ) {
            // Ícone de Home (Clicável)
            Icon(
                imageVector = Icons.Filled.Home,
                contentDescription = "Ícone de Home",
                modifier = Modifier
                    .size(32.dp)
                    .clickable {
                        navController.navigate(Screen.TelaPrincipalOMapa.route)
                    },
                tint = Color.Gray
            )

            // Ícone de Pergunta (Clicável)
            Icon(
                imageVector = Icons.Filled.Info,
                contentDescription = "Ícone de Pergunta",
                modifier = Modifier
                    .size(32.dp)
                    .clickable {
                        navController.navigate(Screen.IconeDeAjuda2.route)
                    },
                tint = Color.Gray
            )

            // Ícone de Perfil (Clicável)
            Icon(
                imageVector = Icons.Filled.AccountCircle,
                contentDescription = "Ícone de Perfil",
                modifier = Modifier
                    .size(32.dp)
                    .clickable {
                        navController.navigate(Screen.IconePerfilADM3.route)
                    },
                tint = Color.Gray
            )
        }
    }
}
