package com.example.fruitmat.FeatureCollectors.DomainAndData

class CollectorsManagerImpl(val mColleectorsLst:ArrayList<CollectorDto>) :CollectorsManager {
    override fun getCollectorsAsArrayList(): ArrayList<CollectorDto> {
        return mColleectorsLst
    }

    override fun getCollector(position: Int): CollectorDto {
        return mColleectorsLst[position]
    }

    override fun addCollector(name: String) {
        mColleectorsLst.add(CollectorDto(name,0,0f))
    }

    override fun addHarvestedToCollector(position: Int, extraCages: Int, extraKg: Float) {
        mColleectorsLst[position].add(extraCages,extraKg)
    }

    override fun payOut(indexLst: ArrayList<Int>) {
        if (indexLst.isEmpty()){
            throw Exception("passing empty list to payout method is forbidden")
        }
        else{
            val payments = ArrayList<Int>()

        }
    }

    override fun fillWithDummyData() {
        addCollector("someone")
        addCollector("someoneOther")
        addHarvestedToCollector(0,1,2.5f)
        addHarvestedToCollector(1,1,0.5f)
    }
}