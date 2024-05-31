package com.tugasuas.tugasuas.allkatalog

import android.os.Bundle
import android.widget.SearchView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.ahmad.tugasuas.databinding.ActivityAllKatalogBinding
import com.tugasuas.tugasuas.adapters.AllKatalogAdapter
import com.tugasuas.tugasuas.database.Makanan

class AllKatalogActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAllKatalogBinding

    //    private lateinit var listFood: ArrayList<Makanan>
    private val listFood: ArrayList<Makanan> by lazy {
        intent.getParcelableArrayListExtra(EXTRA_LIST_FOOD) ?: arrayListOf()
    }

    private val viewModel: AllKatalogViewModel by viewModels<AllKatalogViewModel> {
        AllKatalogViewModel.ViewModelInjector(listFood)
    }


    private val foodAdapter = AllKatalogAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAllKatalogBinding.inflate(layoutInflater)
        setContentView(binding.root)

        observeViewModel()
        setRecyclerView()
        setSearchBar()
        setListeners()
    }

    private fun observeViewModel() {
        viewModel.apply {
            searchedFood.observe(this@AllKatalogActivity) {
                foodAdapter.submitList(it)
                binding.emptyView.isVisible = it.isEmpty()
            }

            isFilteredAtoZ.observe(this@AllKatalogActivity) {
                it?.let {
                    if (it) {
                        binding.filter.text = "Z-A"
                    } else {
                        binding.filter.text = "A-Z"
                    }
                }
            }
        }
    }

    private fun setSearchBar() {
        binding.svAccounts.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.searchFood(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText.isNullOrEmpty()) {
                    viewModel.searchFood("")
                }
                return false
            }
        })
    }

    private fun setRecyclerView() {
        binding.rvFood.apply {
            layoutManager = LinearLayoutManager(this@AllKatalogActivity)
            adapter = foodAdapter
        }
    }

    private fun setListeners() {
        binding.apply {
            btnBack.setOnClickListener { finish() }
            filter.setOnClickListener {
                viewModel.searchedFood.value?.let {
                    viewModel.filterFood(it, true)
                }
                binding.rvFood.scrollToPosition(0)
            }
        }
    }

    companion object {
        const val EXTRA_LIST_FOOD = "extra_list_food"
    }
}