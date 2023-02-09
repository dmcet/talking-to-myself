package de.cetvericov.talkingtomyself.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ChatBarViewModel : ViewModel() {
    var text = mutableStateOf("")
        private set

    fun updateText(input: String) {
        text.value = input
    }

    fun sendToMessageBox() {

    }
}