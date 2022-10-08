package com.example.myapplicationpogoda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplicationpogoda.Fragment.MainFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager
            .beginTransaction().replace(R.id.planceHolder,MainFragment.newInstance())
            .commit()
    }
}