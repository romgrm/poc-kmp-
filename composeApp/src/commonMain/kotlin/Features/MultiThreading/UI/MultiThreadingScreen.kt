package Features.MultiThreading.UI

import Features.MultiThreading.networking.InsultCensorClient
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import cafe.adriel.voyager.core.screen.Screen
import org.jetbrains.compose.ui.tooling.preview.Preview
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import createHttpClient
import io.ktor.client.HttpClient
import org.jetbrains.compose.resources.painterResource

import kotlinx.coroutines.launch
import util.NetworkError
import util.onError
import util.onSuccess
class MultiThreadingScreen(client: InsultCensorClient) : Screen {
    private var censorClient = InsultCensorClient(createHttpClient(okHttp))
    @Composable
    @Preview
    override fun Content() = MaterialTheme {
//        val client = viewModel<InsultCensorClient>(factory = object : ViewModelProvider.Factory {
//            fun <T : ViewModel> create(modelClass : Class<T>): T {
//                return InsultCensorClient (
//                    createHttpClient(OkHttp.create())
//                ) as T
//            }
//        })
        var censoredText by remember {
            mutableStateOf<String?>(null)
        }
        var uncensoredText by remember {
            mutableStateOf("")
        }
        var isLoading by remember {
            mutableStateOf(false)
        }
        var errorMessage by remember {
            mutableStateOf<NetworkError?>(null)
        }
        val scope = rememberCoroutineScope()
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically)
        ) {
            TextField(
                value = uncensoredText,
                onValueChange = {uncensoredText = it},
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth(),
                placeholder = {
                    Text("Uncensored text")
                }
            )
            Button(onClick = {
                // do NOT do this, scope would be cancelled if the user rotates the screen for example
                scope.launch {
                    isLoading = true
                    errorMessage = null

                    censorClient.censorWords(uncensoredText)
                        .onSuccess {
                            censoredText = it
                        }
                        .onError {
                            errorMessage = it
                        }
                    isLoading = false
                }
            }) {
                if(isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .size(15.dp),
                        strokeWidth = 1.dp,
                        color = Color.White
                    )
                } else {
                    Text("Censor!")
                }
            }
            censoredText?.let {
                Text(it)
            }
            errorMessage?.let{
                Text(
                    text = it.name,
                    color = Color.Red
                )
            }
        }
    }
}