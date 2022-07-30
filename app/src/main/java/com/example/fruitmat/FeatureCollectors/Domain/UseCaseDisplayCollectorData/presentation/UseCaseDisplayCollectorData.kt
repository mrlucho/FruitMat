package com.example.fruitmat.FeatureCollectors.Domain.UseCaseDisplayCollectorData.presentation

import android.app.AlertDialog

interface UseCaseDisplayCollectorData {
    fun openDialogBox(position: Int): AlertDialog
    fun trigger(position:Int)
}