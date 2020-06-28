package com.fudex.khaznatask.posts.domain.usecase

import androidx.paging.DataSource
import com.fudex.khaznatask.posts.domain.models.Post
import com.fudex.khaznatask.posts.domain.repositry.PostsDetailsRepositry
import com.fudex.khaznatask.posts.domain.repositry.PostsRepositry
import io.reactivex.Single
import javax.inject.Inject

class PostDetailsUseCase @Inject constructor(val postsDetailsRepositry: PostsDetailsRepositry){

    fun getPostDetails(id:Int): Single<Post> = postsDetailsRepositry.getPostDetails(id)
}
