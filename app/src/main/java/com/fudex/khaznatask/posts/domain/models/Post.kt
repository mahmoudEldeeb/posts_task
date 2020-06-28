package com.fudex.khaznatask.posts.domain.models
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "post")
data class Post (
	@PrimaryKey
	@SerializedName("id") val id : Int,
	@SerializedName("userId") val userId : Int,
	@SerializedName("title") val title : String,
	@SerializedName("body") val body : String
){

}