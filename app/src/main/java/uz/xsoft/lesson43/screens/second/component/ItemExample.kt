package uz.xsoft.lesson43.screens.second.component

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ItemExample(
    name:String
) {
    Column {
        Text(text = "User name:")
        Text(text = name)
    }
}