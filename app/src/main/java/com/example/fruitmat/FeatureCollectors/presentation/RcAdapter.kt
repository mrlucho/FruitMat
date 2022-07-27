package com.example.fruitmat.FeatureCollectors.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fruitmat.R
import com.example.fruitmat.FeatureCollectors.Domain.Manager.CollectorsManagerImpl
import com.example.fruitmat.FeatureCollectors.UseCaseAddCollected.UseCaseAddCollectedImpl

class RcAdapter(private val managerImpl: CollectorsManagerImpl,val context: Context?):RecyclerView.Adapter<RcAdapter.ReviewHolder>() {

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
        holder.itemView.setOnClickListener {
            UseCaseAddCollectedImpl(managerImpl,context,holder).trigger(position)
        }
        holder.tvname.text = managerImpl.getCollector(position).collectorDto.name
        holder.tvcages.text = managerImpl.getCollector(position).collectorDto.cages.toString()
        holder.tvKg.text = managerImpl.getCollector(position).collectorDto.kilograms.toString()

    }

    override fun getItemCount(): Int {
        return managerImpl.getCollectorsAsArrayList().size
    }
}