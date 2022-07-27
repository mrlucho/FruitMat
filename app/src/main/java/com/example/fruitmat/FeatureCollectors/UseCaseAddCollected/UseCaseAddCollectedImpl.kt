package com.example.fruitmat.FeatureCollectors.UseCaseAddCollected

import android.app.AlertDialog
import android.content.Context
import android.text.method.CharacterPickerDialog
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.example.fruitmat.FeatureCollectors.DomainAndData.Manager.CollectorsManagerImpl
import com.example.fruitmat.FeatureCollectors.presentation.RcAdapter
import com.example.fruitmat.R

class UseCaseAddCollectedImpl(val managerImpl: CollectorsManagerImpl,val context: Context?,val holder:RcAdapter.ReviewHolder):UseCaseAddCollected {
    private lateinit var mDialogView: View
    fun openDialogBox():AlertDialog{
        mDialogView = LayoutInflater.from(context).inflate(R.layout.add_collected,null)
        val builder = AlertDialog.Builder(context)
            .setView(mDialogView)
            .setTitle("col")
        return  builder.show()
    }

    fun trigger(position:Int){
        val mDialog = openDialogBox()
        val cages = mDialogView.findViewById<EditText>(R.id.etGiveCages)
        val kg = mDialogView.findViewById<EditText>(R.id.etGiveKg)
        val btn = mDialogView.findViewById<Button>(R.id.btnApplyAdding)
        btn.setOnClickListener {
            managerImpl.addHarvestedToCollector(position,cages.text.toString().toInt(),kg.text.toString().toFloat())
            holder.tvcages.text = managerImpl.getCollector(position).cages.toString()
            holder.tvKg.text = managerImpl.getCollector(position).kilograms.toString()
            mDialog.dismiss()
        }
    }
    fun updateRecAdapter(recyclerView:RecyclerView){
//        create new adapter with bigger Collectors lst
        val adapter = RcAdapter(managerImpl,context)
        recyclerView.adapter = adapter
    }
}
