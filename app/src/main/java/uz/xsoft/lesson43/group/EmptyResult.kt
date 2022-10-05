package uz.xsoft.lesson43.group

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import uz.xsoft.lesson43.R

@Composable
fun EmptyResult() {
    val group:GroupData
    Box() {
        Text(text = "Empty")
       Image(painter = painterResource(id = R.drawable.img_apple ), contentDescription ="Empty" )
    }
}