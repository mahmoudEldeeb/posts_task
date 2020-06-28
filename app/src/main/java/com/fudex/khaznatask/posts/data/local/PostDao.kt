package com.fudex.khaznatask.posts.data.local

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.fudex.khaznatask.posts.domain.models.Post


@Dao
interface  PostDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll( posts: List<Post>)


    @Query("SELECT * FROM post")
    fun getAllPosts(): DataSource.Factory<Int, Post>

}