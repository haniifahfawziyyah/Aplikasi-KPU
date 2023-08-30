package com.skripsi.kpu.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.skripsi.kpu.databinding.ActivityDaftarDataPemilihBinding
import com.skripsi.kpu.helper.ViewModelFactory

class DaftarDataPemilih : AppCompatActivity() {

    private var _daftarDataPemilihBinding: ActivityDaftarDataPemilihBinding? = null
    private val binding get() = _daftarDataPemilihBinding

    private lateinit var adapter: DataPemilihAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _daftarDataPemilihBinding = ActivityDaftarDataPemilihBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        supportActionBar?.title = "Daftar Data Pemilih"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val daftarDataPemilihViewModel = obtainViewModel(this@DaftarDataPemilih)
        daftarDataPemilihViewModel.getAllDataPemilih().observe(this) { datapemilihList ->
            if (datapemilihList != null && datapemilihList.isNotEmpty()) {
                adapter.setListDataPemilih(datapemilihList)
            } else {
                adapter.setListDataPemilih(emptyList()) // Set an empty list to clear the previous data
                showNoDataSnackbar()
            }
        }

        adapter = DataPemilihAdapter()

        binding?.rvDatapemilih?.layoutManager = LinearLayoutManager(this)
        binding?.rvDatapemilih?.setHasFixedSize(true)
        binding?.rvDatapemilih?.adapter = adapter

    }

    private fun showNoDataSnackbar() {
        val snackbar = Snackbar.make(
            binding?.root!!, // Root view of the layout
            "Tidak ada data saat ini",
            Snackbar.LENGTH_LONG
        )
        snackbar.show()
    }

    private fun obtainViewModel(activity: AppCompatActivity): DaftarDataPemilihViewModel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory).get(DaftarDataPemilihViewModel::class.java)
    }

    override fun onDestroy() {
        super.onDestroy()
        _daftarDataPemilihBinding = null
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}