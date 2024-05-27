package com.tugasuas.tugasuas.katalog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.ahmad.tugasuas.R
import com.ahmad.tugasuas.databinding.FragmentHomeBinding
import com.ahmad.tugasuas.databinding.FragmentKatalogBinding
import com.tugasuas.tugasuas.database.Makanan
import com.tugasuas.tugasuas.home.homeAdapter

class KatalogFragment : Fragment() {
    private var _binding: FragmentKatalogBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
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
        binding.Katalog1.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        val katalog1 = mutableListOf<Makanan>()
        katalog1.add(Makanan(R.drawable.rendang, "Makanan", "Tidak tau", "12.00", "-", "-", "-", "-"))
        katalog1.add(Makanan(R.drawable.rendang, "Rendang", "Makanan Berat", "24.00", "-", "-", "-", "-"))
        binding.Katalog1.adapter = homeAdapter(katalog1)

        binding.Katalog2.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        val katalog2 = mutableListOf<Makanan>()
        katalog2.add(Makanan(R.drawable.rendang, "Makanan", "Tidak tau", "12.00", "-", "-", "-", "-"))
        katalog2.add(Makanan(R.drawable.rendang, "Rendang", "Makanan Berat", "24.00", "-", "-", "-", "-"))
        binding.Katalog2.adapter = homeAdapter(katalog2)

        binding.Katalog3.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        val katalog3 = mutableListOf<Makanan>()
        katalog3.add(Makanan(R.drawable.rendang, "Makanan", "Tidak tau", "12.00", "-", "-", "-", "-"))
        katalog3.add(Makanan(R.drawable.rendang, "Rendang", "Makanan Berat", "24.00", "-", "-", "-", "-"))
        binding.Katalog3.adapter = homeAdapter(katalog3)

        binding.Katalog4.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        val katalog4 = mutableListOf<Makanan>()
        katalog4.add(Makanan(R.drawable.rendang, "Makanan", "Tidak tau", "12.00", "-", "-", "-", "-"))
        katalog4.add(Makanan(R.drawable.rendang, "Rendang", "Makanan Berat", "24.00", "-", "-", "-", "-"))
        binding.Katalog4.adapter = homeAdapter(katalog4)
    }
}