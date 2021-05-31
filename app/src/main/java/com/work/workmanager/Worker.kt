package com.work.workmanager

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters

/**
 * WorkManager
 * Class: Worker
 * Created by pyg10.
 * Created On 2021-05-30.
 * Description:
 */
class Worker(appContext: Context, parameters: WorkerParameters) : CoroutineWorker(appContext, parameters) {

    companion object{
        const val WORK_NAME = "Notification Work"
    }

    override suspend fun doWork(): Result {

        try {

            //Work

        }catch (e: Exception){
            Result.retry()
        }

        return Result.success()
    }

}