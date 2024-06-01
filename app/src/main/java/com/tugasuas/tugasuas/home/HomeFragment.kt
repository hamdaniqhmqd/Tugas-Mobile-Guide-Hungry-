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
import androidx.recyclerview.widget.LinearLayoutManager
import com.ahmad.tugasuas.R
import com.ahmad.tugasuas.databinding.FragmentHomeBinding
import com.tugasuas.tugasuas.database.DataMakanan
import com.tugasuas.tugasuas.database.Makanan
import com.tugasuas.tugasuas.detail_data.detail_data
import java.util.Locale

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var HomeAdapter: homeAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.inputPencarian.setOnClickListener {
            binding.inputPencarian.isIconified = false
        }

        binding.inputPencarian.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText.toString())
                return true
            }

        })
        val makanan = DataMakanan()
        HomeAdapter = homeAdapter(makanan)

        binding.ViewDataMakanan.layoutManager = GridLayoutManager(context, 2)
        binding.ViewDataMakanan.adapter = HomeAdapter

        HomeAdapter.onItemClick = {
            val intent = Intent(context, detail_data::class.java)
            intent.putExtra("Makanan", it)
            startActivity(intent)
        }
    }

    private fun filterList(query: String) {
        val data = DataMakanan()
        val filteredList = data.filter {
            it.judul.lowercase(Locale.ROOT).contains(query.lowercase(Locale.ROOT)) ||
            it.jenis.name.lowercase(Locale.ROOT).contains(query.lowercase(Locale.ROOT))
        }
        if (filteredList.isEmpty()) {
            Toast.makeText(context, "Data tidak ditemukan", Toast.LENGTH_SHORT).show()
        } else {
            (binding.ViewDataMakanan.adapter as? homeAdapter)?.setFilteredList(filteredList) // Assuming adapter has a function named setFilteredList
        }
    }
}