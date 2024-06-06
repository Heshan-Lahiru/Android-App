package com.example.mobile_app

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mobile_app.databinding.ActivityMainBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.searchButton.setOnClickListener {
            val searchVehicleNumber: String = binding.searchvehiclebrand.text.toString()
            if (searchVehicleNumber.isNotEmpty()) {
                readData(searchVehicleNumber)
            } else {
                Toast.makeText(this, "Please Enter The Vehicle Number", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun readData(vehicleBrand: String) {
        databaseReference = FirebaseDatabase.getInstance().getReference("Vehicle Information")
        databaseReference.child(vehicleBrand).get().addOnSuccessListener { snapshot ->
            if (snapshot.exists()) {
                val ownerName = snapshot.child("ownerName").value.toString()
                val vehicleBrand = snapshot.child("vehicleBrand").value.toString()
                val vehicleRTO = snapshot.child("vehicleRTO").value.toString()

                Toast.makeText(this, "Results Found", Toast.LENGTH_SHORT).show()
                binding.searchvehiclebrand.text.clear()
                binding.readownerName.text = ownerName
                binding.readvehicleBrand.text = vehicleBrand
                binding.readvehicleRTO.text = vehicleRTO
            } else {
                Toast.makeText(this, "Vehicle Number Does Not Exist", Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener {
            Toast.makeText(this, "Something Went Wrong", Toast.LENGTH_SHORT).show()
        }
    }
}
