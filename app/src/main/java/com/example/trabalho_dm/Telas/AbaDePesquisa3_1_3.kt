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
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
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

@Composable
fun AbaDePesquisa3_1_3(navController: NavController){
    val textState = remember { mutableStateOf("") }
    val colecaoState = remember { mutableStateOf("") }
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
                .fillMaxSize()
                .padding(16.dp), // Adicionando padding para evitar que o texto fique muito nas bordas
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "\n\n\n\n Deseja procurar alguma obra específica ?\n",
                fontSize = 27.sp,
                color = Color.White,
            )

            Text(
                text = "Digite aqui:\n\n",
                fontSize = 34.sp,
                color = Color.White,
            )

            // TextField aumentado para ocupar metade da tela em altura

            TextField(
                value = textState.value,
                onValueChange = { textState.value = it },
                placeholder = { Text("Digite o nome da obra") },
                modifier = Modifier
                    .fillMaxWidth() // O TextField vai ocupar toda a largura da tela
                    .height(60.dp) // Altura aumentada para ocupar metade da tela (ajuste a altura conforme necessário)
            )
            TextField(
                value = colecaoState.value,
                onValueChange = { colecaoState.value = it },
                placeholder = { Text("Digite a coleção da obra") },
                modifier = Modifier
                    .fillMaxWidth() // O TextField vai ocupar toda a largura da tela
                    .height(60.dp) // Altura aumentada para ocupar metade da tela (ajuste a altura conforme necessário)
            )

            Spacer(modifier = Modifier.height(16.dp)) // Espaço entre o TextField e o botão
            // Botão de enviar
            Button(
                onClick = {

                    navController.navigate("tela obra/${textState.value}/${colecaoState.value}")

                    // Exemplo: envie o texto digitado para algum lugar ou navegue para outra tela
                },
                modifier = Modifier
                    .fillMaxWidth() // O botão também vai ocupar toda a largura
                    .height(50.dp)  // Altura ajustada do botão
            ) {
                Text(text = "Pesquisar", fontSize = 18.sp)
            }

            // Botão de Voltar
            Box(

            ) {
                Button(onClick = {
                    navController.navigate(Screen.TelaPrincipalAdmin.route)
                }) {
                    Text(text = "Voltar")
                }
            }
            // createCols()

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
                        navController.navigate(Screen.AbaDePesquisa3_1_3.route)
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