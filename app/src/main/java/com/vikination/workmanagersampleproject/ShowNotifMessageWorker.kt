package com.vikination.workmanagersampleproject

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class ShowNotifMessageWorker(var context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams) {

    companion object{
        const val KEY_MESSAGE = "MESSAGE"
    }

    override fun doWork(): Result {
        val message = inputData.getString(KEY_MESSAGE)
        Utils.showNotification(context, message?:"")
        return Result.success()
    }
}