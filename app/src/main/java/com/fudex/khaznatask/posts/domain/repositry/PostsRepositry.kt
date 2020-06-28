package com.fudex.khaznatask.posts.domain.repositry

import androidx.paging.DataSource
import com.fudex.khaznatask.posts.domain.models.Post
import io.reactivex.Single

interface PostsRepositry {
    fun getRemotePosts(): Single<List<Post>>
    fun getLocalPosts(): DataSource.Factory<Int, Post>
    fun insertIntoLocal(list: List<Post>?)
}


