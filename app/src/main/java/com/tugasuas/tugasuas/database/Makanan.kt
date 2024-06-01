package com.tugasuas.tugasuas.database

import com.ahmad.tugasuas.R
import java.io.Serializable

// enum class
enum class JenisMakanan(val displayName: String) {
    MAKANAN_BERAT("Makanan Berat"),
    MAKANAN_RINGAN("Makanan Ringan"),
    KUE("Kue"),
    SAYUR("Sayur"),
    MINUMAN("Minuman");

    override fun toString(): String {
        return displayName
    }
}

data class Makanan(
    val gambar: Int,
    val judul: String,
    val jenis: JenisMakanan,
    val waktu: String,
    val alat: List<String>,
    val bahan: List<String>,
    val langkah: List<String>,
    val deskripsi: String
) : Serializable

fun DataMakanan(): MutableList<Makanan> {
    val data = mutableListOf<Makanan>()
    data.add(
        Makanan(
            R.drawable.rendang, "Rendang",
            JenisMakanan.MAKANAN_BERAT,
            "24.00",
            listOf("Pisau", "Panci"),
            listOf("Daging sapi", "Bumbu rendang"),
            listOf("Potong daging", "Masak bumbu"),
            "Rendang adalah makanan khas Padang."
        )
    )
    data.add(
        Makanan(
            R.drawable.rendang,
            "Air Putih",
            JenisMakanan.MAKANAN_BERAT,
            "00.00",
            listOf("Pisau", "Panci"),
            listOf("Daging sapi", "Bumbu rendang"),
            listOf("Potong daging", "Masak bumbu"),
            "Rendang adalah makanan khas Padang."
        )
    )
    data.add(
        Makanan(
            R.drawable.rendang,
            "Kue", JenisMakanan.MINUMAN,
            "15.00",
            listOf("Pisau", "Panci"),
            listOf("Daging sapi", "Bumbu rendang"),
            listOf("Potong daging", "Masak bumbu"),
            "Rendang adalah makanan khas Padang."
        )
    )
    data.add(
        Makanan(
            R.drawable.rendang,
            "Kue", JenisMakanan.KUE,
            "15.00",
            listOf("Pisau", "Panci"),
            listOf("Daging sapi", "Bumbu rendang"),
            listOf("Potong daging", "Masak bumbu"),
            "Rendang adalah makanan khas Padang."
        )
    )
    data.add(
        Makanan(
            R.drawable.rendang,
            "Air Putih",
            JenisMakanan.SAYUR,
            "00.00",
            listOf("Pisau", "Panci"),
            listOf("Daging sapi", "Bumbu rendang"),
            listOf("Potong daging", "Masak bumbu"),
            "Rendang adalah makanan khas Padang."
        )
    )
    // Tambahkan data makanan lainnya di sini
    return data
}


