package com.vikination.workmanagersampleproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.vikination.workmanagersampleproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding :ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}