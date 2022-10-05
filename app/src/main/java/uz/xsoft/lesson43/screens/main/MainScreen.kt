package uz.xsoft.lesson43.screens.main

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import org.orbitmvi.orbit.compose.collectAsState
import uz.xsoft.lesson43.ui.theme.Lesson43Theme

class MainScreen : AndroidScreen() {
    @Composable
    override fun Content() {
        val viewModel: MainViewModel = getViewModel<MainViewModelImpl>()
        val uiState = viewModel.collectAsState().value
//        MainScreenContent(uiState, viewModel::onEventDispatcher)
    }
}

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//private fun MainScreenContent(
//    uiState: UiState,
//    eventDispatcher: (Intent) -> Unit
//) {
//    Surface(modifier = Modifier.fillMaxSize()) {
//        Column {
//            Text(text = "Screen 1")
//            var text by remember { mutableStateOf("") }
//            TextField(value = text, onValueChange = { text = it })
//            Button(onClick = { eventDispatcher(Intent.OpenSecond(text)) }) {
//                Text(text = "Go info")
//            }
//
//            Spacer(modifier = Modifier.height(20.dp))
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(8.dp)
//                    .background(
//                        if (uiState.item1) Color.Yellow else Color.White,
//                        RoundedCornerShape(12.dp)
//                    )
//                    .clickable { eventDispatcher(Intent.Item1) }
//                    .padding(16.dp)
//            ) {
//                Text(text = "Item 1")
//            }
//
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(16.dp)
//            ) {
//                Text(text = "Item 2")
//            }
//
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(16.dp)
//            ) {
//                Text(text = "Item 3")
//            }
//
//        }
//    }
//}
//
//@SuppressLint("UnrememberedMutableState")
//@Composable
//@Preview
//private fun MainScreenPreview() {
//    Lesson43Theme {
//        MainScreenContent(UiState(), {})
//    }
//}
@Composable
fun GroupItem(group: GroupFullData) {
    Box(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier) {
                Column() {
                    TitleText(modifier = Modifier, text = "Group Name")
                    TitleContentText(modifier = Modifier, text = group.name)

                }
                Column() {
                    TitleText(modifier = Modifier, text = "Students Count")
                    TitleContentText(modifier = Modifier, text = group.count.toString())
                }
            }
        }
    }
}

@Composable
fun TitleText(text: String, modifier: Modifier) {
    Text(
        text = text,
        modifier = modifier,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        color = Color.Gray
    )
}

@Composable
fun TitleContentText(text: String, modifier: Modifier) {
    Text(
        text = text,
        modifier = modifier,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        color = Color.Black
    )
}


@Composable
fun GroupActionButton(
    icon: Int,
    onClick: () -> Unit,
    modifier: Modifier
) {
    IconButton(onClick = onClick, modifier = modifier) {
        Icon(painter = painterResource(id = icon), contentDescription = "icon bor")
    }
}


@Composable
@Preview
fun groupItemPreview() {
    Lesson43Theme {
        GroupItem(group = GroupFullData(1, "Android", 12))
    }
}