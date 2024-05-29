package com.tugasuas.tugasuas.database

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Makanan(
    val gambar: Int,
    val judul: String,
    val jenis: String,
    val waktu: String,
    val alat: String,
    val bahan: String,
    val langkah: String,
    val deskripsi: String,
) : Parcelable
