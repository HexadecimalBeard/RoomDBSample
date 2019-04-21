package com.hexadecimal.roomdbsample.dao

import android.os.FileObserver.DELETE
import androidx.room.*
import com.hexadecimal.roomdbsample.entity.ContactInfoEntity


// Created by Melih KOK
// kokmelih@gmail.com
// 20.04.2019 - 13:19

@Dao
interface ContactInfoDao {

    // eger ekleme sirasinda cakisma olursa yeni eklenen datayi eskisinin uzerine yazar
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    // eklenecek item i parametre olarak verdik
    fun addNewItem(contactInfoEntity: ContactInfoEntity)

    @Delete
    fun removeItem(contactInfoEntity: ContactInfoEntity)

    @Update
    fun updateItem(contactInfoEntity: ContactInfoEntity)

    // bu fonk. sonuc donecek, tek bir item donecek
    @Query("SELECT * FROM contact_table WHERE _id = :id")
    // hangi ozellige gore arama yapacaksan buna o ozelligi parametre olarak gecir
    fun findSingleItem(id: Int): ContactInfoEntity

    // bu fonk. sonuc donecek, array list olarak
    @Query("SELECT * FROM contact_table")
    fun getAllList(): List<ContactInfoEntity>

    @Query("DELETE FROM contact_table")
    fun deleteAllTable()


}