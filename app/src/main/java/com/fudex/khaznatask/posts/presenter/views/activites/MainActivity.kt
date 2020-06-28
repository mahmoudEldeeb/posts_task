package com.fudex.khaznatask.posts.presenter.views.activites

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.fudex.khaznatask.R
import com.fudex.khaznatask.posts.presenter.view_model.MainPostViewModel
import com.fudex.khaznatask.posts.presenter.views.adapter.PostAdapter
import com.fudex.khaznatask.util.Constants
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val mainPostViewModel by viewModels<MainPostViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter = PostAdapter()
        resPost.layoutManager=LinearLayoutManager(this)
        resPost.adapter = adapter
        mainPostViewModel.getPostsLiveData().observe(this, Observer {
                posts ->
            run {
                if (refresh.isRefreshing) refresh.isRefreshing = false
                adapter.submitList(posts)
            }
        })
        val intentDetailsActivity = Intent(this, PostDetailsActivity::class.java)
        adapter.onItemClick = { post ->
            run {
                intentDetailsActivity.putExtra(Constants.POST_ID, post.id)
                startActivity(intentDetailsActivity)
            }
        }
        refresh.setOnRefreshListener {
            mainPostViewModel.refresh()
        }
    }
}