package com.example.projek

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.projek.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(binding.root)
            replaceFragment(HomeFragment())
            binding.bottomNavigationView.setOnItemSelectedListener {
                when(it.itemId){
                    R.id.home ->
                        replaceFragment(HomeFragment())
                    R.id.grafik ->
                        replaceFragment(GrafikFragment())
                    R.id.kosong ->
                        replaceFragment(ListFragment())
                    R.id.person ->
                        replaceFragment(PresonFragment())
                    R.id.settings ->
                        replaceFragment(SettingFragment())

                    else ->{

                    }
                }
                true
            }
    }

    private fun replaceFragment(home: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.activity_main_nav_host_fragment,home)
        fragmentTransaction.commit()
    }

}