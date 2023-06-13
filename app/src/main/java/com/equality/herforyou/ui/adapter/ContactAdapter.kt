package com.equality.herforyou.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.equality.herforyou.R
import com.equality.herforyou.core.db.entity.ContactData

class ContactAdapter(private var mList: List<ContactData>) : RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

     class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nom_contact : TextView = itemView.findViewById(R.id.nom_contact)
        val role_contact : TextView = itemView.findViewById(R.id.role_contact)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent,false)
        return ContactViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {

        val contact : ContactData =mList[position]
        holder.nom_contact.text = contact.name
        holder.role_contact.text = contact.description
    }

    override fun getItemCount(): Int {
        return mList.size
    }
}