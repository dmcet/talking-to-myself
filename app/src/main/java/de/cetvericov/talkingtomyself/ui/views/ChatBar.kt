package de.cetvericov.talkingtomyself.ui.views

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.cetvericov.talkingtomyself.viewmodels.ChatBarViewModel

@Composable
fun ChatBar(viewModel: ChatBarViewModel) {
    Row(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,

        ) {
        TextField(
            value = viewModel.text.value,
            onValueChange = { value: String ->
                viewModel.updateText(value)
            }
        )
        Button(
            onClick = viewModel::sendToMessageBox,
            modifier = Modifier.fillMaxWidth().padding(10.dp)
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
        ChatBar(viewModel = ChatBarViewModel())
    }
}