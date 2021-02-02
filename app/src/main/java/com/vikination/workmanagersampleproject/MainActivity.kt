package com.vikination.workmanagersampleproject

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.*
import com.vikination.workmanagersampleproject.databinding.ActivityMainBinding
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    lateinit var binding :ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // start worker button clicked
        binding.buttonStart.setOnClickListener {
            startScheduleOneTimeWork()
        }
    }

    private fun startScheduleOneTimeWork(){

        // work request
        val myWorkDelayRequest = OneTimeWorkRequestBuilder<MyWorkerOneTime>()
            .setInitialDelay(5,TimeUnit.SECONDS)
            .build()

        // execute worker
        WorkManager.getInstance(this)
            .enqueue(myWorkDelayRequest)
    }

}