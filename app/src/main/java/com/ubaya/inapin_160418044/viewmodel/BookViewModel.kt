package com.ubaya.inapin_160418044.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ubaya.inapin_160418044.model.Hotel
import com.ubaya.inapin_160418044.model.HotelBook
import com.ubaya.inapin_160418044.util.buildDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class BookViewModel(application: Application): AndroidViewModel(application), CoroutineScope {
    val booksLD = MutableLiveData<List<HotelBook>>()
    val loadingErrorLD = MutableLiveData<Boolean>()
    val loadingDoneLD = MutableLiveData<Boolean>()

    private var job = Job()

    fun refresh(){
        loadingErrorLD.value = false
        loadingDoneLD.value = true
        launch{
            val db = buildDB(getApplication())
            booksLD.value = db.hotelBookDao().selectAllBook()
        }
    }

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main
}