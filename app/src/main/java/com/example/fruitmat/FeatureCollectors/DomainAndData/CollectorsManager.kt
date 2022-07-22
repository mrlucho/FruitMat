package com.example.fruitmat.FeatureCollectors.DomainAndData

interface CollectorsManager {
    fun getCollectorsAsArrayList():ArrayList<CollectorDto>
    fun getCollector(position:Int): CollectorDto
    fun addCollector(name: String)
    fun addHarvestedToCollector(position: Int,extraCages:Int,extraKg:Float)
//    fun clearAllResources():Void
}