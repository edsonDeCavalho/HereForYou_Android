package com.equality.herforyou

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter(var mList: List<ContactData>) : RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    inner class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val number: TextView = itemView.findViewById(R.id.phoneNumberOrName)
        val name : TextView = itemView.findViewById(R.id.contactName)
        val description : TextView = itemView.findViewById(R.id.contactDesc)
    }

    fun setFilteredList(mList: List<ContactData>){
        this.mList = mList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {

    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {

    }
}