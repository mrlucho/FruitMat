package com.example.fruitmat.FeatureCollectors.Data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime
@Entity
data class CollectorToDB(
@PrimaryKey(autoGenerate = false)
val id:Int,
val name:String,

var cages:Int,
var kg:Float,
val startTime: String,
var endTime: String,
var paycheck:Float,
var endOfWork:Boolean=false,
)
