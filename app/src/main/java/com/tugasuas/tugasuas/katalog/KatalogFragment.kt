package com.tugasuas.tugasuas.katalog

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ahmad.tugasuas.databinding.FragmentKatalogBinding
import com.tugasuas.tugasuas.database.JenisMakanan
import com.tugasuas.tugasuas.database.Makanan
import com.tugasuas.tugasuas.database.DataMakanan
import com.tugasuas.tugasuas.home.homeAdapter

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

        val makanan = DataMakanan()
        // mengatur filter makanan berdasarkan jenis makanan ringan
        binding.rvMakananRingan.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val makananRingan = makanan.filter { it.jenis == JenisMakanan.MAKANAN_RINGAN }.take(5)
        binding.rvMakananRingan.adapter = katalogAdapter(makananRingan)

        //mengatur filter makanan berdasarkan jenis makanan berat
        binding.rvMakananBerat.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val makananBerat = makanan.filter { it.jenis == JenisMakanan.MAKANAN_BERAT }.take(5)
        binding.rvMakananBerat.adapter = katalogAdapter(makananBerat)

        //mengatur filter makanan berdasarkan jenis makanan sayur
        binding.rvMakananSayur.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val makananSayur = makanan.filter { it.jenis == JenisMakanan.SAYUR}.take(5)
        binding.rvMakananSayur.adapter = katalogAdapter(makananSayur)

        //mengatur filter makanan berdasarkan jenis minuman
        binding.rvMinuman.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val minuman = makanan.filter { it.jenis == JenisMakanan.MINUMAN }.take(5)
        binding.rvMinuman.adapter = katalogAdapter(minuman)

        //mengatur filter makanan berdasarkan jenis kue
        binding.rvKue.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val kue = makanan.filter { it.jenis == JenisMakanan.MINUMAN }.take(5)
        binding.rvKue.adapter = katalogAdapter(kue)
    }
}