package com.example.fruitmat

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.fruitmat.FeatureCollectors.Data.database.entities.CollectorToDB
//import com.example.fruitmat.FeatureCollectors.Data.database.entities.CollectorWithoutHistory
import com.example.fruitmat.FeatureCollectors.Domain.Manager.CollectorsManagerImpl
import com.example.fruitmat.FeatureCollectors.presentation.Collectors
import com.example.fruitmat.databinding.ActivityMainBinding
import kotlinx.coroutines.launch
import java.time.LocalDateTime

class MainActivity : AppCompatActivity() {
    val manager = CollectorsManagerImpl(ArrayList())
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Home())


        binding.bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId){

                R.id.home -> replaceFragment(Home())
                R.id.profile -> replaceFragment(Collectors(manager))
                R.id.settings -> replaceFragment(Settings())

                else ->{
                }
            }
            true
        }

        val dao = CollectorsDatabase.getInstance(this).collectorDao
        lifecycleScope.launch{
            dao.insertCollector(
                CollectorToDB(1,"jan",0,0f,
                LocalDateTime.now().toString(),
                LocalDateTime.now().toString(),0f,true)
            )
//            dao.insertCollector(
//                CollectorToDB("Michal",0,0f,
//                LocalDateTime.now().toString(),
//                LocalDateTime.now().toString(),0f)
//            )
        }
    }

    private fun replaceFragment(fragment : Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()


    }
}