package com.fudex.khaznatask.posts.presenter.view_model

import android.util.Log
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.fudex.khaznatask.posts.domain.models.Post
import com.fudex.khaznatask.posts.domain.usecase.PostDetailsUseCase

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


class DetailPostViewModel @ViewModelInject constructor(private val postDetailsUseCase: PostDetailsUseCase,
                                     @Assisted private val savedStateHandle: SavedStateHandle) : ViewModel() {

   lateinit var  disposable:Disposable
    public var postDeatils= MutableLiveData<Post>()

    fun getDetails(id:Int){
      disposable=postDetailsUseCase.getPostDetails(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {post: Post?, t2: Throwable? ->
                run {
                    postDeatils.value = post
                }
            }
    }


    override fun onCleared() {
        disposable.dispose()
        super.onCleared()
    }
}