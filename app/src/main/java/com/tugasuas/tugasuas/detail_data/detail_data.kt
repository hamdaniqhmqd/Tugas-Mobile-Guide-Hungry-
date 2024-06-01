package com.tugasuas.tugasuas.detail_data

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ahmad.tugasuas.R
import com.ahmad.tugasuas.databinding.ActivityDetailDataBinding
import com.tugasuas.tugasuas.database.Makanan

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
            binding.deskripsiAlat.text = "Alat:\n" + makanan.alat.joinToString("\n") {
                alat -> "${makanan.alat.indexOf(alat) + 1}. $alat"
            }
            binding.deskripsiBahan.text = "Bahan:\n" + makanan.bahan.joinToString("\n") {
                bahan -> "${makanan.bahan.indexOf(bahan) + 1}. $bahan"
            }
            binding.deskripsiLangkah.text = "Langkah:\n" + makanan.langkah.joinToString("\n") {
                langkah -> "${makanan.langkah.indexOf(langkah) + 1}. $langkah"
            }
            binding.deskripsiDeskripsi.text = makanan.deskripsi
        }

        binding.detailKembali.setOnClickListener {

        }
    }
}