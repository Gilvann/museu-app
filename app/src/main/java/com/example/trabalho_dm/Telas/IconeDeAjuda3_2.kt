package com.example.trabalho_dm.Telas

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.trabalho_dm.R
import com.example.trabalho_dm.Screen

@Composable
fun IconeDeAjuda3_2(navController: NavController){
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
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(text = "\n\n\nProblemas técnicos ? Peça ajuda ao suporte!\n\n",
                modifier = Modifier,
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
                color = Color.White
            )

            Text(
                text = "WhatsApp: 85 9******** \n",
                color = Color.White
            )
            Text(
                text = "telefone: 3030-****",
                color = Color.White
            )
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
                        navController.navigate(Screen.TelaPrincipalAdmin.route)
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
                        navController.navigate(Screen.IconeDeAjuda3_2.route)
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
                        navController.navigate(Screen.IconePerfilADM3_3.route)
                    },
                tint = Color.Gray
            )
        }
    }
}