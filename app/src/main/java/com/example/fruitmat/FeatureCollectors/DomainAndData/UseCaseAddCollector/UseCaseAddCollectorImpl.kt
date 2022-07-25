package com.example.fruitmat.FeatureCollectors.DomainAndData.UseCaseAddCollector

import androidx.recyclerview.widget.RecyclerView
import com.example.fruitmat.FeatureCollectors.DomainAndData.Manager.CollectorsManagerImpl
import com.example.fruitmat.FeatureCollectors.presentation.RcAdapter


class UseCaseAddCollectorImpl : UseCaseAddCollector {
    fun itGetsIt(){
        println("yes")
    }
    override fun updateRecAdapter(recyclerView: RecyclerView, managerImpl: CollectorsManagerImpl){
        managerImpl.addCollector("added by button")
        val adapter = RcAdapter(managerImpl.getCollectorsAsArrayList())
        recyclerView.adapter = adapter
    }
}