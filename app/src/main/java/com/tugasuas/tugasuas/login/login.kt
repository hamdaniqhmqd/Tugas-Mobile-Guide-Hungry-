package com.tugasuas.tugasuas.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ahmad.tugasuas.R
import com.ahmad.tugasuas.databinding.ActivityLoginBinding
import com.tugasuas.tugasuas.MainActivity
import com.tugasuas.tugasuas.home.HomeFragment

class login : AppCompatActivity() {
    // membuat variabel binding untuk memanggil ActivtyLogin
    private lateinit var binding: ActivityLoginBinding
    // untuk menampung data user dan pass untuk aout login
    object Data {
        val users = mapOf(
            "ahmad" to "12345678",
            "annisya" to "12345678",
            "dirajati" to "12345678",
            "fadhillah" to "12345678"
        )
    }
    // untuk mengatur dan menampilkan tampilan ui dari login
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // untuk menampilkan tampilan UI dari login
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // listener untuk auth login
        binding.loginButton.setOnClickListener {
            // mengambil inputan username
            val inputUser = binding.usernameEditText.text.toString()
            // mengambil inputan pass
            val inputPass = binding.passwordEditText.text.toString()
            // jika data username sama dengan data input password,
            // maka akan mengeksekusi kode yang berpindah ke main activty
            if (Data.users[inputUser] == inputPass) {
                val submit = Intent(this, MainActivity::class.java)
                startActivity(submit)
            } else {
                // jika salah maka akan menampilkan pesan
                Toast.makeText(
                    this,
                    "Login Gagal. Mohon Masukkan Data yang Sesuai",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}