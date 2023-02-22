package com.example.fruitmat.FeatureCollectors.Data.database.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.fruitmat.FeatureCollectors.Data.database.entities.AdditionsHistory
import com.example.fruitmat.FeatureCollectors.Data.database.entities.CollectorToDB

data class CollectorWithHistoryDTO(
    @Embedded val collector : CollectorToDB,
    @Relation(
        parentColumn = "name",
        entityColumn = "name"
    )
    val histories : List<AdditionsHistory>
)
