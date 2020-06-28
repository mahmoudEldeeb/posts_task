package com.fudex.khaznatask.posts.presenter.view_model

import android.util.Log
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.fudex.khaznatask.posts.domain.models.Post
import com.fudex.khaznatask.posts.domain.usecase.PostsUseCase
import com.fudex.khaznatask.util.Constants
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


class MainPostViewModel @ViewModelInject
                        constructor(private val postsUseCase: PostsUseCase,
                                    @Assisted private val savedStateHandle: SavedStateHandle) : ViewModel() {

   lateinit var  disposable:Disposable
    private lateinit var postsLiveData: LiveData<PagedList<Post>>

    init {
        getlocal()
        getDataFromRemote()
    }

    fun getlocal(){
        val factory: DataSource.Factory<Int, Post> =postsUseCase.getdataFromLocal()
        val pagedListBuilder: LivePagedListBuilder<Int, Post> = LivePagedListBuilder<Int, Post>(factory,
            Constants.BAGE_SIZE)
        postsLiveData = pagedListBuilder.build()
    }
    fun getPostsLiveData() = postsLiveData

    fun getDataFromRemote(){
      disposable=postsUseCase.getDataFromRemote()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { t1: List<Post>?, t2: Throwable? ->
                run {
                    getlocal()
                }
            }
    }
        fun refresh(){
            getDataFromRemote()
        }

    override fun onCleared() {
        disposable.dispose()
        super.onCleared()
    }
}