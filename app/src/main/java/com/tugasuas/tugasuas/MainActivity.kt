package com.tugasuas.tugasuas

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.ahmad.tugasuas.R
import com.ahmad.tugasuas.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.tugasuas.tugasuas.aboutus.AboutUsFragment
import com.tugasuas.tugasuas.home.HomeFragment
import com.tugasuas.tugasuas.katalog.KatalogFragment

class MainActivity : AppCompatActivity() {
    // membuat variabel binding untuk layout Main Activty
    private lateinit var binding: ActivityMainBinding
    // metode yang dipanggil saat main activty dibuat
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // inflate(layoutInflater) untuk mengonversi layout XML menjadi objek yang
        // dapat digunakan oleh kode Kotlin
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // untuk menangani pemilihan item di BottomNavigationView
        // sesuai dengan listener-nya, item mana yang akan terseleksi
        binding.Navigasi.setOnItemSelectedListener{item ->
            var selectedFragment: Fragment? = null
            // ketika fragment yang akan ditampilkan berdasarkan item yang dipilih
            when (item.itemId){
                R.id.HomeNavigasi -> selectedFragment = HomeFragment()
                R.id.KatalogNavigasi -> selectedFragment = KatalogFragment()
                R.id.AboutNavigasi -> selectedFragment = AboutUsFragment()
            }
            // jika ada fragment yang dipilih, maka akan
            // mengganti fragment saat ini dengan fragment yang dipilih
            if (selectedFragment != null) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.FragmentMenu, selectedFragment)
                    .commit()
            }
            true
        }
        // jika objek savedInstanceState yang digunakan untuk menyimpan aktivitas
        // memiliki nilai sama dengan null, maka akan menampilkan fragment home
        if (savedInstanceState == null){
            binding.Navigasi.selectedItemId = R.id.HomeNavigasi
        }
    }
}