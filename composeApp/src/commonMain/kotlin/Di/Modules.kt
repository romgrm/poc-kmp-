package Di

import Features.Battery.ViewModels.BatteryViewModel
import IGetBatteryLevel
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val commonModules = module {
    viewModelOf(::BatteryViewModel)
}