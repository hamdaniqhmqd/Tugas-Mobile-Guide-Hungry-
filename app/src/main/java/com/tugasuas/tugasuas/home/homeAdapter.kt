package com.tugasuas.tugasuas.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.tugasuas.tugasuas.database.Makanan
import androidx.recyclerview.widget.RecyclerView
import com.ahmad.tugasuas.R

class homeAdapter(private var dataMakanan: List<Makanan>) :
    RecyclerView.Adapter<homeAdapter.MakananViewHolder>() {
    // sebuah lambda function yang digunakan sebagai callback untuk menangani event klik
    // pada item dalam daftar makanan. Lambda function ini menerima satu parameter bertipe Makanan
    // dan tidak mengembalikan nilai. Dengan menginisialisasi onItemClick dengan lambda kosong,
    // Anda menghindari perlu memeriksa null sebelum memanggilnya, sehingga membuat kode lebih bersih dan
    // lebih mudah di-maintain.
    var onItemClick: ((Makanan) -> Unit) = {}

    // untuk mengidentifikasi data apa saja yang akan di tampilkan di recyclerView
    class MakananViewHolder(val row: View) : RecyclerView.ViewHolder(row) {
        val ivMhs: ImageView = row.findViewById(R.id.ivGambar)
        val tvJudul: TextView = row.findViewById(R.id.tvJudul)
        val tvJenis: TextView = row.findViewById(R.id.tvJenis)
        val tvWaktu: TextView = row.findViewById(R.id.tvWaktu)
        val tvAsal: TextView = row.findViewById(R.id.tvAsal)
    }

    // untuk membuat ViewHolder baru yang berisi tampilan item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MakananViewHolder {
        val layout =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.data_makanan, parent, false)
        // Mengembalikan instance dari MakananViewHolder yang berisi view yang baru dibuat
        return MakananViewHolder(layout)
    }

    // untuk membatasi jumlah data yang akan di tampilkan
    override fun getItemCount(): Int {
        return dataMakanan.size
    }

    //  data yang akan di tampilkan
    override fun onBindViewHolder(holder: MakananViewHolder, position: Int) {
        val makanan = dataMakanan[position]
        holder.ivMhs.setImageResource(makanan.gambar)
        holder.tvJudul.text = makanan.judul
        holder.tvJenis.text = makanan.jenis.toString()
        holder.tvWaktu.visibility = View.GONE
        holder.tvAsal.text = makanan.asal

        // jika item dari recyclerView di click makan
        // akan mengeksekusi kode didalamnya
        holder.itemView.setOnClickListener {
            onItemClick.invoke(makanan)
        }
    }

    // untuk menonaktifkan peringatan lint (lint warning) tertentu di dalam kode Android
    // yang berkaitan dengan penggunaan metode notifyDataSetChanged() pada adapter.
    @SuppressLint("NotifyDataSetChanged")
    // untuk memperbarui data yang ditampilkan oleh adapter
    // dengan data yang sudah di filter
    fun setFilteredList(filterdata: List<Makanan>) {
        this.dataMakanan = filterdata
        notifyDataSetChanged() // fungsi untuk render ulang tampilan recyclerView
    }
}