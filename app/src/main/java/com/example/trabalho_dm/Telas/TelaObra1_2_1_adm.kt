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
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import androidx.compose.ui.platform.LocalContext
@Composable
fun TelaObra1_2_1_adm(navController: NavController, message: String, colecao: String) {

    var cont = LocalContext.current
    var id = message
    var fb = Firebase.firestore
    val textState = remember { mutableStateOf("") }
    val tituloState = remember { mutableStateOf("") }
    LaunchedEffect(true) {

        fb.collection(colecao).document(id).get().addOnSuccessListener {
                doc ->
            textState.value = doc.get("descricao").toString()
        }
    }
    LaunchedEffect(true) {

        fb.collection(colecao).document(id).get().addOnSuccessListener {
                doc ->
            tituloState.value = doc.get("titulo").toString()
        }
    }

    // Função para atualizar a descrição da obra
    fun updateDescricao(obraId: String, novaDescricao: String) {
        val db = FirebaseFirestore.getInstance()
        db.collection(colecao).document(obraId)
            .update("descricao", novaDescricao)
            .addOnSuccessListener {

            }
            .addOnFailureListener { e ->
                // Lidar com erro
            }
    }
    fun updateTitulo(obraId: String, novaDescricao: String) {
        val db = FirebaseFirestore.getInstance()
        db.collection(colecao).document(obraId)
            .update("titulo", novaDescricao)
            .addOnSuccessListener {

            }
            .addOnFailureListener { e ->
                // Lidar com erro
            }
    }

        // Função para excluir a obra

    fun deleteField(obraId: String, vazio: String) {
        val db = FirebaseFirestore.getInstance()
        db.collection(colecao).document(obraId)
            .update("descricao", vazio)
            .addOnSuccessListener {
                // Limpa o estado do campo de descrição
                textState.value = ""
            }
            .addOnFailureListener { e ->
                // Lidar com erro
            }
    }

    fun deleteTitulo(obraId: String, vazio: String) {
        val db = FirebaseFirestore.getInstance()
        db.collection(colecao).document(obraId)
            .update("titulo", vazio)
            .addOnSuccessListener {
                // Limpa o estado do campo de título
                tituloState.value = ""
            }
            .addOnFailureListener { e ->
                // Lidar com erro
            }
    }




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

                // Título da Obra com Ícones ao lado
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween, // Ícones ao lado direito
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Obra : ", fontSize = 24.sp, color = Color.Black)
                    TextField(
                        value = tituloState.value,
                        onValueChange = { tituloState.value = it },
                        modifier = Modifier.width(120.dp)
                             // O TextField vai ocupar toda a largura da tela
                            .height(60.dp) // Altura aumentada para ocupar metade da tela (ajuste a altura conforme necessário)
                    )

                    // Ícones de editar e remover lado a lado
                    Row {
                        // Ícone para Editar a descrição
                        IconButton(
                            onClick = {
                                // Insira a ação para editar a descrição
                                updateTitulo(obraId = id, novaDescricao = tituloState.value)
                            },
                            modifier = Modifier.size(32.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Edit,
                                contentDescription = "Editar descrição",
                                tint = Color.Gray
                            )
                        }


                        Spacer(modifier = Modifier.width(8.dp))

                        // Ícone para Excluir a obra
                        IconButton(
                            onClick = {
                                deleteTitulo(obraId = id, vazio = "")

                            },
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

                // Imagem da obra
                Image(
                    painter = painterResource(id = R.drawable.quadro_mona_lisa),
                    contentDescription = "Obra de arte",
                    modifier = Modifier
                        .size(120.dp)
                        .align(Alignment.CenterHorizontally)
                )

             //   Text(
               //     text = "Informações gerais da obra e breve discussão sobre o momento histórico da obra e a descrição do autor, baseado no movimento artístico",
                 //   fontSize = 16.sp,
                   // textAlign = TextAlign.Center,
                   // color = Color.Black
               // )

                TextField(
                    value = textState.value,
                    onValueChange = { textState.value = it },
                    modifier = Modifier
                        .fillMaxWidth() // O TextField vai ocupar toda a largura da tela
                        .height(60.dp) // Altura aumentada para ocupar metade da tela (ajuste a altura conforme necessário)
                )

                Row {
                    IconButton(
                        onClick = { updateDescricao(obraId = id, novaDescricao = textState.value) },
                        modifier = Modifier.size(32.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Edit,
                            contentDescription = "Editar imagem",
                            tint = Color.Gray
                        )
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    IconButton(
                        onClick = { deleteField(obraId = id, vazio = "") },
                        modifier = Modifier.size(32.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Delete,
                            contentDescription = "Remover imagem",
                            tint = Color.Gray
                        )
                    }
                }

                // Botão "Ouvir"
                Button(
                    onClick = { /* Ação ao clicar no botão Ouvir */ },
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
