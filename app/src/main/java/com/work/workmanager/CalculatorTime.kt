package com.work.workmanager

import java.util.*

/**
 * WorkManager
 * Class: CalculatorTime
 * Created by pyg10.
 * Created On 2021-06-01.
 * Description:
 */

fun getOneDayIntervalTime(): Long{

    val currentDate = Calendar.getInstance()
    val dueDate = Calendar.getInstance().apply {

        set(Calendar.HOUR_OF_DAY, 2)
        set(Calendar.MINUTE, 20)
        set(Calendar.SECOND, 0)

    }

    if (dueDate.before(currentDate))
        dueDate.add(Calendar.HOUR_OF_DAY, 24)


    return dueDate.timeInMillis - currentDate.timeInMillis
}

fun getOneMinIntervalTime(): Long{

    val currentDate = Calendar.getInstance()
    val dueDate = Calendar.getInstance().apply {
        add(Calendar.MINUTE, 1)
    }

    return dueDate.timeInMillis - currentDate.timeInMillis
}