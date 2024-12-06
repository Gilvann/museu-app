package com.example.trabalho_dm.Telas

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
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
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
import com.google.firebase.firestore.FirebaseFirestore

data class Obras(
    val id: String,
    val titulo: String
)
@Composable
fun ObraItem(obra: Obras, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        TextButton(onClick = onClick) {
            Text(
                text = obra.titulo,
                fontSize = 15.sp,  // Tamanho da fonte ajustado
                color = Color.Black
            )
        }
    }
}
@Composable
fun tela_Obras1_2(navController: NavController, texto: String){
    val obras = remember { mutableStateListOf<Obras>() }
    val db = FirebaseFirestore.getInstance()
    LaunchedEffect(Unit) {
        db.collection(texto).get().addOnSuccessListener { snapshot ->
            obras.clear()
            snapshot.documents.forEach { doc ->
                obras.add(
                    Obras(
                        id = doc.id,
                        titulo = doc.getString("titulo") ?: "Sem título",

                        )
                )
            }
        }.addOnFailureListener {
            Log.e("Firebase", "Erro ao carregar obras: ${it.message}")
        }
    }
    Box(Modifier.fillMaxSize()) {
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
                .padding(16.dp)
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
            ) {
                Text(text = "Obras: ",
                    fontSize = 25.sp,  // Tamanho da fonte ajustado
                    color = Color.White)
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
                                onClick = { navController.navigate("Obra1/${obra.id}/${texto}") })
        }} }

        Box(Modifier.fillMaxSize()){
        // Ícones na parte inferior
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            // Ícone de Home (Clicável)
            Icon(
                imageVector = Icons.Filled.Home,
                contentDescription = "Ícone de Home",
                modifier = Modifier
                    .size(32.dp)
                    .clickable { navController.navigate(Screen.TelaPrincipalOMapa.route) },
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
        } }}}}}
