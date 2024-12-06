package com.example.trabalho_dm
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.google.ai.client.generativeai.GenerativeModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GeminiViewModel:ViewModel() {
    val viewModelScope = CoroutineScope(Dispatchers.IO)

    var prompt by mutableStateOf("")
    var resposta by mutableStateOf("")



    fun callIA(value: String) {
        prompt = value
        viewModelScope.launch {
            GeminiIA()
        }
    }

    private suspend fun GeminiIA(){
        val generativeModel =
            GenerativeModel(
                // Specify a Gemini model appropriate for your use case
                modelName = "gemini-1.5-flash",
                // Access your API key as a Build Configuration variable (see "Set up your API key" above)
                apiKey = "AIzaSyCqIOUpmpdz4fIyb0HxdoFWa0P_e4gqEVw" )

        var textoRetorno=  generativeModel.generateContent(prompt).text.toString()
        resposta = textoRetorno
    }
}