package com.example.trabalho_dm.Telas

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.trabalho_dm.R
import com.example.trabalho_dm.Screen
import com.google.firebase.auth.FirebaseAuth


@Composable
fun SimpleTextField(textLabel: String, textHint: String, onTextChange: (String) -> Unit) {
    val (text, setText) = remember { mutableStateOf("") }

    Column {
        Text(
            text = textHint,
            color = Color.White,
            fontSize = 24.sp
        )

        TextField(
            value = text,
            onValueChange = {
                setText(it)
                onTextChange(it)
            },
            label = { Text(textLabel) },
            modifier = Modifier.fillMaxWidth(),
        )
    }
}


@Composable
fun logasrse3_2(navController: NavController) {
    val context = LocalContext.current
    val auth = FirebaseAuth.getInstance()

    // Estado para armazenar o email e senha inseridos
    val (email, setEmail) = remember { mutableStateOf("") }
    val (password, setPassword) = remember { mutableStateOf("") }

    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "Imagem de fundo",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            SimpleTextField(
                textLabel = "Login",
                textHint = "Usuário"
            ) {
                setEmail(it) // Atualiza o estado do email
            }

            SimpleTextField(
                textLabel = "Senha",
                textHint = "Senha"
            ) {
                setPassword(it) // Atualiza o estado da senha
            }
        }

        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = {
                // Autenticação com Firebase
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            navController.navigate(Screen.TelaPrincipalAdmin.route)
                            Toast.makeText(context, "Login realizado com sucesso", Toast.LENGTH_LONG).show()
                        } else {
                            Toast.makeText(context, "Falha na autenticação", Toast.LENGTH_LONG).show()
                        }
                    }
            }) {
                Text(text = "Entrar")
            }

            Button(onClick = {
                navController.navigate(Screen.IconePerfilADM3.route)
                Toast.makeText(context, "Voltar", Toast.LENGTH_LONG).show()
            }) {
                Text(text = "Voltar")
            }
        }
    }
}
