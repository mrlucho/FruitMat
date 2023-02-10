package com.example.fruitmat.FeatureCollectors.Domain.Manager

import com.example.fruitmat.FeatureCollectors.Data.AdditionsHistory
import com.example.fruitmat.FeatureCollectors.Data.CollectorWithHistory
import com.example.fruitmat.common.constants.Constants
import java.time.LocalDateTime

class CollectorsManagerImpl(val mColleectorsLst:ArrayList<CollectorWithHistory>) : CollectorsManager {
    override fun getCollectorsAsArrayList(): ArrayList<CollectorWithHistory> {
        return mColleectorsLst
    }

    override fun getCollector(position: Int): CollectorWithHistory {
        return mColleectorsLst[position]
    }

    override fun addCollector(name: String) {
        mColleectorsLst.add(CollectorWithHistory(name,0,0f,
            LocalDateTime.now(),
            LocalDateTime.now(),0f))
    }

    override fun addHarvestedToCollector(position: Int, extraCages: Int, extraKg: Float) {
        /**
         * also updates worker history
         */
//        mColleectorsLst[position].collectorDto.add(extraCages,extraKg)
        mColleectorsLst[position].additionsHistoryLst.add(AdditionsHistory(extraCages,extraKg))
        add(mColleectorsLst[position],extraCages,extraKg)
//        validate(mColleectorsLst[position]) //already should be validated

    }
    private fun validate(collectorWithHistory: CollectorWithHistory){
        if (collectorWithHistory.kg >= Constants.cageCapacity){
            val extraCages = collectorWithHistory.kg.div(Constants.cageCapacity).toInt()
            collectorWithHistory.kg -= extraCages * Constants.cageCapacity
            collectorWithHistory.cages+=extraCages
        }
    }
    private fun add(collectorWithHistory: CollectorWithHistory, fullCages:Int, kilos:Float){
        collectorWithHistory.cages += fullCages
        collectorWithHistory.kg += kilos
        validate(collectorWithHistory)
    }

    override fun fillWithDummyData() {
        addCollector("someone")
        addCollector("someoneOther")
        addHarvestedToCollector(0,1,2.5f)
        addHarvestedToCollector(1,1,0.5f)
    }
}