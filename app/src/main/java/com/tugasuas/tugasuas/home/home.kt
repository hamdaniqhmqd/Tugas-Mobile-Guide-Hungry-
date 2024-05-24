package com.tugasuas.tugasuas.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ahmad.tugasuas.R
import com.ahmad.tugasuas.databinding.ActivityHomeBinding
import com.tugasuas.tugasuas.database.Makanan

class home : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root )

        binding.rvMakanan.layoutManager = LinearLayoutManager(this)
        val makanan = mutableListOf<Makanan>()
        makanan.add(Makanan(R.drawable.rendang, "Makanan", "Tidak tau", "12.00", "-", "-", "-", "-"))
        makanan.add(Makanan(R.drawable.rendang, "Rendang", "Makanan Berat", "24.00", "-", "-", "-", "-"))
        binding.rvMakanan.adapter = homeAdapter(makanan)
    }
}