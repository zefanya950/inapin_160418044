package com.ubaya.inapin_160418044.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ubaya.inapin_160418044.model.Notification
import com.ubaya.inapin_160418044.util.buildDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class NotificationViewModel(application: Application): AndroidViewModel(application), CoroutineScope {
    val notificationsLD = MutableLiveData<List<Notification>>()
    val loadingErrorLD = MutableLiveData<Boolean>()
    val loadingDoneLD = MutableLiveData<Boolean>()

    private var job = Job()

    fun refresh(){
        loadingErrorLD.value = false
        loadingDoneLD.value = true
        launch{
            val db = buildDB(getApplication())
            notificationsLD.value = db.NotificationDao().selectAllNotification()
        }
    }

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main
}