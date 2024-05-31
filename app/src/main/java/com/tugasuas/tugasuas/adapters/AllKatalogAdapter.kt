package com.tugasuas.tugasuas.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ahmad.tugasuas.databinding.DataMakananBinding
import com.tugasuas.tugasuas.database.Makanan

class AllKatalogAdapter :
    ListAdapter<Makanan, AllKatalogAdapter.MyViewHolder>(DIFF_CALLBACK) {
    var onFoodClick: ((Makanan) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(
        DataMakananBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    inner class MyViewHolder(private val binding: DataMakananBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(makanan: Makanan) {
            with(binding) {
                ivGambar.setImageDrawable(ContextCompat.getDrawable(root.context, makanan.gambar))

                tvJudul.text = makanan.judul
                tvJenis.text = makanan.judul

//                foodCard.setOnClickListener {
//                    onIngredientsClick?.invoke(makanan)
//                }
            }
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Makanan>() {
            override fun areItemsTheSame(
                oldItem: Makanan,
                newItem: Makanan
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: Makanan,
                newItem: Makanan
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}