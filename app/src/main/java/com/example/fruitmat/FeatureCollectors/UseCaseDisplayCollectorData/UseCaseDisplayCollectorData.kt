package com.example.fruitmat.FeatureCollectors.UseCaseDisplayCollectorData

import android.app.AlertDialog

interface UseCaseDisplayCollectorData {
    fun openDialogBox(position: Int): AlertDialog
    fun trigger(position:Int)
}