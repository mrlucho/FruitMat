package com.example.fruitmat.FeatureCollectors.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fruitmat.R
import com.example.fruitmat.FeatureCollectors.Domain.Manager.CollectorsManagerImpl
import com.example.fruitmat.FeatureCollectors.Domain.UseCaseAddCollector.UseCaseAddCollectorImpl
import com.example.fruitmat.MainActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Collectors(val manager: CollectorsManagerImpl) : Fragment() {
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
        recyclerView = view.findViewById(R.id.recollect)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)
        adapter = RcAdapter(manager,context)
        recyclerView.adapter = adapter

        floatingActionButton = view.findViewById(R.id.fabAddCollector)
        floatingActionButton.setOnClickListener{
            val useCase = UseCaseAddCollectorImpl(manager,recyclerView,context)
            useCase.trigger()

        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_collectors, container, false)
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
            Collectors(MainActivity().manager).apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}