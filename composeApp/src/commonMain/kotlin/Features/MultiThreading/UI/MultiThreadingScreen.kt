package Features.MultiThreading.UI

import Features.Battery.BatteryLevelScreen
import Features.MultiThreading.Usecases.multithreadingData
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ButtonElevation
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow

class MultiThreadingScreen : Screen{

    @Composable
    override fun Content() = Scaffold {
        Column() {
            Button(
                elevation = ButtonDefaults.elevation(defaultElevation= Dp(8f)),
                onClick = { multithreadingData. }
            ) {
                Text("get Post")
            }
        }
    }
}