package com.tugasuas.tugasuas.detail_data

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ahmad.tugasuas.R
import com.ahmad.tugasuas.databinding.ActivityDetailDataBinding
import com.tugasuas.tugasuas.database.Makanan
import com.tugasuas.tugasuas.home.HomeFragment

class detail_data : AppCompatActivity() {
    private lateinit var binding: ActivityDetailDataBinding
    // untuk menonaktifkan peringatan lint (lint warning)
    // yang diberikan oleh alat analisis statis lint
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailDataBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // value makanan yang mengambil data hasil intent homeFragment atau katalogFragment
        val makanan = intent.getSerializableExtra("Makanan") as? Makanan
        if (makanan != null) { // jika value makanan tidak kosong maka kode akan di jalankan
            binding.detailGambar.setImageResource(makanan.gambar) // untuk menampilkan gambar
            binding.deskripsiNama.text = makanan.judul  // untuk menampilkan judul
            binding.deskripsiJenis.text = makanan.jenis.toString() // untuk menampilkan jenis
            binding.deskripsiWaktu.text = makanan.waktu  // untuk menampilkan waktu
            binding.deskripsiAsal.text = makanan.asal  // untuk menampilkan asal
            binding.deskripsiBahan.text = makanan.bahan.joinToString("\n") {
                // menampilkan data bahan secara urut
                    bahan ->
                "${makanan.bahan.indexOf(bahan) + 1}. $bahan"
            }
            binding.deskripsiLangkah.text = makanan.langkah.joinToString("\n") {
                // menampilkan data bahan secara urut
                    langkah ->
                "${makanan.langkah.indexOf(langkah) + 1}. $langkah"
            }
            // saat tombol di klik maka akan kembali ke page sebelumnya
            binding.detailkembali.setOnClickListener {
                onBackPressed()
            }
        }
    }
}
