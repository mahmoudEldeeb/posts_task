package com.fudex.khaznatask.posts.presenter.views.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.fudex.khaznatask.R
import com.fudex.khaznatask.posts.presenter.view_model.DetailPostViewModel
import com.fudex.khaznatask.posts.presenter.view_model.MainPostViewModel
import com.fudex.khaznatask.util.Constants
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_post_details.*
import kotlinx.android.synthetic.main.item_post.*
import kotlinx.android.synthetic.main.item_post.body

@AndroidEntryPoint
class PostDetailsActivity : AppCompatActivity() {
    private val detailsViewModel by viewModels<DetailPostViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_details)
        detailsViewModel.getDetails(intent.getIntExtra(Constants.POST_ID,0))

        detailsViewModel.postDeatils.observe(this, Observer {
            postTitle.text=it.title
            body.text=it.body
        })

    }
}