package com.work.workmanager

import android.content.Context
import android.util.Log
import androidx.work.*
import java.util.concurrent.TimeUnit

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
            Log.e(WORK_NAME, "DoWork")

            val constraints = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build()

            val oneTimeWorkRequest = OneTimeWorkRequestBuilder<Worker>().
                setInitialDelay(getOneDayIntervalTime(), TimeUnit.MILLISECONDS).
                setConstraints(constraints).build()

            WorkManager.getInstance(applicationContext).enqueueUniqueWork(WORK_NAME, ExistingWorkPolicy.REPLACE, oneTimeWorkRequest)

        }catch (e: Exception){
            Result.retry()
        }

        return Result.success()
    }

}