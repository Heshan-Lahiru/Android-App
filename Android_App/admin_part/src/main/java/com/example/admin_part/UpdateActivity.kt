package com.example.admin_part

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.admin_part.databinding.ActivityUpdateBinding
import com.example.admin_part.databinding.ActivityUploadBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class UpdateActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUpdateBinding
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.updateButton.setOnClickListener {
            val referenceVehicleNumber = binding.referenceVehicleNumber.text.toString()
            val updateOwnerName = binding.updateOwnerName.text.toString()
            val updateVehicleBrand = binding.updateVehicleBrand.text.toString()
            val updateVehicleRTO = binding.updateVehicleRTO.text.toString()
            updateData(referenceVehicleNumber,updateOwnerName,updateVehicleBrand,updateVehicleRTO)
        }
    }
    private fun updateData(vehicleNumber: String, ownerName: String, vehicleBrand: String, vehicleRTO: String) {
        databaseReference = FirebaseDatabase.getInstance().getReference("Vehicle Information")
        val vehicleData = mapOf<String,String>(
            "ownerName" to ownerName,
            "vehicleBrand" to vehicleBrand,
            "vehicleRTO" to vehicleRTO
        )
        databaseReference.child(vehicleBrand).updateChildren(vehicleData).addOnSuccessListener {
            binding.referenceVehicleNumber.text.clear()
            binding.updateOwnerName.text.clear()
            binding.updateVehicleBrand.text.clear()
            binding.updateVehicleRTO.text.clear()
            Toast.makeText(this,"Successfully Updated",Toast.LENGTH_SHORT).show()
        }.addOnFailureListener{
            Toast.makeText(this,"Failed to Update",Toast.LENGTH_SHORT).show()
        }}
}