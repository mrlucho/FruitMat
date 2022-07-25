package com.example.fruitmat.FeatureCollectors.DomainAndData.Manager

import com.example.fruitmat.FeatureCollectors.DomainAndData.CollectorDto

interface CollectorsManager {
    fun getCollectorsAsArrayList():ArrayList<CollectorDto>
    fun getCollector(position:Int): CollectorDto
    fun addCollector(name: String)
    fun addHarvestedToCollector(position: Int,extraCages:Int,extraKg:Float)
    fun payOut(indexLst:ArrayList<Int>)
    fun fillWithDummyData()
//    fun clearAllResources():Void
//    fun generateActionReport() for logging user activity
}