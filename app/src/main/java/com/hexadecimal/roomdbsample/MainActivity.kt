package com.hexadecimal.roomdbsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.hexadecimal.roomdbsample.adapter.ContactListAdapter
import com.hexadecimal.roomdbsample.dao.ContactInfoDao
import com.hexadecimal.roomdbsample.db.ContactInfoDB
import com.hexadecimal.roomdbsample.entity.ContactInfoEntity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // db class indan islemlere baslayacagiz
        // database i olusturdugumuz classdan bir metodu cagirdik
        val contactInfoDB = ContactInfoDB.getInstance(this)

        // ilgili instance degiskeni nullable oldugu icin ? koyduk
        // interface i geri dondurdu, bu interface in metodlarini olusturabiliyoruz
        val contactInfoDao = contactInfoDB?.getContactInfoDao()

        // id degerine default 0 verdik o yuzden istemedi
        val contactInfoEntity = ContactInfoEntity(
            phoneNumber = "55577999",
            contactName = "Melih",
            contactAge = 23,
            contactEmail = "abc@deneme.com"
        )

        val contactInfoEntity2 = ContactInfoEntity(
            phoneNumber = "55577999",
            contactName = "Kenan",
            contactAge = 23,
            contactEmail = "abc@deneme.com"
        )

        Thread() {
            kotlin.run {
                // ekleyecegim kolonda degerler olması icin parametreyi verdik
                contactInfoDao?.addNewItem(contactInfoEntity)
                contactInfoDao?.addNewItem(contactInfoEntity2)
            }
        }.start()

        var allContactList: List<ContactInfoEntity>? = null
        thread(start = true) {

            allContactList = contactInfoDao?.getAllList()
            recyclerTodoList.adapter = ContactListAdapter(allContactList!!) { contactInfoEntity ->

                var newContactList: List<ContactInfoEntity>? = null
                thread(start = true) {

                    contactInfoDao?.removeItem(contactInfoEntity)

                    newContactList = contactInfoDao?.getAllList()

                    runOnUiThread {
                        // kendi adapter imiz oldugu icin kendi adapter imiz olacak sekilde cast ettik
                        (recyclerTodoList.adapter as ContactListAdapter).setNewItem(newContactList!!)
                    }

                }

            }
            recyclerTodoList.layoutManager = LinearLayoutManager(this)
        }
    }

}
