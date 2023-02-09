package de.cetvericov.talkingtomyself.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import de.cetvericov.talkingtomyself.data.Message

class MessageBoxViewModel : ViewModel() {
    val messages = mutableStateListOf<Message>()
}