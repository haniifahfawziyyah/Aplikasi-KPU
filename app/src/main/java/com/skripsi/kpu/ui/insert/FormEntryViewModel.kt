package com.skripsi.kpu.ui.insert

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.skripsi.kpu.database.DataPemilih
import com.skripsi.kpu.repository.DataPemilihRepository
import kotlinx.coroutines.launch

class FormEntryViewModel(application: Application) : AndroidViewModel(application) {

    private val mDataPemilihRepository: DataPemilihRepository = DataPemilihRepository(application)

    fun insert(datapemilih: DataPemilih) {
        mDataPemilihRepository.insert(datapemilih)
    }

    fun update(datapemilih: DataPemilih) {
        mDataPemilihRepository.update(datapemilih)
    }

    fun getDataPemilihByNIK(nik: String): LiveData<DataPemilih> {
        return mDataPemilihRepository.getDataPemilihByNIK(nik)
    }

    fun delete(datapemilih: DataPemilih) {
        mDataPemilihRepository.delete(datapemilih)
    }

}
