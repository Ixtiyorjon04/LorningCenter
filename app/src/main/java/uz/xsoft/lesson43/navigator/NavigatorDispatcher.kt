package uz.xsoft.lesson43.navigator

import kotlinx.coroutines.flow.MutableSharedFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NavigatorDispatcher @Inject constructor() : AppNavigator, NavigationHandler {
    override val navigationStack = MutableSharedFlow<NavigationArgs>()

    private suspend fun navigate(arg: NavigationArgs) {
        navigationStack.emit(arg)
    }

    override suspend fun back() = navigate { pop() }
    override suspend fun backAll() = navigate { popAll() }
    override suspend fun backToRoot() = navigate { popUntilRoot() }
    override suspend fun navigateTo(screen: AppScreen) = navigate { push(screen) }
}