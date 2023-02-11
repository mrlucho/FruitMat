package com.example.fruitmat.FeatureCollectors.Data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class AdditionsHistory(
    @PrimaryKey
    val id:Int,
    val addCages:Int,
    val addKg:Float,
    val name:String)
