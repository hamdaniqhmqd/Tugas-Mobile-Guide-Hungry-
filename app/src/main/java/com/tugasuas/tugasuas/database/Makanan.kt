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

    // untuk menampilkan value berupa string dari enum class jenisMakanan
    override fun toString(): String {
        return displayName
    }
}

// data class makanan
data class Makanan(
    val gambar: Int,
    val judul: String,
    val jenis: JenisMakanan,
    val waktu: String,
    val bahan: List<String>,
    val langkah: List<String>
) : Serializable

// untuk merubah dan menambahkan isi dari data makanan
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
    // Tambahkan data makanan lainnya di sini
    return data // untuk mengembalikan atau mengeluarkan data
}


