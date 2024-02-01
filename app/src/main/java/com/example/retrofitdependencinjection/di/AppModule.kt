package com.example.retrofitdependencinjection.di

import com.example.retrofitdependencinjection.core.utils.Constants
import com.example.retrofitdependencinjection.data.api.CharacterApi
import com.example.retrofitdependencinjection.data.repository.CharacterRepositoryImpl
import com.example.retrofitdependencinjection.domain.repository.CharacterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    @Singleton
    fun provideRetrofitInstacnce() = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(Constants.BASE_URL)
        .build()

    @Provides
    @Singleton
    fun provideCharacterApi(retrofit: Retrofit) : CharacterApi = retrofit.create(CharacterApi::class.java)


    @Provides
    @Singleton
    fun provideCharacterRepository(api: CharacterApi) : CharacterRepository{
        return CharacterRepositoryImpl(api)
    }


















}


