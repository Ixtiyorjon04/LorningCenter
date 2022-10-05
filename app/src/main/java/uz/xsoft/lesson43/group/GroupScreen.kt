package uz.xsoft.lesson43.group

import android.view.LayoutInflater
import android.widget.ImageView
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import org.orbitmvi.orbit.compose.collectAsState

class GroupScreen : AndroidScreen() {
    @Composable
    override fun Content() {
        val viewModel: GroupViewModel = getViewModel<GroupViewModelImpl>()
        val uiState = viewModel.collectAsState().value
        GroupScreenContent(uiState, viewModel::onEventDispatcher)
    }
}

@Composable
private fun GroupScreenContent(
    uiState: UiState,
    eventDispatcher: (Intent) -> Unit
) {
    Surface(modifier = Modifier.fillMaxSize()) {
        when (uiState) {
            is UiState.Empty -> EmptyResult()
            is UiState.Success -> {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(uiState.groups) { item: GroupData -> ItemGroup(group = item ) }
                }

               /* AndroidView(
                    factory = {
                        val view  = ImageView(it)
                        view
                    },
                    modifier = Modifier.fillMaxSize()
                )*/
            }
            is UiState.Loading -> Progress()
            is UiState.Error -> Error(message = uiState.message) { eventDispatcher(Intent.Back) }
        }
    }
}