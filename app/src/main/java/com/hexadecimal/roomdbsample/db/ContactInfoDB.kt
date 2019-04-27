package com.hexadecimal.roomdbsample.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
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

// abstract class yaptik ki disaridan nesne olusturulamasin
// eger class i abstract yapmasaydik primary constructor i private olarak tanimlamak lazım
// class ContactInfoDB private constructor(): RoomDatabase() seklinde kullanmaliydik
@Database(entities = [ContactInfoEntity::class], version = 1)
// hangi entity ler kullanilacaksa onu verdik, birden fazla tablon varsa class ismi sonuna
// virgul koyup diger tabloyu yaratan class ismini ver
abstract class ContactInfoDB : RoomDatabase() {

    // metodun geri donus degeri bir interface, nesnesini yaratamadigimiz icin body si yok
    // bir return degeri olamayacagindan dolayi nesnesini yaratamıyoruz, constructor i yok
    // eger bir metodun body si yoksa astract olmak zorundadır
    abstract fun getContactInfoDao(): ContactInfoDao

    // bir singleton yapi hazirladik, instance sadece bir defa olusturulsun
    companion object {
        // bu metod icerisindeki degiskenler ve metodlar class isminden sonra nokta koyarak erisilebilir
        private var INSTANCE: ContactInfoDB? = null

        fun getInstance(context: Context): ContactInfoDB? {

            // eger uygulamanın daha hızlı calismasini istiyorsan paralel programlama yapman gerekiyor
            // elindeki islem yukunu cekirdeklere paylastirinca islemler daha hızlı calisiyor
            // bu islemcilerin yaptigi islemlerden diger thread lerin haberdar olmasi lazim
            // herhangi bir metodun veya sinifin uzerinde ifade varsa
            // synchronized classlar veya metodlar uzerinde kullanilir
            // synchronized parantezi icindeki islemi sadece ayni anda bir thread yapar
            synchronized(ContactInfoDB::class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        // yaratilacak olan database e isim verdik
                        ContactInfoDB::class.java, "contact_info_database"
                    )
                        // db yaratildigi anda var olan verileri eklemek icin buraya metod yazilabilir
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            // bu instance ile DAO ya eriseceksin ve icindeki metodlari kullanabileceksin
            return INSTANCE
        }
    }
}