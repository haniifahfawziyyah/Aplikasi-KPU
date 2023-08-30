package com.skripsi.kpu.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.skripsi.kpu.database.DataPemilih
import com.skripsi.kpu.database.DataPemilihDao
import com.skripsi.kpu.database.DataPemilihRoomDatabase
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class DataPemilihRepository(application: Application) {
    private val mDataPemilihDao: DataPemilihDao
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val db = DataPemilihRoomDatabase.getDatabase(application)
        mDataPemilihDao = db.datapemilihDao()
    }

    fun getAllDataPemilih(): LiveData<List<DataPemilih>> = mDataPemilihDao.getAllDataPemilih()

    fun insert(datapemilih: DataPemilih) {
        executorService.execute { mDataPemilihDao.insert(datapemilih) }
    }

    fun getDataPemilihByNIK(nik: String): LiveData<DataPemilih> {
        return mDataPemilihDao.getDataPemilihByNIK(nik)
    }

    fun delete(datapemilih: DataPemilih) {
        executorService.execute { mDataPemilihDao.delete(datapemilih) }
    }

    fun update(datapemilih: DataPemilih) {
        executorService.execute { mDataPemilihDao.update(datapemilih) }
    }
}
