package com.example.fruitmat.FeatureCollectors.Domain.UseCaseDisplayCollectorData.domain

import com.example.fruitmat.FeatureCollectors.Data.CollectorWithHistory

interface PayOutCollector {
    fun payAndMarkColPayed(collectorWithHistory: CollectorWithHistory):Float
    fun paymentString(collectorWithHistory: CollectorWithHistory):String
    fun togglePaymentVisibility(collectorWithHistory: CollectorWithHistory): Int
}