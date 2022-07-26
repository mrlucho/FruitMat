package com.example.fruitmat.FeatureCollectors.presentation

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fruitmat.R
import com.example.fruitmat.FeatureCollectors.DomainAndData.Manager.CollectorsManagerImpl
import com.example.fruitmat.FeatureCollectors.DomainAndData.UseCaseAddCollector.domain.UseCaseAddCollectorImpl
import com.example.fruitmat.MainActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Profile(val manager: CollectorsManagerImpl) : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var adapter: RcAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var floatingActionButton: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(context)

        recyclerView = view.findViewById(R.id.recollect)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = RcAdapter(manager.getCollectorsAsArrayList())
        recyclerView.adapter = adapter

        floatingActionButton = view.findViewById(R.id.fabAddCollector)



        floatingActionButton.setOnClickListener{
//            val useCase = UseCaseAddCollectorImpl()
//            useCase.updateRecAdapter(recyclerView,manager)
            val useCase = UseCaseAddCollectorImpl(manager,recyclerView,context)
//            val mDialogView = LayoutInflater.from(context).inflate(R.layout.add_collector_dialog,null)
            val mDialogView = useCase.popDialogView()

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
//                Toast.makeText(context,txt,Toast.LENGTH_LONG).show()
                manager.addCollector(txt)

                useCase.updateRecAdapter()
            }
            cancelBtn.setOnClickListener {
                mDialog.dismiss()
            }


            useCase.updateRecAdapter()
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         * reopen the fragment, use manager from main activity
         * @return A new instance of fragment Profile.
         */
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Profile(MainActivity().manager).apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}