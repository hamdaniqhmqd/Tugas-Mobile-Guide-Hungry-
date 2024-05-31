package com.tugasuas.tugasuas.allkatalog

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tugasuas.tugasuas.database.Makanan

class AllKatalogViewModel private constructor(private val foodList: ArrayList<Makanan>) :
    ViewModel() {
    private val _searchedFood = MutableLiveData<ArrayList<Makanan>>(arrayListOf())
    val searchedFood: LiveData<ArrayList<Makanan>> = _searchedFood

    val isFilteredAtoZ = MutableLiveData(true)

    init {
        filterFood(foodList)
    }

    fun searchFood(query: String) {
        val searchedFood = if (query.isEmpty()) {
            foodList
        } else {
            foodList.filter { ingredient ->
                ingredient.judul.contains(query, ignoreCase = true)
            }
        }

        filterFood(ArrayList(searchedFood))
    }

    fun filterFood(foodList: ArrayList<Makanan>, isChangeFilter: Boolean = false) {
        if (isChangeFilter) {
            isFilteredAtoZ.postValue(isFilteredAtoZ.value != true)
        }
        if (isFilteredAtoZ.value == true) {
            _searchedFood.postValue(ArrayList(foodList.sortedBy { it.judul }))
        } else {
            _searchedFood.postValue(ArrayList(foodList.sortedByDescending { it.judul }))
        }
    }

    class ViewModelInjector(
        private val foodList: ArrayList<Makanan>
    ) :
        ViewModelProvider.NewInstanceFactory() {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>) = AllKatalogViewModel(
            foodList
        ) as T
    }
}