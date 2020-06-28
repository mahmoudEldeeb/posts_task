package com.fudex.khaznatask.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.fudex.khaznatask.posts.data.local.PostDao
import com.fudex.khaznatask.posts.data.local.PostsDatabase
import com.fudex.khaznatask.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton





@InstallIn(ApplicationComponent::class)
@Module
object DatabaseModule {
    @Provides
    fun provideContext(application: Application): Context? {
        return application.applicationContext
    }
    @Provides
    fun provideDatabase(application: Application):PostsDatabase
    {
        return  Room.databaseBuilder(
            application.applicationContext,
            PostsDatabase::class.java,
            Constants.DATABASE_NAME
        ).build()
    }

    @Provides
    fun provideDao(postsDatabase: PostsDatabase): PostDao
    {
        return postsDatabase.postDao()
    }



}