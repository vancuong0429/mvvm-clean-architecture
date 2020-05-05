package com.minor.mvvm_clean_architecture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.minor.mvvm_clean_architecture.ui.HomeFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().add(R.id.frameMain, HomeFragment()).commit()
    }
}
