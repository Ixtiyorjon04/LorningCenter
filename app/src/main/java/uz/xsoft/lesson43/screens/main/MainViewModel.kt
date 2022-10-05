package uz.xsoft.lesson43.screens.main

import uz.xsoft.lesson43.utils.AppViewModel

interface MainViewModel : AppViewModel<Intent, UiState, Nothing>

sealed interface Intent {
    object Item1 : Intent
    object Item2 : Intent
    object Item3 : Intent
    class OpenSecond(val name: String) : Intent
}

data class UiState(
    val item1: Boolean = false,
    val item2: Boolean = false,
    val item3: Boolean = false,
)
