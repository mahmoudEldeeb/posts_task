package com.fudex.khaznatask.posts.domain.usecase

import androidx.paging.DataSource
import com.fudex.khaznatask.posts.domain.models.Post
import com.fudex.khaznatask.posts.domain.repositry.PostsRepositry
import io.reactivex.Single
import javax.inject.Inject

class PostsUseCase @Inject constructor(val postsRepositry: PostsRepositry){

    fun getDataFromRemote(): Single<List<Post>> = postsRepositry
                                                .getRemotePosts()
                                                .doAfterSuccess {
                                                        t: List<Post>? ->postsRepositry.insertIntoLocal(t)
                                                }


    fun getdataFromLocal(): DataSource.Factory<Int, Post> = postsRepositry.getLocalPosts()


}
