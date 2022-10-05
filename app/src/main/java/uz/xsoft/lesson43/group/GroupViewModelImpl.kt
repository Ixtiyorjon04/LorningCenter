package uz.xsoft.lesson43.group

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import uz.xsoft.lesson43.R
import javax.inject.Inject

@HiltViewModel
class GroupViewModelImpl @Inject constructor(

): GroupViewModel, ViewModel() {
    override val container: Container<UiState, Nothing> = container(UiState.Loading)

    init {
        viewModelScope.launch {
            delay(2000)
            val ls = ArrayList<GroupData>()
            for (i in 1 .. 1000){
                ls.add(GroupData(i.toLong(), "Android !$i", R.drawable.img_apple))
            }
            intent { reduce { UiState.Success(ls) } }
        }
    }

    override fun onEventDispatcher(intent: Intent) {
        when (intent) {
            is Intent.Add -> {}
            is Intent.Edit -> {}
            is Intent.Back -> {}
            is Intent.Select -> {}
        }
    }

}