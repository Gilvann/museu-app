package com.example.trabalho_dm.Telas

import android.content.Context.MODE_PRIVATE
import android.util.Log
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.trabalho_dm.R
import com.example.trabalho_dm.Screen
import com.google.firebase.firestore.FirebaseFirestore


data class Obra(
    val id: String,
    val titulo: String
)
@Composable
fun ObraItem(obra: Obra, onEditClick: () -> Unit, onDeleteClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(
            text = obra.titulo,
            color = Color.Black,
            modifier = Modifier.weight(1f)
        )
        IconButton(onClick = onEditClick) {
            Icon(
                imageVector = Icons.Default.Edit,
                contentDescription = "Editar",
                tint = Color.Gray
            )
        }
        IconButton(onClick = onDeleteClick) {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "Excluir",
                tint = Color.Gray
            )
        }
    }
}
@Composable
fun tela_Obras_adm3_1_2(navController: NavController, message: String) {

    val obras = remember { mutableStateListOf<Obra>() }
    val db = FirebaseFirestore.getInstance()
    val showDialog = remember { mutableStateOf(false) }
    var obraToDelete by remember { mutableStateOf<Obra?>(null) }


    // Carregando dados do Firebase
        LaunchedEffect(Unit) {
            db.collection(message).get().addOnSuccessListener { snapshot ->
                obras.clear()
                snapshot.documents.forEach { doc ->
                    obras.add(
                        Obra(
                            id = doc.id,
                            titulo = doc.getString("titulo") ?: "Sem título",

                        )
                    )
                }
            }.addOnFailureListener {
                Log.e("Firebase", "Erro ao carregar obras: ${it.message}")
            }
        }

        // Layout
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.background),
                contentDescription = "Imagem de fundo",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
            ) {

            Spacer(modifier = Modifier.height(50.dp))

            // Lista de Obras
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
            ) {

            if (obras.isEmpty()) {
                Text(
                    text = "Carregando obras...",
                    color = Color.Gray,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            } else {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            MaterialTheme.colorScheme.background.copy(alpha = 0.9f),
                            shape = MaterialTheme.shapes.medium
                        ),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(obras) { obra ->
                        ObraItem(
                            obra = obra,
                            onEditClick = { navController.navigate("tela obra/${obra.id}/${message}") },
                            onDeleteClick = {
                                obraToDelete = obra
                                showDialog.value = true

                            }
                        )
                    }
                }}
                Button(
                    onClick = { navController.navigate("adicionar/${message}") },
                    modifier = Modifier.align(Alignment.CenterHorizontally).padding(16.dp)
                ) {
                    Text("Adicionar Obra")
                }}
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp).align(Alignment.BottomCenter),
                horizontalArrangement = Arrangement.SpaceEvenly, // Distribui os ícones igualmente
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
            if (showDialog.value && obraToDelete != null) {
                AlertDialog(
                    onDismissRequest = { showDialog.value = false },
                    title = { Text(text = "Confirmar exclusão") },
                    text = {
                        Text("Tem certeza que deseja excluir a obra \"${obraToDelete?.titulo}\"?")
                    },
                    confirmButton = {
                        TextButton(
                            onClick = {
                                db.collection(message).document(obraToDelete!!.id).delete()
                                    .addOnSuccessListener {
                                        obras.remove(obraToDelete)
                                        showDialog.value = false
                                    }
                                    .addOnFailureListener { e ->

                                    }
                            }
                        ) {
                            Text("Excluir", color = Color.Red)
                        }
                    },
                    dismissButton = {
                        TextButton(
                            onClick = { showDialog.value = false }
                        ) {
                            Text("Cancelar")
                        }
                    }
                )
                }
            }
}





