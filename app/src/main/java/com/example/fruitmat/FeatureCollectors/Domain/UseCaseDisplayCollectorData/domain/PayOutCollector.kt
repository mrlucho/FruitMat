package com.example.fruitmat.FeatureCollectors.Domain.UseCaseDisplayCollectorData.domain

import com.example.fruitmat.FeatureCollectors.Data.CollectorWithHistory
import com.example.fruitmat.FeatureCollectors.Domain.Manager.CollectorsManagerImpl
import com.example.fruitmat.common.constants.Constants.cageCapacity
import com.example.fruitmat.common.constants.dailyConsts.workerPaymentForKg

interface PayOutCollector {
    fun payAndMarkColPayed(collectorWithHistory: CollectorWithHistory):Float
    fun paymentString(collectorWithHistory: CollectorWithHistory):String
    fun togglePaymentVisibility(collectorWithHistory: CollectorWithHistory): Int
}