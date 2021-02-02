package com.vikination.workmanagersampleproject

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class PeriodicWorker(private val context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams) {

    override fun doWork(): Result {
        Utils.showNotification(context, "This is Periodic Worker Notification")
        return Result.success()
    }
}