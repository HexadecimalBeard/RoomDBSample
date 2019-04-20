package com.hexadecimal.roomdbsample.db

import android.content.Context
import androidx.room.Room


// Created by Melih KOK
// kokmelih@gmail.com
// 20.04.2019 - 13:47

class DatabaseClient {

    companion object {
        var INSTANCE: ContactInfoDB? = null

        fun getAppDataBase(context: Context): ContactInfoDB? {
            if (INSTANCE == null) {
                synchronized(ContactInfoDB::class) {
                    INSTANCE =
                        Room.databaseBuilder(
                            context.applicationContext,
                            ContactInfoDB::class.java,
                            "myDB"
                        ).build()
                }
            }
            return INSTANCE
        }

        fun destroyDataBase() {
            INSTANCE = null
        }
    }
}