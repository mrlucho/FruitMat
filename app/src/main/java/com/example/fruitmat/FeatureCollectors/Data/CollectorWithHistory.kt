package com.example.fruitmat.FeatureCollectors.Data

import com.example.fruitmat.FeatureCollectors.Data.AdditionsHistory
import java.time.LocalDateTime

data class CollectorWithHistory(val name:String,
                                var cages:Int,
                                var kg:Float,
                                val startTime: LocalDateTime,
                                var endTime: LocalDateTime,
                                var paycheck:Float,
                                var endOfWork:Boolean=false,
                                var additionsHistoryLst :ArrayList<AdditionsHistory> = ArrayList())
