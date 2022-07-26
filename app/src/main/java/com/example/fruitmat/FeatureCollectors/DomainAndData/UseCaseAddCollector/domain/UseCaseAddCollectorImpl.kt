package com.example.fruitmat.FeatureCollectors.DomainAndData.UseCaseAddCollector.domain

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.example.fruitmat.FeatureCollectors.DomainAndData.Manager.CollectorsManagerImpl
import com.example.fruitmat.FeatureCollectors.DomainAndData.UseCaseAddCollector.domain.UseCaseAddCollector
import com.example.fruitmat.FeatureCollectors.presentation.RcAdapter
import com.example.fruitmat.R


class UseCaseAddCollectorImpl(val managerImpl: CollectorsManagerImpl,val recyclerView: RecyclerView,val context: Context?)
    : UseCaseAddCollector {
    private lateinit var mDialogView:View

    override fun updateRecAdapter(){
        val adapter = RcAdapter(managerImpl.getCollectorsAsArrayList())
        recyclerView.adapter = adapter
    }
    override fun popDialogView() {
        mDialogView = LayoutInflater.from(context).inflate(R.layout.add_collector_dialog,null)

    }
    override fun trigger(){
        popDialogView()
        val builder = AlertDialog.Builder(context)
            .setView(mDialogView)
            .setTitle("EnterName")
        val mDialog = builder.show()

        val submitBtn = mDialogView.findViewById<Button>(R.id.submit)
        val cancelBtn = mDialogView.findViewById<Button>(R.id.cancel)
        val editText = mDialogView.findViewById<EditText>(R.id.etEnterCollectorsName)

        submitBtn.setOnClickListener {
            val txt = editText.text.toString()
            mDialog.dismiss()
            managerImpl.addCollector(txt)

            updateRecAdapter()
        }
        cancelBtn.setOnClickListener {
            mDialog.dismiss()
        }


        updateRecAdapter()
    }
}