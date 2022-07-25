package com.example.fruitmat.FeatureCollectors.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fruitmat.R
import com.example.fruitmat.FeatureCollectors.DomainAndData.CollectorDto

class RcAdapter(private val collectorsLst:ArrayList<CollectorDto>):RecyclerView.Adapter<RcAdapter.ReviewHolder>() {

    class ReviewHolder(itemview:View):RecyclerView.ViewHolder(itemview){
        val tvname = itemview.findViewById<TextView>(R.id.tvHeading)
        val tvcages = itemview.findViewById<TextView>(R.id.tvCages)
        val tvKg = itemview.findViewById<TextView>(R.id.tvkg)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewHolder {
        val itemview = LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return ReviewHolder(itemview)
    }

    override fun onBindViewHolder(holder: ReviewHolder, position: Int) {
        holder.tvname.text = collectorsLst[position].name
        holder.tvcages.text = collectorsLst[position].cages.toString()
        holder.tvKg.text = collectorsLst[position].kilograms.toString()
    }

    override fun getItemCount(): Int {
        return collectorsLst.size
    }
}