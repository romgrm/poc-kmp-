package Features.Battery.Usecases

import IGetBatteryLevel
import android.content.Context
import android.os.BatteryManager

class AndroidGetBatteryLevel(private val context: Context): IGetBatteryLevel {
     override fun getBatteryLevel(): Float {
         val batteryManager = context.getSystemService(Context.BATTERY_SERVICE) as BatteryManager
         val batteryLevel = batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY)
         return batteryLevel.toFloat()
     }
 }