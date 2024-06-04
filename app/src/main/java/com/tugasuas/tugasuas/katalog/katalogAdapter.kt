package com.tugasuas.tugasuas.katalog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.tugasuas.tugasuas.database.Makanan
import androidx.recyclerview.widget.RecyclerView
import com.ahmad.tugasuas.R

class katalogAdapter(private var dataMakanan: List<Makanan>)
    : RecyclerView.Adapter<katalogAdapter.MakananViewHolder>(){

    // var onItemClick yang menerima parameter Makanan
    // dan tidak mengembalikan nilai apapun (unit)
    // fungsi ini tidak menjalankan perintah, karena merupakan fungsi kosong
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
        holder.tvJenis.visibility = View.GONE
        holder.tvWaktu.text = makanan.waktu
        holder.tvAsal.text = makanan.asal

        // jika item dari recyclerView di click makan
        // akan mengeksekusi kode didalamnya
        holder.itemView.setOnClickListener {
            // memanggil fungsi onItemClick dengan argumen makanan
            onItemClick.invoke(makanan)
        }
    }
}