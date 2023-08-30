package com.skripsi.kpu.ui.main

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.skripsi.kpu.database.DataPemilih
import com.skripsi.kpu.repository.DataPemilihRepository

class DaftarDataPemilihViewModel(application: Application) : ViewModel() {
    private val mDataPemilihRepository: DataPemilihRepository = DataPemilihRepository(application)
    fun getAllDataPemilih(): LiveData<List<DataPemilih>> = mDataPemilihRepository.getAllDataPemilih()
}