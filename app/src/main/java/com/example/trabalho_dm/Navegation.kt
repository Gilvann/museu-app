package com.example.trabalho_dm

import com.example.trabalho_dm.Telas.AbaDePesquisa1_3
import com.example.trabalho_dm.Telas.AbaDePesquisa3_1_3
import com.example.trabalho_dm.Telas.IconeDeAjuda2
import com.example.trabalho_dm.Telas.IconeDeAjuda3_2
import com.example.trabalho_dm.Telas.IconePerfilADM3
import com.example.trabalho_dm.Telas.IconePerfilADM3_3
import com.example.trabalho_dm.Telas.TelaConfirmacaoExclusao
import com.example.trabalho_dm.Telas.TelaConfirmacaoExclusao2
import com.example.trabalho_dm.Telas.TelaObra1_2_1
import com.example.trabalho_dm.Telas.TelaObra1_2_1_adm
import com.example.trabalho_dm.Telas.TelaObra1_2_1_adm_AdicionarObra
import com.example.trabalho_dm.Telas.TelaObra1_2_2
import com.example.trabalho_dm.Telas.TelaPrincipalAdmin
import com.example.trabalho_dm.Telas.TelaPrincipalOMapa
import com.example.trabalho_dm.Telas.logasrse3_2
import com.example.trabalho_dm.Telas.tela_Obras1_2
import com.example.trabalho_dm.Telas.tela_Obras_adm3_1_2
import com.example.trabalho_dm.Telas.tela_Obras_adm3_1_3
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument


@Composable
fun Navigation(){
    val navController = rememberNavController();
    NavHost(navController = navController, startDestination = Screen.TelaPrincipalOMapa.route){
        composable(route = Screen.IconePerfilADM3_3.route){
            IconePerfilADM3_3(navController)
        }
        composable(route = Screen.IconeDeAjuda2.route){
            IconeDeAjuda2(navController)
        }
        composable(route = Screen.IconePerfilADM3.route){
           IconePerfilADM3(navController)
        }
        composable(route = Screen.AbaDePesquisa1_3.route){
            AbaDePesquisa1_3(navController)
        }
        composable("Obra1/{message}/{colecao}",
            arguments = listOf(navArgument("message") { type = NavType.StringType },navArgument("colecao") { type = NavType.StringType })
        ) { backStackEntry ->
            val message = backStackEntry.arguments?.getString("message") ?: "Sem mensagem"
            val colecao = backStackEntry.arguments?.getString("colecao") ?: "Sem mensagem"
            var viewmodel = GeminiViewModel()
            TelaObra1_2_1(navController,viewmodel,message,colecao)
        }
        composable("Area1/{texto}",
            arguments = listOf(navArgument("texto") { type = NavType.StringType })
        ) { backStackEntry ->
            val texto = backStackEntry.arguments?.getString("texto") ?: "Sem mensagem"
            tela_Obras1_2(navController, texto)
        }
        composable("ordem/{texto}",
            arguments = listOf(navArgument("texto") { type = NavType.StringType })
        ) { backStackEntry ->
            val texto = backStackEntry.arguments?.getString("texto") ?: "Sem mensagem"
            tela_Obras_adm3_1_2(navController, texto)
        }
        composable(route = Screen.logasrse3_2.route){
            logasrse3_2(navController)
        }
        composable(route = Screen.TelaObra1_2_2.route){
            TelaObra1_2_2(navController)
        }
        composable("tela obra/{message}/{colecao}",
            arguments = listOf(navArgument("message") { type = NavType.StringType },navArgument("colecao") { type = NavType.StringType })
        ) { backStackEntry ->
            val message = backStackEntry.arguments?.getString("message") ?: "Sem mensagem"
            val colecao = backStackEntry.arguments?.getString("colecao") ?: "Sem mensagem"
            TelaObra1_2_1_adm(navController, message, colecao)
        }
        composable(route = Screen.TelaConfirmacaoExclusao.route){
            TelaConfirmacaoExclusao(navController)
        }
        composable(route = Screen.TelaConfirmacaoExclusao2.route){
            TelaConfirmacaoExclusao2(navController)
        }
        composable(route = Screen.TelaPrincipalOMapa.route){
            TelaPrincipalOMapa(navController)
        }
        composable(route = Screen.TelaPrincipalAdmin.route){
            TelaPrincipalAdmin(navController)
        }
        composable("adicionar/{message}",
            arguments = listOf(navArgument("message") { type = NavType.StringType })
        ) { backStackEntry ->
            val message = backStackEntry.arguments?.getString("message") ?: "Sem mensagem"
            TelaObra1_2_1_adm_AdicionarObra(navController,message )
        }
        composable(route = Screen.AbaDePesquisa3_1_3.route){
            AbaDePesquisa3_1_3(navController)
        }
        composable(route = Screen.IconeDeAjuda3_2.route){
            IconeDeAjuda3_2(navController)
        }
        composable(route = Screen.tela_Obras_adm3_1_3.route){
            tela_Obras_adm3_1_3(navController)
        }
    }
}