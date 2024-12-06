package com.example.trabalho_dm

sealed class Screen(val route:String) {
    object IconePerfilADM3_3: Screen("iconePerfilADM3_3")
    object IconeDeAjuda2: Screen("iconeDeAjuda2")
    object IconePerfilADM3: Screen("iconePerfilADM3")
    object AbaDePesquisa1_3: Screen("abaDePesquisa1_3")
    object AbaDePesquisa3_1_3: Screen("abaDePesquisa3_1_3")
    object TelaObra1_2_1: Screen("telaObra1_2_1")
    object tela_Obras1_2: Screen("tela_Obras1_2")
    object tela_Obras_adm3_1_2: Screen("tela_Obras_adm3_1_2")
    object tela_Obras_adm3_1_3: Screen("tela_Obras_adm3_1_3")
    object logasrse3_2: Screen("logasrse3_2")
    object TelaObra1_2_2: Screen("TelaObra1_2_2")
    object TelaObra1_2_1_adm: Screen("TelaObra1_2_1_adm")
    object TelaConfirmacaoExclusao: Screen("TelaConfirmacaoExclusao")
    object TelaConfirmacaoExclusao2: Screen("TelaConfirmacaoExclusao2")
    object TelaPrincipalOMapa: Screen("TelaPrincipalOMapa")
    object TelaPrincipalAdmin: Screen("TelaPrincipalAdmin")
    object TelaObra1_2_1_adm_AdicionarObra: Screen("TelaObra1_2_1_adm_AdicionarObra")
    object IconeDeAjuda3_2: Screen("iconeDeAjuda3_2")
}