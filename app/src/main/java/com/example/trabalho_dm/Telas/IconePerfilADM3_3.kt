package com.example.trabalho_dm.Telas

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.draw.clip
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
fun IconePerfilADM3_3(navController: NavController){
    val context = LocalContext.current
    val auth = FirebaseAuth.getInstance()
    Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = "#f0f0f0".color) //cor hex que consegui botar, mas por eqnt sem uso
        ) {
            Image(
                painter = painterResource(id = R.drawable.background),
                contentDescription = "Background image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Box(
                    modifier = Modifier.padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {


                    val borderWidth = 4.dp
                    Image(
                        painter = painterResource(id = R.drawable.astarion),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(150.dp)
                            .border(
                                BorderStroke(borderWidth, Color.Yellow),
                                CircleShape
                            )
                            .padding(borderWidth)
                            .clip(CircleShape)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Textos
                Text(text = "Nome: Astarion Ancunín",
                    fontSize = 24.sp,
                    color = Color.White
                )
                Text(text = "Cargo: Administrador chefe",
                    fontSize = 24.sp,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Botão de Logout
                Box(
                    modifier = Modifier,
                    contentAlignment = Alignment.Center
                ) {
                    Button(onClick = {
                        //Autentificação Firebase
                        auth.signOut()
                        navController.navigate(Screen.TelaPrincipalOMapa.route)
                        Toast.makeText(context, "Login realizado com sucesso", Toast.LENGTH_LONG).show()

                    }) {
                        Text(text = "Logout")
                    }
                }
            }

            // Ícones na parte inferior, alinhados em sequência
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter) // Alinha a Row na parte inferior da tela
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly // Distribui os ícones igualmente
            ) {

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


                Icon(
                    imageVector = Icons.Filled.Info,
                    contentDescription = "Ícone de Pergunta",
                    modifier = Modifier
                        .size(32.dp)
                        .clickable {
                            navController.navigate(Screen.IconeDeAjuda3_2.route)
                        },
                    tint = Color.Gray
                )


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

