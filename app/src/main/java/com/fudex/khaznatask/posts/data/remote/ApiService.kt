package com.fudex.khaznatask.posts.data.remote

import com.fudex.khaznatask.posts.domain.models.Post
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("posts")
    fun getPosts():Single<List<Post>>


    @GET("posts/{id}")
    fun getPostDetails(@Path("id")id:Int):Single<Post>
}