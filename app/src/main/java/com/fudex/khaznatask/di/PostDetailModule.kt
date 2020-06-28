package com.fudex.khaznatask.di

import com.fudex.khaznatask.posts.data.repositry_implemetation.PostRepositryImpl
import com.fudex.khaznatask.posts.domain.repositry.PostsRepositry
import com.fudex.khaznatask.posts.data.local.PostDao
import com.fudex.khaznatask.posts.data.remote.ApiService
import com.fudex.khaznatask.posts.data.repositry_implemetation.PostDetailsRepositryImpl
import com.fudex.khaznatask.posts.domain.repositry.PostsDetailsRepositry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent


@InstallIn(ActivityRetainedComponent::class)
@Module
object PostDetailModule {
    @Provides
    fun providePostdetailRepositry(apiService: ApiService):PostsDetailsRepositry
    {
        return PostDetailsRepositryImpl(apiService)
    }
}