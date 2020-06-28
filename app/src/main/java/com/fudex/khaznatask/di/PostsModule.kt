package com.fudex.khaznatask.di

import com.fudex.khaznatask.posts.data.repositry_implemetation.PostRepositryImpl
import com.fudex.khaznatask.posts.domain.repositry.PostsRepositry
import com.fudex.khaznatask.posts.data.local.PostDao
import com.fudex.khaznatask.posts.data.remote.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent


@InstallIn(ActivityRetainedComponent::class)
@Module
object PostsModule {
    @Provides
    fun providePostsRepositry(apiService: ApiService, postDao: PostDao):PostsRepositry
    {
        return PostRepositryImpl(apiService, postDao)
    }
}