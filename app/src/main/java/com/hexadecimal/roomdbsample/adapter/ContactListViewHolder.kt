package com.hexadecimal.roomdbsample.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hexadecimal.roomdbsample.R
import com.hexadecimal.roomdbsample.entity.ContactInfoEntity


// Created by Melih KOK
// kokmelih@gmail.com
// 21.04.2019 - 12:44

class ContactListViewHolder(parent : ViewGroup)
    : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate((
            R.layout.adapter_item_contact_list), parent, false)){

    private val txtPhoneNumber : TextView by lazy { itemView.findViewById<TextView>(R.id.txtPhoneNumber) }
    private val txtContactName : TextView by lazy { itemView.findViewById<TextView>(R.id.txtName) }
    private val txtContactAge : TextView by lazy { itemView.findViewById<TextView>(R.id.txtAge) }
    private val txtContactEmail : TextView by lazy { itemView.findViewById<TextView>(R.id.txtEmail) }

    // onClick icin high order function yazdik
    fun bind(contactInfoEntity: ContactInfoEntity, onClickListener: (contactInfoEntity: ContactInfoEntity) -> Unit){

        txtPhoneNumber.text = contactInfoEntity.phoneNumber
        txtContactName.text = contactInfoEntity.contactName
        // entity class icinde Int olarak tanimlandigi icin toString kullandik
        txtContactAge.text = contactInfoEntity.contactAge.toString()
        txtContactEmail.text = contactInfoEntity.contactEmail

        itemView.setOnClickListener {

            onClickListener(contactInfoEntity)
        }
    }

}