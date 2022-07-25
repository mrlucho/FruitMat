package com.example.fruitmat.FeatureCollectors.DomainAndData.UseCaseAddCollector

import androidx.recyclerview.widget.RecyclerView
import com.example.fruitmat.FeatureCollectors.DomainAndData.Manager.CollectorsManagerImpl
import com.example.fruitmat.FeatureCollectors.presentation.RcAdapter

interface UseCaseAddCollector
/**
 * triggers a dialog window to fill collectors name
 * it has to adjust the recyclerview adapter
 */
{
    fun updateRecAdapter(recyclerView: RecyclerView,managerImpl: CollectorsManagerImpl){
    }
}