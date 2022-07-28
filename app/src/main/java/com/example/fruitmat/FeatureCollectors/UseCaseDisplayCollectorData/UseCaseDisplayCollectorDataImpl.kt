package com.example.fruitmat.FeatureCollectors.UseCaseDisplayCollectorData

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fruitmat.FeatureCollectors.Domain.Manager.CollectorsManagerImpl
import com.example.fruitmat.FeatureCollectors.presentation.HistoryRecAdapter
import com.example.fruitmat.FeatureCollectors.presentation.RcAdapter
import com.example.fruitmat.R
import java.lang.Exception

class UseCaseDisplayCollectorDataImpl(val managerImpl: CollectorsManagerImpl, val context: Context?, val holder:RcAdapter.ReviewHolder):UseCaseDisplayCollectorData {
    private lateinit var mDialogView: View
    override fun openDialogBox(position: Int):AlertDialog{
        mDialogView = LayoutInflater.from(context).inflate(R.layout.add_collected,null)
        val builder = AlertDialog.Builder(context)
            .setView(mDialogView)
            .setTitle(managerImpl.getCollector(position).collectorDto.name)
            .setCancelable(true)
        return  builder.show()
    }

    override fun trigger(position:Int){
        val mDialog = openDialogBox(position)
        val cages = mDialogView.findViewById<EditText>(R.id.etGiveCages)
        val kg = mDialogView.findViewById<EditText>(R.id.etGiveKg)
        val btn = mDialogView.findViewById<Button>(R.id.btnApplyAdding)
        val actualCases = mDialogView.findViewById<TextView>(R.id.tvCurrentCages)
        val actualKg = mDialogView.findViewById<TextView>(R.id.tvCurrentKg)
        mDialogView.findViewById<Button>(R.id.btnClose).setOnClickListener {
            mDialog.dismiss()
        }


        actualCases.text = managerImpl.getCollector(position).collectorDto.cages.toString()
        actualKg.text = managerImpl.getCollector(position).collectorDto.kilograms.toString()
        val recyclerView = mDialogView.findViewById<RecyclerView>(R.id.recCollectorHistory)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = HistoryRecAdapter(managerImpl.getCollector(position).additionsHistoryLst)

//        apply btn
        btn.setOnClickListener {
            val numCages:Int = try {
                cages.text.toString().toInt()
            } catch (e :Exception){
                0
            }
            val numKg:Float = try {
                kg.text.toString().toFloat()
            } catch (e :Exception){
                0f
            }
            if(numCages != 0 || numKg != 0f) {
                managerImpl.addHarvestedToCollector(position, numCages, numKg)
                holder.tvcages.text =
                    managerImpl.getCollector(position).collectorDto.cages.toString()
                holder.tvKg.text =
                    managerImpl.getCollector(position).collectorDto.kilograms.toString()
            }
        }
    }
}
