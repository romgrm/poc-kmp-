package Features.Battery.ViewModels

import IGetBatteryLevel
import androidx.lifecycle.ViewModel

class BatteryViewModel(
    private val getBatteryLevel: IGetBatteryLevel
) : ViewModel() {
    fun getBatteryLevel() : Float {
       return getBatteryLevel.getBatteryLevel()
    }
}