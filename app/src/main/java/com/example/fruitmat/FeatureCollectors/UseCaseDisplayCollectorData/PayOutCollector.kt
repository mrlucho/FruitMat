package com.example.fruitmat.FeatureCollectors.UseCaseDisplayCollectorData

import com.example.fruitmat.FeatureCollectors.Data.CollectorWithHistory
import com.example.fruitmat.common.constants.Consts.cageCapacity
import com.example.fruitmat.common.constants.dailyConsts.workerPaymentForKg

interface PayOutCollector {
    fun pay(collectorWithHistory: CollectorWithHistory):Float{
        return (collectorWithHistory.collectorDto.cages * cageCapacity + collectorWithHistory.collectorDto.kilograms )*workerPaymentForKg
    }
}