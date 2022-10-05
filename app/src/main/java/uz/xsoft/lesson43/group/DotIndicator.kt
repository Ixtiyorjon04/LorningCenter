package uz.xsoft.lesson43.group

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DotIndicator(
    size: Int,
    selectedIndex: Int,
    modifier: Modifier = Modifier.height(20.dp),
    unselectedColor: Color = Color.Cyan,
    selectedColor: Color = Color.Red
) {
    Row(modifier = modifier) {
        for (i in 0 until size) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .aspectRatio(1f)
                    .background(if (selectedIndex == i) selectedColor else unselectedColor, shape = CircleShape)
            )
        }
    }
}