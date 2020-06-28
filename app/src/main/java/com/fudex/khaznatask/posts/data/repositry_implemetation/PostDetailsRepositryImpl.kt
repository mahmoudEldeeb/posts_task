package com.fudex.khaznatask.posts.data.repositry_implemetation

import android.util.Log
import androidx.paging.DataSource
import com.fudex.khaznatask.posts.domain.repositry.PostsRepositry
import com.fudex.khaznatask.posts.data.local.PostDao
import com.fudex.khaznatask.posts.data.remote.ApiService
import com.fudex.khaznatask.posts.domain.models.Post
import com.fudex.khaznatask.posts.domain.repositry.PostsDetailsRepositry
import io.reactivex.Single

class PostDetailsRepositryImpl constructor(val apiService: ApiService):PostsDetailsRepositry {

    override fun getPostDetails(id:Int): Single<Post> =apiService.getPostDetails(id)
}