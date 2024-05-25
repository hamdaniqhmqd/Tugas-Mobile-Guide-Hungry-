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
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.Navigasi)
        bottomNavigationView.setOnItemSelectedListener{item ->
            var selectedFragment: Fragment? = null
            when (item.itemId){
                R.id.HomeNavigasi -> selectedFragment = HomeFragment()
                R.id.KatalogNavigasi -> selectedFragment = KatalogFragment()
                R.id.AboutNavigasi -> selectedFragment = AboutUsFragment()
            }
            if (selectedFragment != null) {
                supportFragmentManager.beginTransaction().replace(R.id.FragmentMenu, selectedFragment).commit()
            }
            true
        }

        if (savedInstanceState == null){
            bottomNavigationView.selectedItemId = R.id.HomeNavigasi
        }
    }
}