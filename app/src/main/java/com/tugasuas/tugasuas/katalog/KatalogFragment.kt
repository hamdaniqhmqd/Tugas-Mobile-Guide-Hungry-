package com.tugasuas.tugasuas.katalog

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ahmad.tugasuas.databinding.FragmentKatalogBinding
import com.tugasuas.tugasuas.adapters.HeadlineFoodAdapter
import com.tugasuas.tugasuas.allkatalog.AllKatalogActivity
import com.tugasuas.tugasuas.utils.FakeData

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

        setListeners()
        setRecyclerViews()
    }

    private fun setListeners() {
        binding.apply {
            btnMakananRingan.setOnClickListener {
                val iAllKatalogActivity = Intent(requireActivity(), AllKatalogActivity::class.java)
                iAllKatalogActivity.putParcelableArrayListExtra(
                    AllKatalogActivity.EXTRA_LIST_FOOD,
                    FakeData.foodList
                )
                startActivity(iAllKatalogActivity)
            }

            btnKue.setOnClickListener {
                val iAllKatalogActivity = Intent(requireActivity(), AllKatalogActivity::class.java)
                iAllKatalogActivity.putParcelableArrayListExtra(
                    AllKatalogActivity.EXTRA_LIST_FOOD,
                    FakeData.foodList
                )
                startActivity(iAllKatalogActivity)
            }

            btnMinuman.setOnClickListener {
                val iAllKatalogActivity = Intent(requireActivity(), AllKatalogActivity::class.java)
                iAllKatalogActivity.putParcelableArrayListExtra(
                    AllKatalogActivity.EXTRA_LIST_FOOD,
                    FakeData.foodList
                )
                startActivity(iAllKatalogActivity)
            }

            btnGorengan.setOnClickListener {
                val iAllKatalogActivity = Intent(requireActivity(), AllKatalogActivity::class.java)
                iAllKatalogActivity.putParcelableArrayListExtra(
                    AllKatalogActivity.EXTRA_LIST_FOOD,
                    FakeData.foodList
                )
                startActivity(iAllKatalogActivity)
            }

            btnMakananBerat.setOnClickListener {
                val iAllKatalogActivity = Intent(requireActivity(), AllKatalogActivity::class.java)
                iAllKatalogActivity.putParcelableArrayListExtra(
                    AllKatalogActivity.EXTRA_LIST_FOOD,
                    FakeData.foodList
                )
                startActivity(iAllKatalogActivity)
            }

            btnSayurSayuran.setOnClickListener {
                val iAllKatalogActivity = Intent(requireActivity(), AllKatalogActivity::class.java)
                iAllKatalogActivity.putParcelableArrayListExtra(
                    AllKatalogActivity.EXTRA_LIST_FOOD,
                    FakeData.foodList
                )
                startActivity(iAllKatalogActivity)
            }
        }
    }

    private fun setRecyclerViews() {
        binding.apply {
            rvMakananRingan.apply {
                val rvAdapter = HeadlineFoodAdapter().apply {
                    submitList(FakeData.foodList)
                }
                adapter = rvAdapter
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            }

            rvSayurSayuran.apply {
                val rvAdapter = HeadlineFoodAdapter().apply {
                    submitList(FakeData.foodList)
                }
                adapter = rvAdapter
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            }

            rvKue.apply {
                val rvAdapter = HeadlineFoodAdapter().apply {
                    submitList(FakeData.foodList)
                }
                adapter = rvAdapter
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            }

            rvGorengan.apply {
                val rvAdapter = HeadlineFoodAdapter().apply {
                    submitList(FakeData.foodList)
                }
                adapter = rvAdapter
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            }

            rvMinuman.apply {
                val rvAdapter = HeadlineFoodAdapter().apply {
                    submitList(FakeData.foodList)
                }
                adapter = rvAdapter
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            }

            rvMakananBerat.apply {
                val rvAdapter = HeadlineFoodAdapter().apply {
                    submitList(FakeData.foodList)
                }
                adapter = rvAdapter
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            }
        }
    }
}