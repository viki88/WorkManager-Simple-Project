package com.vikination.workmanagersampleproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.workDataOf
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
            startOneTimeWorkWithInputData()
        }
    }

    private fun startOneTimeWorkWithInputData(){
        val showMessageWorkerRequest = OneTimeWorkRequestBuilder<ShowNotifMessageWorker>()
            .setInitialDelay(3, TimeUnit.SECONDS)
            .setInputData(workDataOf(ShowNotifMessageWorker.KEY_MESSAGE to "This is message from input data"))
            .build()

        WorkManager.getInstance(this).enqueue(showMessageWorkerRequest)

    }

}