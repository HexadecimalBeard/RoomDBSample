package com.hexadecimal.roomdbsample.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


// Created by Melih KOK
// kokmelih@gmail.com
// 20.04.2019 - 13:08

// model class i gibi calisiyor
// dao class inda tabloyu yazdigin yerle aynı isimde tablo ismi vermelisin
@Entity(tableName = "contact_table")
data class ContactInfoEntity(

    // id gibi bir deger tutuyorsan basina alt cizgi koy, _id gibi
    // boolean bir deger varsa onun da onune alt cizgi koy
    // id degerini otomatik olarak arttıracak
    @PrimaryKey(autoGenerate = true) @NonNull
    val _id: Int = 0,

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