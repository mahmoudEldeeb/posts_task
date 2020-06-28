package com.fudex.khaznatask.posts.data.repositry_implemetation

import android.util.Log
import androidx.paging.DataSource
import com.fudex.khaznatask.posts.domain.repositry.PostsRepositry
import com.fudex.khaznatask.posts.data.local.PostDao
import com.fudex.khaznatask.posts.data.remote.ApiService
import com.fudex.khaznatask.posts.domain.models.Post
import io.reactivex.Single

class PostRepositryImpl constructor(val apiService: ApiService, val postDao: PostDao):PostsRepositry {


    override fun getRemotePosts(): Single<List<Post>> = apiService.getPosts()

    override fun getLocalPosts(): DataSource.Factory<Int, Post> =postDao.getAllPosts()

    override fun insertIntoLocal(list: List<Post>?) {
        list?.let { postDao?.insertAll(it) }
    }
}