package com.example.fruitmat.FeatureCollectors.Domain.UseCaseDisplayCollectorsData
import com.example.fruitmat.FeatureCollectors.Domain.Manager.CollectorsManagerImpl
import com.example.fruitmat.FeatureCollectors.Domain.UseCaseDisplayCollectorData.domain.UseCaseCollectorDataHelper
import org.junit.Test
import junit.framework.TestCase.assertEquals
class usecase {
    @Test
    fun paymentString1(){
        val manager = CollectorsManagerImpl(ArrayList())
        manager.addCollector("someone")
        val use = UseCaseCollectorDataHelper()
        assertEquals("(0 + 0.0) * 2 = 0.0",use.paymentString(manager.getCollector(0)))
    }
    @Test
    fun paymentString2(){
        val manager = CollectorsManagerImpl(ArrayList())
        manager.addCollector("someone")
        manager.addHarvestedToCollector(0,1,2.5f)
        val use = UseCaseCollectorDataHelper()
        assertEquals("(5 + 2.5) * 2 = 15.0",use.paymentString(manager.getCollector(0)))
    }

}