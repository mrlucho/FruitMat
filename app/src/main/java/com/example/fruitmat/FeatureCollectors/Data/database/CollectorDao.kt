package com.example.fruitmat.FeatureCollectors.Data.database

import androidx.room.*
import com.example.fruitmat.FeatureCollectors.Data.database.entities.AdditionsHistory
import com.example.fruitmat.FeatureCollectors.Data.database.entities.CollectorToDB
//import com.example.fruitmat.FeatureCollectors.Data.database.entities.com.example.fruitmat.FeatureCollectors.Data.database.CollectorWithoutHistory
import com.example.fruitmat.FeatureCollectors.Data.database.entities.relations.CollectorAndAdditions

@Dao
abstract interface CollectorDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHistory(additionsHistory: AdditionsHistory)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCollector(collectorToDB: CollectorToDB)

    @Transaction
    @Query("SELECT * FROM CollectorToDB")
    suspend fun getAllCollectors() : List<CollectorToDB>

    @Transaction
    @Query("SELECT * FROM CollectorToDB WHERE name = :name")
    suspend fun getCollector(name: String) :List<CollectorAndAdditions>
}