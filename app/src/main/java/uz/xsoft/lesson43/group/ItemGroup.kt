package uz.xsoft.lesson43.group

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.xsoft.lesson43.R
import uz.xsoft.lesson43.ui.theme.Lesson43Theme

@Composable

fun ItemGroup(
    group: GroupData
) {






    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = group.name)

    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(56.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
      Image(painter = painterResource(id = R.drawable.img_apple), contentDescription ="Empty" )
    }
}

