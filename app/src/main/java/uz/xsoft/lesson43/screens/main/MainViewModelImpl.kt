package uz.xsoft.lesson43.screens.main

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class MainViewModelImpl @Inject constructor(
    private val direction: MainScreenDirection
) : MainViewModel, ViewModel() {
    override val container: Container<UiState, Nothing> = container(UiState())

    override fun onEventDispatcher(intent: Intent) = intent {
        when (intent) {
            is Intent.Item1 -> reduce { state.copy(item1 = !state.item1) }
            is Intent.Item2 -> reduce { state.copy(item2 = !state.item2) }
            is Intent.Item3 -> reduce { state.copy(item3 = !state.item3) }
            is Intent.OpenSecond -> direction.navigateToSecond(intent.name)
        }
    }

}