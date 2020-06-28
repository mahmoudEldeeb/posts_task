package com.fudex.khaznatask.posts.presenter.views.adapter

import androidx.recyclerview.widget.DiffUtil
import com.fudex.khaznatask.posts.domain.models.Post

class PostDiffCallback : DiffUtil.ItemCallback<Post>() {

    override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem.id == newItem.id
    }


    override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem == newItem
    }
}
