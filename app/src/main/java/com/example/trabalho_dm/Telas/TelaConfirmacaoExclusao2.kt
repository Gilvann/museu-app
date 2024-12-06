package com.example.trabalho_dm.Telas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
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
fun TelaConfirmacaoExclusao2(navController: NavController) {
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

            ) {
            // Texto de confirmação de exclusão
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .background(Color.White, shape = RoundedCornerShape(8.dp)) // Fundo branco com bordas arredondadas
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Tem certeza que deseja excluir essa área?",
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Botão de confirmação (vermelho)
                Button(
                    onClick = { navController.navigate(Screen.TelaPrincipalAdmin.route)},
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Confirmar", color = Color.White)
                }

            }

            // Botão "Voltar" no final da tela
            Button(
                onClick = { navController.navigate(Screen.TelaPrincipalAdmin.route) },
                modifier = Modifier
                    .padding(top = 16.dp)
            ) {
                Text(text = "Voltar")
            }


            Box(Modifier.fillMaxSize()){
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .align(Alignment.BottomCenter),
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
                            .clickable { /* Ação ao clicar no ícone de Pergunta */ },
                        tint = Color.Gray
                    )

                    // Ícone de Perfil (Clicável)
                    Icon(
                        imageVector = Icons.Filled.AccountCircle,
                        contentDescription = "Ícone de Perfil",
                        modifier = Modifier
                            .size(32.dp)
                            .clickable { /* Ação ao clicar no ícone de Perfil */ },
                        tint = Color.Gray
                    )
                }
            }
        }
    }
}