package com.fudex.khaznatask.posts.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fudex.khaznatask.posts.domain.models.Post


@Database(entities = [Post::class], version = 1, exportSchema = false)
 abstract class PostsDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao
}