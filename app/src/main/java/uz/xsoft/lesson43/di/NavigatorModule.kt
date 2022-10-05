package uz.xsoft.lesson43.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import uz.xsoft.lesson43.navigator.AppNavigator
import uz.xsoft.lesson43.navigator.NavigationHandler
import uz.xsoft.lesson43.navigator.NavigatorDispatcher

@Module
@InstallIn(SingletonComponent::class)
interface NavigatorModule {
    @Binds
    fun appNavigator(dispatcher: NavigatorDispatcher): AppNavigator

    @Binds
    fun navigationHandler(dispatcher: NavigatorDispatcher): NavigationHandler
}