package com.sparklead.tictac

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_startactivity.*

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_startactivity)

        val intent = Intent(this ,GameActivity::class.java)

        image2_1.setOnClickListener {
            startActivity(intent)
        }
        image2_2.setOnClickListener {
            startActivity(intent)
        }
        background1.setOnClickListener {
            startActivity(intent)
        }

        start_text.setOnClickListener {
            startActivity(intent)
        }


    }
}