package com.tugasuas.tugasuas.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.ahmad.tugasuas.R
import com.ahmad.tugasuas.databinding.FragmentHomeBinding
import com.tugasuas.tugasuas.database.Makanan

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
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
        binding.ViewDataMakanan.layoutManager = LinearLayoutManager(context)
        val makanan = mutableListOf<Makanan>()
        makanan.add(Makanan(R.drawable.rendang, "Makanan", "Tidak tau", "12.00", "-", "-", "-", "-"))
        makanan.add(Makanan(R.drawable.rendang, "Rendang", "Makanan Berat", "24.00", "-", "-", "-", "-"))
        binding.ViewDataMakanan.adapter = homeAdapter(makanan)
    }
}