package com.hexadecimal.roomdbsample.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


// Created by Melih KOK
// kokmelih@gmail.com
// 20.04.2019 - 13:08

@Entity
data class ContactInfoEntity(

    // id degerini otomatik olarak arttıracak
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    // Column Info tablodaki isme karsilik gelir, nameden sonraki eleman
    // burada yazilan sutun degerleri, her yazdıgında bir sutuna ekleyecek
    @ColumnInfo(name = "phoneNumber")
    val phoneNumber: String,

    @ColumnInfo(name = "contactName")
    val contactName: String,

    @ColumnInfo(name = "contactAge")
    val contactAge: Int,

    @ColumnInfo(name = "contactEmail")
    val contactEmail: String

)