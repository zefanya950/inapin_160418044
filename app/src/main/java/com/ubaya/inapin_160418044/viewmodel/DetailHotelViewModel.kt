package com.ubaya.inapin_160418044.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.ubaya.inapin_160418044.model.Hotel
import com.ubaya.inapin_160418044.model.HotelBook
import com.ubaya.inapin_160418044.model.Notification
import com.ubaya.inapin_160418044.util.buildDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class DetailHotelViewModel(application: Application):AndroidViewModel(application),CoroutineScope {
    private var job = Job()
    val hotelLD = MutableLiveData<Hotel>()

    fun fetch(hotelId:Int){
        launch {
            val db = buildDB(getApplication())
            hotelLD.value = db.hotelDao().selectHotel(hotelId)
        }
    }

    fun addBook(book: HotelBook){
        launch {
            val db = buildDB(getApplication())
            db.hotelBookDao().insertBook(book)
        }
    }

    fun addNotification(notification: Notification){
        launch {
            val db = buildDB(getApplication())
            db.NotificationDao().insertNotification(notification)
        }
    }

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main
}