package uz.xsoft.lesson43.group

import uz.xsoft.lesson43.utils.AppViewModel

interface GroupViewModel : AppViewModel<Intent, UiState, Nothing>

sealed interface UiState {
    object Loading : UiState
    class Success(val groups: List<GroupData>) : UiState
    object Empty : UiState
    class Error(val message: String) : UiState
}

sealed interface Intent {
    object Back : Intent
    class Add(val name: String) : Intent
    class Edit(val name: String) : Intent
    class Select(val name: String) : Intent
}