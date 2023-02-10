package com.example.fruitmat.FeatureCollectors.Data

import java.time.LocalDateTime

data class CollectorWithoutHistory(
    val name:String,
    var cages:Int,
    var kg:Float,
    val startTime: LocalDateTime,
    var endTime: LocalDateTime,
    var paycheck:Float,
    var endOfWork:Boolean=false,
)
