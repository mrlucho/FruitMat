package com.example.fruitmat.FeatureCollectors.DomainAndData

import com.example.fruitmat.common.constants.Consts.cageCapacity

data class CollectorDto(val name: String,var cages:Int,var kilograms:Float){
    fun validate(){
        if (kilograms >= cageCapacity){
            val extraCages = kilograms.div(cageCapacity).toInt()
            kilograms -= extraCages * cageCapacity
            cages+=extraCages
        }
    }
    fun add(fullCages:Int,kilos:Float){
        cages += fullCages
        kilograms += kilos
        validate()
    }
}
