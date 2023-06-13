package com.equality.herforyou

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter(private var mList: List<ContactData>) : RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    inner class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val contactNumber: TextView = itemView.findViewById(R.id.phoneNumberOrName)
        val contactName : TextView = itemView.findViewById(R.id.contactName)
        val contactDescription : TextView = itemView.findViewById(R.id.contactDesc)
    }

//    fun setFilteredList(mList: List<ContactData>){
//        this.mList = mList
//        notifyDataSetChanged()
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent,false)
        return ContactViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.contactNumber.text = mList[position].number.toString()
        holder.contactName.text = mList[position].name
        holder.contactDescription.text = mList[position].description
    }

    override fun getItemCount(): Int {
        return mList.size
    }
}