package com.example.admin_part

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.admin_part.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainupload.setOnClickListener{

            val intent = Intent(this@MainActivity,UploadActivity::class.java)
            startActivity(intent)
            finish()
        }
            binding.mainUpdate.setOnClickListener{
                val intent = Intent(this@MainActivity,UpdateActivity::class.java)
                startActivity(intent)
                finish()
}
        binding.mainDelete.setOnClickListener{
            val intent = Intent(this@MainActivity,DeleteActivity::class.java)
            startActivity(intent)
            finish()
        }
        findViewById<Button>(R.id.buttonlocation).setOnClickListener{
            val intent = Intent(this@MainActivity, LocationActivity::class.java)
            startActivity(intent)
            finish()
        }


    }
}