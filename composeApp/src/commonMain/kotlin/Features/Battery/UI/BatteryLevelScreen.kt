package Features.Battery

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow

class BatteryLevelScreen : Screen {



    @Composable
    override fun Content() = Scaffold {

        val nav = LocalNavigator.currentOrThrow
        Column() {
            Button(
                onClick = { nav.pop() }
            ) {
                Text("Features.Battery Screen")
            }
        }
    }
}