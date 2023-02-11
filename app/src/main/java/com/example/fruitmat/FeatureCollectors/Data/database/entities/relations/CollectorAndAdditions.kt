package com.example.fruitmat.FeatureCollectors.Data.database.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.fruitmat.FeatureCollectors.Data.database.entities.AdditionsHistory
import com.example.fruitmat.FeatureCollectors.Data.database.entities.CollectorToDB
//import com.example.fruitmat.FeatureCollectors.Data.database.entities.com.example.fruitmat.FeatureCollectors.Data.database.CollectorWithoutHistory

data class CollectorAndAdditions(
    @Embedded val collector : CollectorToDB,
    @Relation(
        parentColumn = "name",
        entityColumn = "name"
    )
    val histories : List<AdditionsHistory>
)
