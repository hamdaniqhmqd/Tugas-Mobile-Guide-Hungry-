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
// untuk mengatur dan menampilkan tampilan ui dari home fragment
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Menginflate layout untuk fragmen ini
        val view = inflater.inflate(R.layout.fragment_about_us, container, false)

        // Menemukan elemen ImageView berdasarkan ID
        val instagramImageView: ImageView = view.findViewById(R.id.instagramImageView)
        val whatsappImageView: ImageView = view.findViewById(R.id.whatsappImageView)
        val telegramImageView: ImageView = view.findViewById(R.id.telegramImageView)

        // Menetapkan click listener untuk Instagram ImageView
        instagramImageView.setOnClickListener {
            val instagramIntent = Intent(Intent.ACTION_VIEW)
            instagramIntent.data = Uri.parse("https://www.instagram.com/guidehungry?igsh=MTg0YzMwd3lheWo4Mg==")
            instagramIntent.setPackage("com.instagram.android")
            try {
                startActivity(instagramIntent)
            } catch (e: Exception) {
                // Menangani kasus dimana aplikasi Instagram tidak terpasang
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/guidehungry?igsh=MTg0YzMwd3lheWo4Mg==")))
            }
        }

        // Menetapkan click listener untuk WhatsApp ImageView
        whatsappImageView.setOnClickListener {
            val whatsappIntent = Intent(Intent.ACTION_VIEW)
            whatsappIntent.data = Uri.parse("https://wa.me/message/XC6BA6ZEUJ3FN1")
            whatsappIntent.setPackage("com.whatsapp")
            try {
                startActivity(whatsappIntent)
            } catch (e: Exception) {
                // Jika aplikasi WhatsApp tidak terpasang, buka URL di browser
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://wa.me/message/XC6BA6ZEUJ3FN1")))
            }
        }

        // Menetapkan click listener untuk Telegram ImageView
        telegramImageView.setOnClickListener {
            val telegramIntent = Intent(Intent.ACTION_VIEW)
            telegramIntent.data = Uri.parse("https://t.me/GuideHungry")
            telegramIntent.setPackage("org.telegram.messenger")
            try {
                startActivity(telegramIntent)
            } catch (e: Exception) {
                // Menangani kasus dimana aplikasi Telegram tidak terpasang
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/GuideHungry")))
            }
        }

        return view
    }
}
