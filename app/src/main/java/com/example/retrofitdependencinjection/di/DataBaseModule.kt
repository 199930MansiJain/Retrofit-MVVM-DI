package com.example.retrofitdependencinjection.di

import androidx.room.Room
import com.example.retrofitdependencinjection.data.room.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DataBaseModule {

    @Singleton
    @Provides
    fun providesRoomDataBase((@ApplicationContext appContext: Context) : AppDatabase{
        return Room.databaseBuilder(context = appContext,AppDatabase::class.java,name = "CharacterDatabase").build
    }
}