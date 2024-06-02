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
    private lateinit var binding: ActivityLoginBinding

    object Data {
        val users = mapOf(
            "ahmad" to "12345678",
            "annisya" to "12345678",
            "dirajati" to "12345678",
            "fadhillah" to "12345678"
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginButton.setOnClickListener {
            val inputUser = binding.usernameEditText.text.toString()
            val inputPass = binding.passwordEditText.text.toString()

            if (Data.users[inputUser] == inputPass) {
                val submit = Intent(this, MainActivity::class.java)
                startActivity(submit)
            } else {
                Toast.makeText(
                    this,
                    "Login Gagal. Mohon Masukkan Data yang Sesuai",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}