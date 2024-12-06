package com.example.trabalho_dm.Telas

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.trabalho_dm.R
import com.example.trabalho_dm.Screen

@Composable
fun TelaPrincipalOMapa(navController: NavController) {
    // Estado para armazenar o texto do campo de entrada
    var textoPergunta by remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Imagem de fundo
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "Imagem de fundo",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween // Espaça os elementos verticalmente
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Mapa Geral",
                    fontSize = 35.sp,
                    color = Color.White,
                    modifier = Modifier.padding(bottom = 16.dp)
                )


                Image(
                    painter = painterResource(id = R.drawable.mapa_museu_1),
                    contentDescription = "Mapa Geral",
                    modifier = Modifier
                        .fillMaxWidth(0.9f) // Aumenta a imagem para quase toda a largura da tela (90%)
                        .height(300.dp)
                        .align(Alignment.CenterHorizontally)
                )
            }

            // Espaço para os botões laterais
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.BottomStart
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier.padding(start = 16.dp)
                ) {
                    // Botões à esquerda ("Área 1", "Área 2", "Área 3")
                    Button(
                        onClick = { navController.navigate("Area1/obras") },
                        modifier = Modifier.fillMaxWidth(0.4f) // Botões um pouco mais largos (40% da largura da tela)
                    ) {
                        Text(text = "Área 1")
                    }
                    Button(
                        onClick = { navController.navigate("Area1/obras 2")},
                        modifier = Modifier.fillMaxWidth(0.4f)
                    ) {
                        Text(text = "Área 2")
                    }
                    Button(
                        onClick = { navController.navigate("Area1/obras 3") },
                        modifier = Modifier.fillMaxWidth(0.4f)
                    ) {
                        Text(text = "Área 3")
                    }
                }

                // Botão de "Pesquisar" à direita
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.BottomEnd
                ) {
                    Button(
                        onClick = { navController.navigate(Screen.AbaDePesquisa1_3.route) },
                        modifier = Modifier
                            .fillMaxWidth(0.4f) // Botão "Pesquisar" também mais largo
                            .padding(end = 16.dp)
                    ) {
                        Text(text = "Pesquisar")
                    }
                }
            }

            // Ícones na parte inferior, alinhados em sequência
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly // Distribui os ícones igualmente
            ) {
                // Ícone de Home (Clicável)
                Icon(
                    imageVector = Icons.Filled.Home,
                    contentDescription = "Ícone de Home",
                    modifier = Modifier
                        .size(32.dp)
                        .clickable { /* Ação ao clicar no ícone Home */ },
                    tint = Color.Gray
                )

                // Ícone de Pergunta (Clicável)
                Icon(
                    imageVector = Icons.Filled.Info,
                    contentDescription = "Ícone de Pergunta",
                    modifier = Modifier
                        .size(32.dp)
                        .clickable { navController.navigate(Screen.IconeDeAjuda2.route) },
                    tint = Color.Gray
                )

                // Ícone de Perfil (Clicável)
                Icon(
                    imageVector = Icons.Filled.AccountCircle,
                    contentDescription = "Ícone de Perfil",
                    modifier = Modifier
                        .size(32.dp)
                        .clickable { navController.navigate(Screen.IconePerfilADM3.route) },
                    tint = Color.Gray
                )
            }
        }
    }
}