package com.tugasuas.tugasuas.database

import com.ahmad.tugasuas.R

data class Makanan(
    val gambar: Int,
    val judul:String,
    val jenis:String,
    val waktu:String,
    val alat:String,
    val bahan:String,
    val langkah:String,
    val deskripsi:String,
)


fun DataMakanan():MutableList<Makanan>{
    val data = mutableListOf<Makanan>()
    data.add(Makanan(R.drawable.rendang, "Makanan", "Tidak tau", "12.00", "-", "-", "-", "-"))
    data.add(Makanan(R.drawable.rendang, "Rendang", "Makanan Berat", "24.00", "-", "-", "-", "-"))
    data.add(Makanan(R.drawable.rendang, "Rendang", "Makanan Berat", "24.00", "-", "-", "-", "-"))
    data.add(Makanan(R.drawable.rendang, "Rendang", "Makanan Berat", "24.00", "-", "-", "-", "-"))
    data.add(Makanan(R.drawable.rendang, "Rendang", "Makanan Berat", "24.00", "-", "-", "-", "-"))
    return data
}