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
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val makanan = intent.getSerializableExtra("Makanan") as? Makanan
        if (makanan != null) {
            binding.detailGambar.setImageResource(makanan.gambar)
            binding.deskripsiNama.text = makanan.judul
            binding.deskripsiJenis.text = makanan.jenis.toString()
            binding.deskripsiWaktu.text = makanan.waktu
            binding.deskripsiBahan.text = makanan.bahan.joinToString("\n") {
                bahan -> "${makanan.bahan.indexOf(bahan) + 1}. $bahan"
            }
            binding.deskripsiLangkah.text = makanan.langkah.joinToString("\n") {
                langkah -> "${makanan.langkah.indexOf(langkah) + 1}. $langkah"
            }
            binding.detailkembali.setOnClickListener{
                onBackPressed()
            }
        }
    }
}