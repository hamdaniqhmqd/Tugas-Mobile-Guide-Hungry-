package com.tugasuas.tugasuas.database

import com.ahmad.tugasuas.R
import java.io.Serializable

// enum class untuk pilihan jenis makanan
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
    val bahan: List<String>,
    val langkah: List<String>
) : Serializable

fun DataMakanan(): MutableList<Makanan> {
    val data = mutableListOf<Makanan>()
    // per data
    data.add(
        Makanan(
            R.drawable.rendang, // masukan nama gambar
            "Rendang", // nama makanan
            JenisMakanan.MAKANAN_BERAT, // jenis makanan
            "24.00", // waktu memasak makanan
            listOf("Daging sapi", "Bumbu rendang"), // bahan
            listOf("Potong daging", "Masak bumbu"), // langkah - langkah
        )
    )
    // per data
    data.add(
        Makanan(
            R.drawable.rendang, // masukan nama gambar
            "Rendang", // nama makanan
            JenisMakanan.MAKANAN_RINGAN, // jenis makanan
            "24.00", // waktu memasak makanan
            listOf("Daging sapi", "Bumbu rendang"), // bahan
            listOf("Potong daging", "Masak bumbu"), // langkah - langkah
        )
    )
    // per data
    data.add(
        Makanan(
            R.drawable.rendang, // masukan nama gambar
            "Rendang", // nama makanan
            JenisMakanan.MINUMAN, // jenis makanan
            "24.00", // waktu memasak makanan
            listOf("Daging sapi", "Bumbu rendang"), // bahan
            listOf("Potong daging", "Masak bumbu"), // langkah - langkah
        )
    )
    // per data
    data.add(
        Makanan(
            R.drawable.rendang, // masukan nama gambar
            "Rendang", // nama makanan
            JenisMakanan.SAYUR, // jenis makanan
            "24.00", // waktu memasak makanan
            listOf("Daging sapi", "Bumbu rendang"), // bahan
            listOf("Potong daging", "Masak bumbu"), // langkah - langkah
        )
    )
    // per data
    data.add(
        Makanan(
            R.drawable.rendang, // masukan nama gambar
            "Rendang", // nama makanan
            JenisMakanan.KUE, // jenis makanan
            "24.00", // waktu memasak makanan
            listOf("Daging sapi", "Bumbu rendang"), // bahan
            listOf("Potong daging", "Masak bumbu"), // langkah - langkah
        )
    )
    // Tambahkan data makanan lainnya di sini
    return data
}


