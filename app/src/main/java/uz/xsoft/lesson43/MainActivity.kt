package uz.xsoft.lesson43

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.lifecycle.lifecycleScope
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.xsoft.lesson43.group.GroupScreen
import uz.xsoft.lesson43.navigator.NavigationHandler
import uz.xsoft.lesson43.screens.main.MainScreen
import uz.xsoft.lesson43.ui.theme.Lesson43Theme
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigationHandler: NavigationHandler

    @OptIn(ExperimentalAnimationApi::class)
    @SuppressLint("FlowOperatorInvokedInComposition", "CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lesson43Theme {
                Navigator(screen = GroupScreen()) { navigator ->
                    navigationHandler.navigationStack
                        .onEach { it.invoke(navigator) }
                        .launchIn(lifecycleScope)
                    SlideTransition(navigator)
                }
            }
        }
    }
}