package com.tugasuas.tugasuas.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.ahmad.tugasuas.databinding.FragmentHomeBinding
import com.tugasuas.tugasuas.database.DataMakanan
import com.tugasuas.tugasuas.detail_data.detail_data
import java.util.Locale

class HomeFragment : Fragment() {
    // Vvariabel untuk menyimpan binding yang dapat null
    private var _binding: FragmentHomeBinding? = null
    // Ggetter untuk binding yang tidak boleh bernilai null,
    // menggunakan _binding dengan not-null assertion
    private val binding get() = _binding!!
    // membuat variabel HomeAdapter untuk memanggil homeAdapter
    private lateinit var HomeAdapter: homeAdapter

    // untuk mengatur dan menampilkan tampilan ui dari home fragment
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    // ketika tampilan UI dari fragment dihancurkan
    override fun onDestroyView() {
        super.onDestroyView()
        // binding menjadi null untuk menghindari memory leaks
        _binding = null
    }

    // metode yang dipanggil setelah tampilan UI telah dibuat
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // ketika SearchView di klik maka akan membuka pencarian
        binding.inputPencarian.setOnClickListener {
            binding.inputPencarian.isIconified = false
        }
        // listener untuk perubahan teks pada SearchView
        binding.inputPencarian.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            // fun akan berjalan ketika teks pencarian disubmit dan mengembalikan nilai true
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }
            // ketika teks pencarian berubah kode didalamnya akan di eksekusi
            override fun onQueryTextChange(kataKunci: String?): Boolean {
                // Memanggil metode untuk memfilter data berdasarkan newText yang dimasukkan
                filterList(kataKunci.toString())
                return true
            }
        })
        // untuk mengambil data makanan() dari file Makanan.kt
        val makanan = DataMakanan()
        // untuk mengidentifikasi home adapter dengan data makanan
        HomeAdapter = homeAdapter(makanan)

        // untuk mengatur layout manager dan adapter untuk RecyclerView
        binding.ViewDataMakanan.layoutManager = GridLayoutManager(context, 2)
        binding.ViewDataMakanan.adapter = HomeAdapter

        // saat salah satu item pada RecyclerView
        // di klik maka akan mengeksekusi kode didalamnya
        HomeAdapter.onItemClick = {
            val intent = Intent(context, detail_data::class.java)
            intent.putExtra("Makanan", it)
            startActivity(intent)
        }
    }

    // untuk memfilter data berdasarkan query pencarian
    private fun filterList(query: String) {
        // mengambil data makanan dari file makanan.kt
        val data = DataMakanan()
        // mengidentifikasi data sesuai query
        val filteredList = data.filter {
            it.judul.lowercase(Locale.ROOT).contains(query.lowercase(Locale.ROOT)) ||
            it.jenis.name.lowercase(Locale.ROOT).contains(query.lowercase(Locale.ROOT))
        }
        // jika data hasil filter kosong atau data yang di cari tidak ada,
        // tampilkan pesan, jika tidak kosong tampilkan data sesuai pencarian
        if (filteredList.isEmpty()) {
            Toast.makeText(context, "Data tidak ditemukan", Toast.LENGTH_SHORT).show()
        } else {
            (binding.ViewDataMakanan.adapter as? homeAdapter)?.setFilteredList(filteredList)
        }
    }
}