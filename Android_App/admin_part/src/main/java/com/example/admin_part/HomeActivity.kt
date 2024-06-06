package com.example.admin_part

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        findViewById<Button>(R.id.rentnow).setOnClickListener {
            val intent = Intent(this@HomeActivity, userActivity::class.java)
            startActivity(intent)
            finish()
        }

        findViewById<ImageView>(R.id.imageView2).setOnClickListener {
            val intent = Intent(this@HomeActivity, LocationActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}

