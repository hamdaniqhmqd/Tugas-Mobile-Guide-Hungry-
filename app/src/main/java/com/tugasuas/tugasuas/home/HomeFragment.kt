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
    // variabel untuk menyimpan layout home yang dapat bernilai null, jika tidak digunakan
    private var _binding: FragmentHomeBinding? = null
    // Getter ini akan mengembalikan _binding dengan ketentuan
    // bahwa _binding tidak boleh bernilai null ketika getter dipanggil.
    private val binding get() = _binding!!
    // membuat variabel HomeAdapter yang memiliki tipe homeAdapter
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
        // binding menjadi null untuk menghindari kebocoran memory
        _binding = null
    }
    // metode yang dipanggil setelah tampilan UI telah dibuat
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // listener untuk mengidentifikasi perubahan teks dan pengiriman teks pencarian
        binding.inputPencarian.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            // fun akan berjalan ketika teks pencarian disubmit dan mengembalikan nilai true
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }
            // ketika teks pencarian berubah kode didalamnya akan di eksekusi
            override fun onQueryTextChange(kataKunci: String?): Boolean {
                // filterlist dengan parameter kataKunci dan tipe datanya dijadikan string
                filterList(kataKunci.toString())
                return true
            }
        })
        // val makanan yang mengambil fungsi dataMakanan() dari file Makanan.kt
        val makanan = DataMakanan()
        // untuk mengidentifikasi home adapter dengan parameter makanan
        HomeAdapter = homeAdapter(makanan)

        // untuk mengatur layout manager dan adapter untuk RecyclerView
        binding.ViewDataMakanan.layoutManager = GridLayoutManager(context, 2)
        // menghubungkan reyclcerView dengan adapter yang mengambil data dari HomeAdapter
        binding.ViewDataMakanan.adapter = HomeAdapter

        // saat salah satu item pada RecyclerView
        // di klik maka akan mengeksekusi kode didalamnya
        HomeAdapter.onItemClick = {
            // val intent yang menggunakan Intent untuk berpindah ke activty detail_data
            val intent = Intent(context, detail_data::class.java)
            // intent tersebut juga membawa data makanan sesuai data yang di klik
            intent.putExtra("Makanan", it)
            // memulai activty baru yang membawa intent yang sudah berisi data
            startActivity(intent)
        }
    }

    // untuk memfilter data berdasarkan query pencarian
    private fun filterList(query: String) {
        // mengambil fungsi dataMakanan dari file makanan.kt
        val data = DataMakanan()
        // val filteredList yang mengfilter data sesuai query yang masuk
        val filteredList = data.filter {
            // menjadikan data judul atau jenis (data local) menjadi huruf kecil,
            // contains yang memeriksa parameter query yang sudah dirubah menjadi huruf kecil
            // apakah sama, jika iya maka akan dimasukkan ke val filteredList
            it.judul.lowercase(Locale.ROOT).contains(query.lowercase(Locale.ROOT)) ||
            it.jenis.name.lowercase(Locale.ROOT).contains(query.lowercase(Locale.ROOT))
        }
        // jika val filteredList kosong atau data yang di cari tidak ada, data recyclerView akan kosong
        // jika val filteredList tidak kosong tampilkan data sesuai pencarian
        if (filteredList.isEmpty()) {
            (binding.ViewDataMakanan.adapter as? homeAdapter)?.setFilteredList(emptyList())
        } else {
            (binding.ViewDataMakanan.adapter as? homeAdapter)?.setFilteredList(filteredList)
        }
    }
}