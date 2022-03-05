package com.sparklead.tictac

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        image1.translationY = -1000f
        image2.translationY = 1000f

        image1.animate().translationY(0f).duration =1000
        image2.animate().translationY(0f).duration =1000

        Handler(Looper.getMainLooper()).postDelayed({

            val intent = Intent(this ,StartActivity::class.java)
            startActivity(intent)

        },2000)




    }
}