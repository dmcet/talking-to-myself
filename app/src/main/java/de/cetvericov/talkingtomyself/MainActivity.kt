package de.cetvericov.talkingtomyself

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import de.cetvericov.talkingtomyself.data.Message
import de.cetvericov.talkingtomyself.ui.theme.TalkingToMyselfTheme
import de.cetvericov.talkingtomyself.ui.views.ChatBar
import de.cetvericov.talkingtomyself.ui.views.MessageBox
import de.cetvericov.talkingtomyself.viewmodels.ChatBarViewModel
import de.cetvericov.talkingtomyself.viewmodels.MessageBoxViewModel
import java.time.LocalDateTime

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val messageBoxViewModel = MessageBoxViewModel()

        setContent {
            TalkingToMyselfTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column {
                        MessageBox(
                            viewModel = messageBoxViewModel
                        )

                        ChatBar(viewModel = ChatBarViewModel {
                            messageBoxViewModel.messages.add(
                                Message(LocalDateTime.now(), it)
                            )
                        })
                    }
                }


            }
        }
    }
}


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TalkingToMyselfTheme {
        Greeting("Android")
    }
}