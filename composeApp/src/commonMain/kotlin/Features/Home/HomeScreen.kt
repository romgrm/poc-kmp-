
import Features.Battery.BatteryLevelScreen
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow

class HomeScreen : Screen {
    @Composable
    override fun Content() = Scaffold {
        val nav = LocalNavigator.currentOrThrow
        Column() {
            Button(
                onClick = { nav.push(BatteryLevelScreen()) }
            ) {
                Text("Home Screen")

            }
        }
    }
}