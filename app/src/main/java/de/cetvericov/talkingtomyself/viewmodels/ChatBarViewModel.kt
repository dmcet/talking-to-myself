package de.cetvericov.talkingtomyself.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ChatBarViewModel(private val onSend: (String) -> Unit) : ViewModel() {
    val text = mutableStateOf("")

    fun updateText(input: String) {
        text.value = input

    }

    fun send() {
        onSend(text.value)
        text.value = ""
    }
}