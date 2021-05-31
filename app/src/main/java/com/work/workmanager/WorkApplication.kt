package com.work.workmanager

import android.app.Application
import android.os.Build
import androidx.work.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

/**
 * WorkManager
 * Class: WorkApplication
 * Created by pyg10.
 * Created On 2021-05-30.
 * Description:
 */
class WorkApplication : Application() {

    private val backgroundCoroutineScope = CoroutineScope(Dispatchers.Default)

    override fun onCreate() {
        super.onCreate()
        delayCreateWork()
    }

    private fun delayCreateWork(){
        backgroundCoroutineScope.launch {
            createWorkManager()
        }
    }

    private fun createWorkManager(){
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.UNMETERED)
            .setRequiresBatteryNotLow(true)
            .setRequiresCharging(true)
            .setRequiresStorageNotLow(true)
            .build()

        val oneTimeWorkRequest = OneTimeWorkRequestBuilder<Worker>().
            setConstraints(constraints).build()

        WorkManager.getInstance(applicationContext).enqueueUniqueWork(Worker.WORK_NAME, ExistingWorkPolicy.KEEP, oneTimeWorkRequest)
    }
}