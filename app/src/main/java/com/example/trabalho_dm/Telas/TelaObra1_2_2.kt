package com.example.trabalho_dm.Telas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.trabalho_dm.R
import com.example.trabalho_dm.Screen

@Composable
fun TelaObra1_2_2(navController: NavController) {
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
            // Área da obra
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .background(
                        Color.White,
                        shape = RoundedCornerShape(8.dp)
                    ) // Fundo branco com bordas arredondadas
                    .padding(16.dp)
            ) {
                Text(text = "Área 1:", fontSize = 20.sp, color = Color.Black)
                Text(text = "Obra 2:", fontSize = 24.sp, color = Color.Black)
                Image(
                    painter = painterResource(id = R.drawable.obra_de_arte_o_grito_edvard_munch),
                    contentDescription = "Obra de arte",
                    modifier = Modifier
                        .size(120.dp) // Tamanho da imagem
                        .align(Alignment.CenterHorizontally)
                )
                Text(
                    text = "Informações gerais da obra e breve discussão sobre o momento histórico da obra e o descrição do autor, baseado no movimento artístico",
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    color = Color.Black
                )

                // Botão "Ouvir"
                Button(
                    onClick = { /* Ação ao clicar no botão Ouvir */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp)
                ) {
                    Text(text = "Ouvir")
                }
                Text(text = "Descrição de áudio", fontSize = 14.sp, color = Color.Gray, textAlign = TextAlign.Center)
            }

            // Seção de perguntas e interações
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text(text = "Deseja perguntar algo?\n",
                    fontSize = 23.sp,
                    color = Color.White)

                // Campo de texto para perguntas
                OutlinedTextField(
                    value = textoPergunta,
                    onValueChange = { textoPergunta = it }, // Atualiza o estado quando o texto muda
                    placeholder = {
                        Text("Digite aqui")
                    },
                    modifier = Modifier.fillMaxWidth()
                )
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

                        .clickable { navController.navigate(Screen.TelaPrincipalOMapa.route)},
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