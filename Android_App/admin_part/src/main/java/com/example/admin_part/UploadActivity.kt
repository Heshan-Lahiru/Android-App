package com.example.admin_part

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.admin_part.databinding.ActivityMainBinding
import com.example.admin_part.databinding.ActivityUploadBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.lang.ref.PhantomReference

class UploadActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUploadBinding

    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUploadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.saveButton.setOnClickListener{
            val ownerName = binding.uploadownername.text.toString()
            val vehicleBrand = binding.uploadvehiclebrand.text.toString()
            val vehicleRTO = binding.uploardvehicleRTO.text.toString()
            val vehicleNumber = binding.uploardvehiclenumber.text.toString()


            databaseReference = FirebaseDatabase.getInstance().getReference("Vehicle Information")
            val vehicleData = VehicleData(ownerName, vehicleBrand,vehicleRTO,vehicleNumber)
            databaseReference.child(vehicleBrand).setValue(vehicleData).addOnSuccessListener {
                binding.uploadownername.text.clear()
                binding.uploadvehiclebrand.text.clear()
                binding.uploardvehicleRTO.text.clear()
                binding.uploardvehiclenumber.text.clear()

                Toast.makeText(this,"Saved", Toast.LENGTH_SHORT ).show()
           val intent =Intent(this@UploadActivity,MainActivity::class.java)
          startActivity(intent)
                finish()
            }
                .addOnFailureListener{
                    Toast.makeText(this,"Failed", Toast.LENGTH_SHORT).show()
                }
        }

    }
}