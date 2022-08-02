package com.example.fruitmat.FeatureCollectors.Domain.UseCaseDisplayCollectorData.domain

import com.example.fruitmat.FeatureCollectors.Data.CollectorWithHistory
import com.example.fruitmat.common.constants.Consts.cageCapacity
import com.example.fruitmat.common.constants.dailyConsts.workerPaymentForKg

interface PayOutCollector {
    fun pay(collectorWithHistory: CollectorWithHistory):Float{
        val  pay = (collectorWithHistory.collectorDto.cages * cageCapacity + collectorWithHistory.collectorDto.kilograms )*workerPaymentForKg
        collectorWithHistory.paycheck = pay
        return pay
    }
    fun stringWithPayment(collectorWithHistory: CollectorWithHistory):String{
        return "(${collectorWithHistory.collectorDto.cages * cageCapacity} + ${collectorWithHistory.collectorDto.kilograms}) * $workerPaymentForKg = ${pay(collectorWithHistory)}"

    }

}