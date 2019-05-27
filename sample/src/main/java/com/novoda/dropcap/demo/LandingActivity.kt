package com.novoda.dropcap.demo

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.vectordrawable.graphics.drawable.Animatable2Compat
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat


class LandingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.novoda.drop_cap.R.layout.activity_landing)

        val dropCapIcon = findViewById<ImageView>(com.novoda.drop_cap.R.id.dropCapIcon)

        val dropCapAvd = AnimatedVectorDrawableCompat.create(this, com.novoda.drop_cap.R.drawable.avd_handwriting_drop_cap)!!
        dropCapIcon.setImageDrawable(dropCapAvd)
        val mainHandler = Handler(Looper.getMainLooper())
        dropCapAvd.registerAnimationCallback(object : Animatable2Compat.AnimationCallback() {
            override fun onAnimationEnd(drawable: Drawable?) {
                mainHandler.postDelayed(Runnable {
                    val intent = Intent(baseContext, DropCapActivity::class.java)
                    startActivity(intent)
                }, 1000)
            }
        })
        dropCapAvd.start()
    }
}
