package com.tugasuas.tugasuas.aboutus

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.ahmad.tugasuas.R

class AboutUsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflater untuk menjadikan layout menjadi tampilan
        val view = inflater.inflate(R.layout.fragment_about_us, container, false)

        // mengidentifikasi gambar instagram, whatsapp, telegram melalui id nya
        val instagramImageView: ImageView = view.findViewById(R.id.instagramImageView)
        val whatsappImageView: ImageView = view.findViewById(R.id.whatsappImageView)
        val telegramImageView: ImageView = view.findViewById(R.id.telegramImageView)

        // jika val instagramImageView di klik maka akan mengeksekusi
        instagramImageView.setOnClickListener {
            // instagramIntent memiliki intent ke sebuah data (ACTION_VIEW)
            val instagramIntent = Intent(Intent.ACTION_VIEW)
            // data yang digunakan yaitu URL
            instagramIntent.data = Uri.parse("https://www.instagram.com/guidehungry?igsh=MTg0YzMwd3lheWo4Mg==")
            // setPackage menentukan URL harus dibuka dengan aplikasi
            instagramIntent.setPackage("com.instagram.android")
            try {
                // jika punya aplikasi
                startActivity(instagramIntent)
            } catch (e: Exception) {
                // jika tidak punya aplikasi, akan mengarah ke website
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/guidehungry?igsh=MTg0YzMwd3lheWo4Mg==")))
            }
        }

        // Set click listener for WhatsApp ImageView
        whatsappImageView.setOnClickListener {
            val whatsappIntent = Intent(Intent.ACTION_VIEW)
            whatsappIntent.data = Uri.parse("https://wa.me/message/XC6BA6ZEUJ3FN1")
            whatsappIntent.setPackage("com.whatsapp")
            try {
                startActivity(whatsappIntent)
            } catch (e: Exception) {
                // Handle case where WhatsApp app is not installed
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://wa.me/message/XC6BA6ZEUJ3FN1")))
            }
        }

        // Set click listener for Telegram ImageView
        telegramImageView.setOnClickListener {
            val telegramIntent = Intent(Intent.ACTION_VIEW)
            telegramIntent.data = Uri.parse("https://t.me/GuideHungry")
            telegramIntent.setPackage("org.telegram.messenger")
            try {
                startActivity(telegramIntent)
            } catch (e: Exception) {
                // Handle case where Telegram app is not installed
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/GuideHungry")))
            }
        }

        return view
    }
}
