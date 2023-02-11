package com.example.fruitmat

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.fruitmat.FeatureCollectors.Data.database.CollectorDao
import com.example.fruitmat.FeatureCollectors.Data.database.entities.AdditionsHistory
import com.example.fruitmat.FeatureCollectors.Data.database.entities.CollectorToDB
//import com.example.fruitmat.FeatureCollectors.Data.database.entities.com.example.fruitmat.FeatureCollectors.Data.database.CollectorWithoutHistory


@Database(
    entities = [
        CollectorToDB::class,
        AdditionsHistory::class
    ],
    version = 1, exportSchema = true
)
abstract class CollectorsDatabase : RoomDatabase() {

    abstract val collectorDao : CollectorDao

    companion object{
        @Volatile
        private var INSTANCE: CollectorsDatabase? = null

        fun getInstance(context: Context): CollectorsDatabase {
            synchronized(this){
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    CollectorsDatabase::class.java,
                    "collectors_db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }

}