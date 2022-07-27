package com.example.fruitmat.FeatureCollectors.UseCaseAddCollected

import android.app.AlertDialog

interface UseCaseAddCollected {
    fun openDialogBox(position: Int): AlertDialog
    fun trigger(position:Int)
}