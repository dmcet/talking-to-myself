package de.cetvericov.talkingtomyself.ui.views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.cetvericov.talkingtomyself.data.Message
import de.cetvericov.talkingtomyself.viewmodels.MessageBoxViewModel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Composable
fun MessageBox(viewModel: MessageBoxViewModel) {
    val messageList = remember {
        viewModel.messages
    }

    Surface(
        border = BorderStroke(1.dp, MaterialTheme.colors.secondary),
        modifier = Modifier.fillMaxWidth().fillMaxHeight(0.9f)
    ) {
        LazyColumn(reverseLayout = true) {
            messageList.forEach {
                item {
                    MessageBubble(message = it)
                }
            }
        }
    }

}

@Composable
fun MessageBubble(message: Message) {
    Surface(
        modifier = Modifier.padding(10.dp).fillMaxWidth(),
        elevation = 5.dp,
        shape = MaterialTheme.shapes.medium,
        border = BorderStroke(1.dp, MaterialTheme.colors.secondaryVariant)
    ) {
        Column {
            Text(
                text = message.timestamp.format(
                    DateTimeFormatter.ofPattern("hh:mm:ss, dd.MM.yyyy")
                ),
                style = MaterialTheme.typography.subtitle2,
                modifier = Modifier
                    .align(alignment = Alignment.End)
                    .padding(3.dp),
                color = MaterialTheme.colors.secondaryVariant
            )
            Text(
                text = message.content,
                style = MaterialTheme.typography.body1,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(3.dp)
            )
        }
    }
}

@Preview
@Composable
fun MessageBoxPreview() {
    MessageBox(viewModel = MessageBoxViewModel().also {
        it.messages.add(Message(LocalDateTime.now(), "Hello"))
        it.messages.add(Message(LocalDateTime.now(), "This is me."))
    })
}

@Preview(showBackground = true)
@Composable
fun MessageBubblePreview() {
    MessageBubble(
        message = Message(
            timestamp = LocalDateTime.now(),
            content = "Now this is a very very very very very very long text"
        )
    )
}