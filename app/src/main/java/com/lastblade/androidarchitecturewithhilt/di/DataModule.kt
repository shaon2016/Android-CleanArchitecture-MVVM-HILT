package com.lastblade.androidarchitecturewithhilt.di

import android.content.Context
import com.lastblade.androidarchitecturewithhilt.data.local.db.RoomHelper
import com.lastblade.androidarchitecturewithhilt.data.local.preference.PreferencesHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object DataModule {
    @Provides
    @Singleton
    fun provideRoomHelper(@ApplicationContext context: Context): RoomHelper {
        return RoomHelper(context)
    }


    @Provides
    @Singleton
    fun providePreference(@ApplicationContext context: Context): PreferencesHelper {
        return PreferencesHelper(context)
    }
}