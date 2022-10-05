package uz.xsoft.lesson43

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.androidx.AndroidScreen
import uz.xsoft.lesson43.screens.second.component.ItemExample
import uz.xsoft.lesson43.ui.theme.Lesson43Theme

class SecondScreen(
    val name: String
) : AndroidScreen() {
    @Composable
    override fun Content() {
        SecondScreenContent(name)
    }
}

@Composable
private fun SecondScreenContent(
    name: String
) {
    Surface(modifier = Modifier.fillMaxSize().padding()) {
        val ls = remember { listOf("Ali", "Vali") }
        LazyColumn {

            items(ls) { item ->
                if (item is String) {
                    ItemExample(item)
                } else {
                    Text(text = "")
                }
            }
        }
    }
}

@Composable
@Preview
fun SecondScreenPreview() {
    Lesson43Theme {
        SecondScreenContent("")
    }
}