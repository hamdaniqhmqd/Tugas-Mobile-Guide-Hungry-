package com.tugasuas.tugasuas.katalog

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ahmad.tugasuas.databinding.FragmentKatalogBinding
import com.tugasuas.tugasuas.database.JenisMakanan
import com.tugasuas.tugasuas.database.DataMakanan
import com.tugasuas.tugasuas.detail_data.detail_data

class KatalogFragment : Fragment() {
    private var _binding: FragmentKatalogBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentKatalogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // untuk menampilkan data sesuai dengan jenis datanya
        val makanan = DataMakanan()
        // jenis makananan ringan
        val makananRingan = katalogAdapter(makanan.filter { it.jenis == JenisMakanan.MAKANAN_RINGAN }.take(5))
        binding.rvMakananRingan.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvMakananRingan.adapter = makananRingan
        // jika item makanan ringan di klik maka akan di direct ke tampilan detail data
        makananRingan.onItemClick = { makanan ->
            val intent = Intent(context, detail_data::class.java)
            intent.putExtra("Makanan", makanan)
            startActivity(intent)
        }

        // jenis makananan berat
        val makananBerat = katalogAdapter(makanan.filter { it.jenis == JenisMakanan.MAKANAN_BERAT }.take(5))
        binding.rvMakananBerat.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvMakananBerat.adapter = makananBerat
        // jika item makanan berat di klik maka akan di direct ke tampilan detail data
        makananBerat.onItemClick = { makanan ->
            val intent = Intent(context, detail_data::class.java)
            intent.putExtra("Makanan", makanan)
            startActivity(intent)
        }

        // jenis sayur
        val Sayur = katalogAdapter(makanan.filter { it.jenis == JenisMakanan.SAYUR }.take(5))
        binding.rvMakananSayur.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvMakananSayur.adapter = Sayur
        // jika item sayur di klik maka akan di direct ke tampilan detail data
        Sayur.onItemClick = { makanan ->
            val intent = Intent(context, detail_data::class.java)
            intent.putExtra("Makanan", makanan)
            startActivity(intent)
        }

        // jenis minuman
        val Minuman = katalogAdapter(makanan.filter { it.jenis == JenisMakanan.MINUMAN }.take(5))
        binding.rvMinuman.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvMinuman.adapter = Minuman
        // jika item minuman di klik maka akan di direct ke tampilan detail data
        Minuman.onItemClick = { makanan ->
            val intent = Intent(context, detail_data::class.java)
            intent.putExtra("Makanan", makanan)
            startActivity(intent)
        }

        // jenis kui
        val Kue = katalogAdapter(makanan.filter { it.jenis == JenisMakanan.KUE }.take(5))
        binding.rvKue.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvKue.adapter = Kue
        // jika item kue di klik maka akan di direct ke tampilan detail data
        Kue.onItemClick = { makanan ->
            val intent = Intent(context, detail_data::class.java)
            intent.putExtra("Makanan", makanan)
            startActivity(intent)
        }
    }
}