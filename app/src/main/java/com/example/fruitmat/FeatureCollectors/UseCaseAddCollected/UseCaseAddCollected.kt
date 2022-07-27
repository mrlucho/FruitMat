package com.example.fruitmat.FeatureCollectors.UseCaseAddCollected

import android.app.AlertDialog

interface UseCaseAddCollected {
    fun openDialogBox(): AlertDialog
    fun trigger(position:Int)
}