package com.desire.figmadatabaseapi.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.desire.figmadatabaseapi.R
import com.desire.figmadatabaseapi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}