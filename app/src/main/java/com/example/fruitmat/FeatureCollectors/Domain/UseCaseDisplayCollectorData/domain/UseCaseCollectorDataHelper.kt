package com.example.fruitmat.FeatureCollectors.Domain.UseCaseDisplayCollectorData.domain

import android.view.View
import com.example.fruitmat.FeatureCollectors.Data.CollectorWithHistory
import com.example.fruitmat.FeatureCollectors.Domain.Manager.CollectorsManagerImpl
import com.example.fruitmat.FeatureCollectors.presentation.RcAdapter
import com.example.fruitmat.common.constants.Consts
import com.example.fruitmat.common.constants.dailyConsts

class UseCaseCollectorDataHelper {
    fun pay(collectorWithHistory: CollectorWithHistory):Float{
        val  pay = (collectorWithHistory.collectorDto.cages * Consts.cageCapacity + collectorWithHistory.collectorDto.kilograms )* dailyConsts.workerPaymentForKg
        collectorWithHistory.paycheck = pay
        return pay
    }
    fun paymentString(collectorWithHistory: CollectorWithHistory):String{
        return "(${collectorWithHistory.collectorDto.cages * Consts.cageCapacity} + ${collectorWithHistory.collectorDto.kilograms}) * ${dailyConsts.workerPaymentForKg} = ${pay(collectorWithHistory)}"

    }
    fun togglePaymentVisibility(holder: RcAdapter.ReviewHolder,managerImpl:CollectorsManagerImpl,position:Int){
        holder.imgPay.visibility = if(managerImpl.getCollector(position).paycheck != 0f){
            View.VISIBLE
        }
        else{
            View.INVISIBLE
        }
    }
}