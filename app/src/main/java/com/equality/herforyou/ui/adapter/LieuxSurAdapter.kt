package com.equality.herforyou.ui.adapter

import android.content.res.Resources
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.equality.herforyou.R
import com.equality.herforyou.core.db.entity.LieuxSur

class LieuxSurAdapter(private var dataSet: Array<LieuxSur?>) : RecyclerView.Adapter<LieuxSurAdapter.ViewHolder>() {
    private lateinit var Mresources: Resources
    private var datasetA: Array<LieuxSur?> = dataSet

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nom_lieux_sur: TextView
        val distance: TextView
        val image_lieux_sur : ImageView
        val button_Lieux_sur : ImageButton
        init {
            nom_lieux_sur = view.findViewById(R.id.nom_lieux_sur)
            distance = view.findViewById(R.id.distance)
            image_lieux_sur = view.findViewById(R.id.image_lieux_sur)
            button_Lieux_sur = view.findViewById(R.id.button_Lieux_sur)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_safe_places, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val lieuxSur : LieuxSur? = datasetA[position]

        if (lieuxSur != null) {
            holder.nom_lieux_sur.text=lieuxSur.nom_lieu_sur
            holder.distance.text=lieuxSur.lat.toString()+"   "+lieuxSur.long.toString()
            holder.image_lieux_sur.setImageDrawable(Mresources.getDrawable(R.drawable.fake_safe_place))

            holder.button_Lieux_sur.setOnClickListener {
                Log.i("Go lieux sur","Lieux :"+holder.nom_lieux_sur)
            }
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

}