package uz.xsoft.lesson43.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import uz.xsoft.lesson43.screens.main.MainScreenDirection
import uz.xsoft.lesson43.screens.main.MainScreenDirectionImpl

@Module
@InstallIn(ViewModelComponent::class)
interface DirectionModule {
    @Binds
    fun bindMainScreenDirection(impl: MainScreenDirectionImpl): MainScreenDirection
}