package com.example.fruitmat.FeatureCollectors.Domain.UseCaseDisplayCollectorData.domain

import com.example.fruitmat.FeatureCollectors.Data.CollectorWithHistory
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
}