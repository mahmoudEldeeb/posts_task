package com.fudex.khaznatask.posts.domain.repositry

import androidx.paging.DataSource
import com.fudex.khaznatask.posts.domain.models.Post
import io.reactivex.Single

interface PostsDetailsRepositry {
    fun getPostDetails( id:Int): Single<Post>
}