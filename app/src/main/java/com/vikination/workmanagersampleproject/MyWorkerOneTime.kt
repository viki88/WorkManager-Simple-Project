package com.vikination.workmanagersampleproject

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyWorkerOneTime(private val context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams) {

    override fun doWork(): Result {
        Utils.showNotification(context, "This is one time worker notification")
        return Result.success()
    }
}