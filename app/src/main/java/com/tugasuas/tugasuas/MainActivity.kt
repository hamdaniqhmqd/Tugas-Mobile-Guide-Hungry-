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
    // membuat variabel binding untuk layout ActivityMain
    private lateinit var binding: ActivityMainBinding
    // metode yang dipanggil saat aktivitas dibuat
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // untuk menangani pemilihan item di BottomNavigationView
        // sesuai dengan listener-nya
        binding.Navigasi.setOnItemSelectedListener{item ->
            var selectedFragment: Fragment? = null
            // ketika fragment yang akan ditampilkan berdasarkan item yang dipilih
            when (item.itemId){
                R.id.HomeNavigasi -> selectedFragment = HomeFragment()
                R.id.KatalogNavigasi -> selectedFragment = KatalogFragment()
                R.id.AboutNavigasi -> selectedFragment = AboutUsFragment()
            }
            // jika fragment yang dipilih tidak null,
            // mengganti fragment saat ini dengan fragment yang dipilih
            if (selectedFragment != null) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.FragmentMenu, selectedFragment)
                    .commit()
            }
            true
        }
        // memastikan HomeFragment ditampilkan pertama kali
        // saat activity pertama kali dibuat
        if (savedInstanceState == null){
            binding.Navigasi.selectedItemId = R.id.HomeNavigasi
        }
    }
}