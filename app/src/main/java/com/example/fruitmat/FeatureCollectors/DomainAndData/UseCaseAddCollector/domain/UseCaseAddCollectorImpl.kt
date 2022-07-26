package com.example.fruitmat.FeatureCollectors.DomainAndData.UseCaseAddCollector.domain

import android.content.Context
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import com.example.fruitmat.FeatureCollectors.DomainAndData.Manager.CollectorsManagerImpl
import com.example.fruitmat.FeatureCollectors.DomainAndData.UseCaseAddCollector.domain.UseCaseAddCollector
import com.example.fruitmat.FeatureCollectors.presentation.RcAdapter
import com.example.fruitmat.R


class UseCaseAddCollectorImpl(val managerImpl: CollectorsManagerImpl,val recyclerView: RecyclerView)
    : UseCaseAddCollector {
    fun itGetsIt(){
        println("yes")
    }
    override fun updateRecAdapter(){
        val adapter = RcAdapter(managerImpl.getCollectorsAsArrayList())
        recyclerView.adapter = adapter
    }
    fun popDialogView(){
//        val mDialogView = LayoutInflater.from(context).inflate(R.layout.add_collector_dialog,null)
    }
    fun cancelAddingNewCollectorBtnCancelPressed(){

    }
}