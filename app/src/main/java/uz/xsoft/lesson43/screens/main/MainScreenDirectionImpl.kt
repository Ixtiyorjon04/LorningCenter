package uz.xsoft.lesson43.screens.main

import uz.xsoft.lesson43.SecondScreen
import uz.xsoft.lesson43.navigator.AppNavigator
import javax.inject.Inject

class MainScreenDirectionImpl @Inject constructor(
    private val appNavigator: AppNavigator
) : MainScreenDirection {
    override suspend fun navigateToSecond(name: String) {
        appNavigator.navigateTo(SecondScreen(name))
    }
}