package com.example.fruitmat

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.fruitmat.FeatureCollectors.DomainAndData.Manager.CollectorsManagerImpl
import com.example.fruitmat.FeatureCollectors.presentation.Profile
import com.example.fruitmat.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var manager = CollectorsManagerImpl(ArrayList())
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Home())


        binding.bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId){

                R.id.home -> replaceFragment(Home())
                R.id.profile -> replaceFragment(Profile(manager))
                R.id.settings -> replaceFragment(Settings())

                else ->{



                }

            }

            true

        }


    }

    private fun replaceFragment(fragment : Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()


    }
}