package com.skripsi.kpu.helper

import androidx.recyclerview.widget.DiffUtil
import com.skripsi.kpu.database.DataPemilih

class DataPemilihDiffCallback(private val oldDataPemilihList: List<DataPemilih>, private val newDataPemilihList: List<DataPemilih>) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldDataPemilihList.size
    override fun getNewListSize(): Int = newDataPemilihList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldDataPemilihList[oldItemPosition].id == newDataPemilihList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldDataPemilihList = oldDataPemilihList[oldItemPosition]
        val newDataPemilihList = newDataPemilihList[newItemPosition]
        return oldDataPemilihList.nik == newDataPemilihList.nik
                && oldDataPemilihList.nama == newDataPemilihList.nama
                && oldDataPemilihList.nomorhp == newDataPemilihList.nomorhp
                && oldDataPemilihList.jeniskelamin == newDataPemilihList.jeniskelamin
                && oldDataPemilihList.date == newDataPemilihList.date
                && oldDataPemilihList.alamat == newDataPemilihList.alamat
                && oldDataPemilihList.latitude == newDataPemilihList.latitude
                && oldDataPemilihList.longitude == newDataPemilihList.longitude
                && oldDataPemilihList.gambar.contentEquals(newDataPemilihList.gambar)
    }
}