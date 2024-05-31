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
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_about_us, container, false)

        // Find ImageView elements by ID
        val instagramImageView: ImageView = view.findViewById(R.id.instagramImageView)
        val whatsappImageView: ImageView = view.findViewById(R.id.whatsappImageView)
        val telegramImageView: ImageView = view.findViewById(R.id.telegramImageView)

        // Set click listener for Instagram ImageView
        instagramImageView.setOnClickListener {
            val instagramIntent = Intent(Intent.ACTION_VIEW)
            instagramIntent.data = Uri.parse("https://www.instagram.com/guidehungry?igsh=MTg0YzMwd3lheWo4Mg==")
            instagramIntent.setPackage("com.instagram.android")
            try {
                startActivity(instagramIntent)
            } catch (e: Exception) {
                // Handle case where Instagram app is not installed
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
