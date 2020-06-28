package com.fudex.khaznatask.splash_screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.fudex.khaznatask.R
import com.fudex.khaznatask.posts.presenter.views.activites.MainActivity
import com.fudex.khaznatask.posts.presenter.views.activites.PostDetailsActivity
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
       // splash= (ImageView) findViewById(R.id.splash);
        var fade: Animation? = AnimationUtils.loadAnimation(this, R.anim.fade_in_enter);
        splash.startAnimation(fade)
        val intent= Intent(this, MainActivity::class.java)

        fade?.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(animation: Animation?) {
            }
            override fun onAnimationEnd(animation: Animation?) {
                startActivity(intent)
            }

            override fun onAnimationStart(animation: Animation?) {

            }

        } )

    }
}