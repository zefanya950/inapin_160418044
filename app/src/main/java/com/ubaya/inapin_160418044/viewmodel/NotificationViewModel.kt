package com.ubaya.inapin_160418044.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ubaya.inapin_160418044.model.Notification

class NotificationViewModel:ViewModel() {
    val notificationsLD = MutableLiveData<List<Notification>>()
    val loadingErrorLD = MutableLiveData<Boolean>()
    val loadingDoneLD = MutableLiveData<Boolean>()

    fun refresh(){
        val notif1 = Notification("Congratulation on your first book !","System •","2 minutes ago")
        val notif2 = Notification("You are verified","System •","5 minutes ago")
        val notif3 = Notification("You need to verify your email","System •","10 minutes ago")

        notificationsLD.value = arrayListOf<Notification>(notif1,notif2,notif3)
        loadingErrorLD.value = false
        loadingDoneLD.value = true
    }
}