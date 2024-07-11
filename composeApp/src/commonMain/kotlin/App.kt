import Features.MultiThreading.networking.InsultCensorClient
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import cafe.adriel.voyager.navigator.Navigator
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
@Preview
fun App(
    client: InsultCensorClient
) {
    MaterialTheme {
        Navigator(
            HomeScreen(client)

        )
    }
}