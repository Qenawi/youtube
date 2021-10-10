package com.qm.cleanmodule.util

import kotlinx.coroutines.*
import timber.log.Timber

/**
 * Created by MahmoudAyman on 7/15/2020.
 **/


object KtCoroutine {

    fun delayJob(delayInSeconds: Long, callBack: () -> Unit): Job {
        return GlobalScope.launch {
            delay(delayInSeconds * 1000)
            callBack()
        }
    }

    fun repeatJob(interval: Int, action: (Int) -> Unit): Job {
        return GlobalScope.launch {
            repeat(interval, action)
        }
    }
}