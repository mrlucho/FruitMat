package com.example.fruitmat.FeatureCollectors.Domain.UseCaseDisplayCollectorData.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fruitmat.FeatureCollectors.Data.AdditionsHistory
import com.example.fruitmat.R

class HistoryRecAdapter(val histEvents:List<AdditionsHistory>)
    :RecyclerView.Adapter<HistoryRecAdapter.HistoryViewHolder>(){
//    it gets already reversed lst from fragment code

    class HistoryViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val tvCages = itemView.findViewById<TextView>(R.id.tvCagesHist)
        val tvKg = itemView.findViewById<TextView>(R.id.tvKgHist)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.history_item_collector,parent,false)
        return HistoryViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.tvCages.text = histEvents[position].addCages.toString()
        holder.tvKg.text = histEvents[position].addKg.toString()
    }

    override fun getItemCount(): Int {
        return histEvents.size
    }

}