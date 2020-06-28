package com.fudex.khaznatask.posts.presenter.views.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.fudex.khaznatask.R
import com.fudex.khaznatask.posts.domain.models.Post
import kotlinx.android.synthetic.main.item_post.view.*


class PostAdapter() : PagedListAdapter<Post, PostAdapter.PostViewHolder>(PostDiffCallback()) {

    var onItemClick: ((post: Post) -> Unit)? =null
    override fun onBindViewHolder(holderPost: PostViewHolder, position: Int) {
        var post = getItem(position)
        post?.let {
            holderPost.bind(it)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(
            LayoutInflater.from(parent.context).inflate(
            R.layout.item_post,
            parent, false))

    }


    inner class PostViewHolder (val view: View) : RecyclerView.ViewHolder(view), View.OnClickListener  {

        init {
            view.setOnClickListener(this)
        }
        fun bind(post: Post) {
            view.title.text = post.title
            view.body.text=post.body
        }

        override fun onClick(v: View?) {
            getItem(adapterPosition)?.let { onItemClick?.invoke(it) }
        }

    }
}