package com.example.trabalho_dm.Telas


import androidx.compose.foundation.Image
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.trabalho_dm.R
import com.example.trabalho_dm.Screen
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


@Composable
fun tela_Obras_adm3_1_3(navController: NavController){
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
        ) {
            Box(Modifier.height(40.dp))
            Row {
                Text(
                    "Área X: ",
                    fontSize = 28.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(16.dp)
                )
                IconButton(
                    onClick = { /* Ação para editar obra */ },
                    modifier = Modifier.size(40.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.Edit,
                        contentDescription = "Editar Obra",
                        tint = Color.Gray
                    )
                }
            }


                Button(onClick = {


                    navController.navigate(Screen.TelaObra1_2_1_adm_AdicionarObra.route) }) {
                    Text(
                        "Adicionar obra",
                        color = Color.White
                    )
                }
            Spacer(modifier = Modifier.weight(1f))
            Box(
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Button(
                    onClick = {
                        navController.navigate(Screen.TelaPrincipalAdmin.route)
                    }
                ) {
                    Text(text = "Voltar")
                }
            }
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.BottomEnd
            ){
                Spacer(modifier = Modifier.height(16.dp)) // Espaçamento antes dos ícones

                // Ícones na parte inferior, alinhados em sequência
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
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
            }
        }
    }
}
