package com.hexadecimal.roomdbsample.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hexadecimal.roomdbsample.entity.ContactInfoEntity


// Created by Melih KOK
// kokmelih@gmail.com
// 21.04.2019 - 13:05

// high order function un geri donus degeri olmadigi icin -> Unit seklinde kullandik
class ContactListAdapter(
    private var contactInfoList: List<ContactInfoEntity>,
    private val onClickListener: (contactInfoEntity: ContactInfoEntity) -> Unit
) : RecyclerView.Adapter<ContactListViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactListViewHolder =
        ContactListViewHolder(parent)

    override fun getItemCount(): Int = contactInfoList.size

    override fun onBindViewHolder(holder: ContactListViewHolder, position: Int) {

        holder.bind(contactInfoList[position], onClickListener)
    }

    fun setNewItem(contactInfoList: List<ContactInfoEntity>){

        // disaridan gelen listeyi benim constructor dan gelen listeye esitledik
        this.contactInfoList = contactInfoList
        notifyDataSetChanged()
    }

}