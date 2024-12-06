package com.example.trabalho_dm.Telas

import android.media.MediaPlayer
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
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.trabalho_dm.R
import com.example.trabalho_dm.Screen
import com.example.trabalho_dm.GeminiViewModel
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun TelaObra1_2_1(
    navController: NavController,
    viewModel: GeminiViewModel,
    message: String,
    colecao: String
) {
    // Estado para armazenar o texto do campo de entrada
    var textState = remember { mutableStateOf("") }

    // Obtenha o contexto do Composable
    val context = LocalContext.current

    // Crie o MediaPlayer com o contexto
    val mediaPlayer = remember {
        MediaPlayer.create(context, R.raw.funny) // Certifique-se de usar o nome correto do arquivo
    }
    val title = remember { mutableStateOf("Carregando título...") }
    val description = remember { mutableStateOf("Carregando descrição...") }

    // Carregar dados do Firebase Firestore
    LaunchedEffect(Unit) {
        val db = FirebaseFirestore.getInstance()
        val documentRef = db.collection(colecao).document(message)

        documentRef.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    title.value = document.getString("titulo") ?: "Título não encontrado"
                    description.value = document.getString("descricao") ?: "Descrição não encontrada"
                } else {
                    title.value = "Documento não encontrado"
                    description.value = "Erro ao carregar descrição"
                }
            }
            .addOnFailureListener { e ->
                title.value = "Erro ao carregar título"
                description.value = "Erro: ${e.message}"
            }
    }

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
                Text(text = title.value, fontSize = 24.sp, color = Color.Black)
                Image(
                    painter = painterResource(id = R.drawable.quadro_mona_lisa),
                    contentDescription = "Obra de arte",
                    modifier = Modifier
                        .size(120.dp) // Tamanho da imagem
                        .align(Alignment.CenterHorizontally)
                )
                Text(
                    text = description.value,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    color = Color.Black
                )

                Button(
                    onClick = {
                        if (mediaPlayer.isPlaying) {
                            mediaPlayer.pause() // Pausa o áudio se já estiver tocando
                        } else {
                            mediaPlayer.start() // Inicia o áudio
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp)
                ) {
                    Text(text = "Ouvir")
                }
                Text(
                    text = "Descrição de áudio",
                    fontSize = 14.sp,
                    color = Color.Gray,
                    textAlign = TextAlign.Center
                )
            }

            // Seção de perguntas e interações
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text("Desejá perguntar algo?", color = Color.White)
                TextField(
                    value = textState.value,
                    onValueChange = { newText ->
                        textState.value = newText },
                    placeholder = {Text("Pergunte aqui")}
                )
                Button( onClick = {
                    viewModel.callIA(textState.value)
                }) {

                    Text("Call IA")
                }


                Text(viewModel.resposta,color = Color.White)
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