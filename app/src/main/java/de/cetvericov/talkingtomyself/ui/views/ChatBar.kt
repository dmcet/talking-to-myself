package de.cetvericov.talkingtomyself.ui.views

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.cetvericov.talkingtomyself.viewmodels.ChatBarViewModel

@Composable
fun ChatBar(viewModel: ChatBarViewModel) {
    val text = remember {
        viewModel.text
    }
    
    Row(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        ) {
        TextField(
            value = text.value,
            onValueChange = { value: String ->
                viewModel.updateText(value)
            }
        )
        Button(
            onClick = viewModel::send,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .defaultMinSize(30.dp, 30.dp)
                .padding(10.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.Email,
                contentDescription = "Send icon"
            )
        }
    }
}

@Preview
@Composable
fun ChatBarPreview() {
    Surface {
        ChatBar(viewModel = ChatBarViewModel({}))
    }
}