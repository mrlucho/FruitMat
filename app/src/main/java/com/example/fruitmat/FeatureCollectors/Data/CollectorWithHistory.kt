package com.example.fruitmat.FeatureCollectors.Data

import com.example.fruitmat.FeatureCollectors.Data.AdditionsHistory
import com.example.fruitmat.FeatureCollectors.Data.CollectorDto
import java.time.LocalDateTime

data class CollectorWithHistory(val collectorDto: CollectorDto,
                                val startTime: LocalDateTime,
                                var endTime: LocalDateTime,
                                var paycheck:Float,
                                var endOfWork:Boolean=false,
                                var additionsHistoryLst :ArrayList<AdditionsHistory> = ArrayList())
