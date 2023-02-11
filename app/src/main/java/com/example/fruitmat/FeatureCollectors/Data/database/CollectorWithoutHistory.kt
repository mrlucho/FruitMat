package com.example.fruitmat.FeatureCollectors.Data.database//package com.example.fruitmat.FeatureCollectors.Data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

//@Entity
data class CollectorWithoutHistory(
//    @PrimaryKey(autoGenerate = false)
    val name:String,

    var cages:Int,
    var kg:Float,
    val startTime: LocalDateTime,
    var endTime: LocalDateTime,
    var paycheck:Float,
    var endOfWork:Boolean=false,
)
