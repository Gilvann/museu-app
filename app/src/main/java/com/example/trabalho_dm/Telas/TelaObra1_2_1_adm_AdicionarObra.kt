package com.example.trabalho_dm.Telas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.trabalho_dm.R
import com.example.trabalho_dm.Screen
import com.google.firebase.firestore.ktx.*
import com.google.firebase.ktx.Firebase


@Composable
fun TelaObra1_2_1_adm_AdicionarObra(navController: NavController, message: String) {

    var textoPergunta by remember { mutableStateOf("") }
    var titulo by remember { mutableStateOf("") }

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
                    )
                    .padding(16.dp)
            ) {
                Text(text = "Área 1:", fontSize = 20.sp, color = Color.Black)

                // Título da Obra com Ícones ao lado
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween, // Ícones ao lado direito
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Obra: ", fontSize = 24.sp, color = Color.Black)
                    OutlinedTextField(
                        value = titulo,
                        onValueChange = { titulo = it }, // Atualiza o estado quando o texto muda
                        placeholder = {
                            Text("Digite aqui")
                        },
                        modifier = Modifier.fillMaxWidth()
                    )

                    // Ícones de editar e remover lado a lado
                    Row {
                        IconButton(
                            onClick = { /* Ação ao clicar para editar */ },
                            modifier = Modifier.size(32.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Edit,
                                contentDescription = "Editar obra",
                                tint = Color.Gray
                            )
                        }

                        Spacer(modifier = Modifier.width(8.dp))

                        IconButton(
                            onClick = { /* Ação ao clicar para remover */ },
                            modifier = Modifier.size(32.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Delete,
                                contentDescription = "Remover obra",
                                tint = Color.Gray
                            )
                        }
                    }
                }

                // Área em branco que substitui a foto
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                        .background(
                            Color.LightGray,
                            shape = RoundedCornerShape(8.dp)
                        )
                        .border(1.dp, Color.Gray, RoundedCornerShape(8.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Espaço para adicionar imagem", color = Color.Gray)
                }
                Row {
                    Text(text = "Espaço para adicionar descrição", color = Color.Gray)

                }
                OutlinedTextField(
                    value = textoPergunta,
                    onValueChange = { textoPergunta = it }, // Atualiza o estado quando o texto muda
                    placeholder = {
                        Text("Digite aqui")
                    },
                    modifier = Modifier.fillMaxWidth()
                )

                // Botão "Adicionar Obra"
                Button(
                    onClick = {
                        var fb = Firebase.firestore
                        fb.collection(message)
                            .add(mapOf(
                                "titulo" to titulo,
                                "imagem" to "converter imagem em string", //dica pesquisar BASE64
                                "descricao" to textoPergunta,
                            ))
                        navController.popBackStack()
                              },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp)
                ) {
                    Text(text = "Adicionar Obra")
                }
            }

            // Seção de perguntas e interações
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text(
                    text = "Deseja perguntar algo?\n",
                    fontSize = 23.sp,
                    color = Color.White
                )

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
                        .clickable { navController.navigate(Screen.TelaPrincipalAdmin.route) },
                    tint = Color.Gray
                )

                // Ícone de Pergunta (Clicável)
                Icon(
                    imageVector = Icons.Filled.Info,
                    contentDescription = "Ícone de Pergunta",
                    modifier = Modifier
                        .size(32.dp)
                        .clickable { navController.navigate(Screen.IconeDeAjuda3_2.route) },
                    tint = Color.Gray
                )

                // Ícone de Perfil (Clicável)
                Icon(
                    imageVector = Icons.Filled.AccountCircle,
                    contentDescription = "Ícone de Perfil",
                    modifier = Modifier
                        .size(32.dp)
                        .clickable { navController.navigate(Screen.IconePerfilADM3_3.route) },
                    tint = Color.Gray
                )
            }
        }
    }
}
