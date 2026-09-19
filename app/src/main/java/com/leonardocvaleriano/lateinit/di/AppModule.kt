package com.leonardocvaleriano.lateinit.di

import com.leonardocvaleriano.lateinit.Planet
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePlanetObject(): Planet {
        return Planet()
    }
}
