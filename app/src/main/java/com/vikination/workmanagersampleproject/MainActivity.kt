package com.vikination.workmanagersampleproject

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

        // Constraint Builder
        val constrains = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.UNMETERED)
            .build()

        // work request
        val myWorkDelayRequest = OneTimeWorkRequestBuilder<MyWorkerOneTime>()
            .setInitialDelay(5,TimeUnit.SECONDS)
            .setConstraints(constrains) // add constraints to worker
            .setBackoffCriteria(
                BackoffPolicy.LINEAR,
                OneTimeWorkRequest.MIN_BACKOFF_MILLIS,
                TimeUnit.SECONDS)
            .build()

        // execute worker
        WorkManager.getInstance(this)
            .enqueue(myWorkDelayRequest)
    }

}