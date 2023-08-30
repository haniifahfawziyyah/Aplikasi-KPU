package com.skripsi.kpu.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.skripsi.kpu.databinding.ActivityMainBinding
import com.skripsi.kpu.ui.insert.FormEntry

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonInformasi.setOnClickListener {
            val intent = Intent(this, Informasi::class.java)
            startActivity(intent)
        }

        binding.buttonFormEntry.setOnClickListener {
            val intent = Intent(this, FormEntry::class.java)
            startActivity(intent)
        }

        binding.buttonLihatData.setOnClickListener {
            val intent = Intent(this, DaftarDataPemilih::class.java)
            startActivity(intent)
        }

        binding.buttonKeluar.setOnClickListener {
            finish() // Menutup aktivitas (keluar dari aplikasi)
        }
    }
}