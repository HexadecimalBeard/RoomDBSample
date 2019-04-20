package com.hexadecimal.roomdbsample.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hexadecimal.roomdbsample.dao.ContactInfoDao
import com.hexadecimal.roomdbsample.entity.ContactInfoEntity


// Created by Melih KOK
// kokmelih@gmail.com
// 20.04.2019 - 13:38


// tum DB in olusturalacagi yer

// version DB de koklu bir degisiklik yapilacaksa ( yeni kolon eklenmesi gibi ) eski version ile
// yeni version farklı oldu, boyle bir durumda version numarasini degistir
// DB de yapisal degisiklik var, DB yi yüklerken bunu uygulaman lazim

@Database(entities = [ContactInfoEntity::class], version = 1)
abstract class ContactInfoDB : RoomDatabase() {


    abstract fun getDao(): ContactInfoDao

}