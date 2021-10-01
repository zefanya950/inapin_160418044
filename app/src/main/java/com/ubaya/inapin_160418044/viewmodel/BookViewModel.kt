package com.ubaya.inapin_160418044.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ubaya.inapin_160418044.model.HotelBook

class BookViewModel:ViewModel() {
    val booksLD = MutableLiveData<List<HotelBook>>()
    val loadingErrorLD = MutableLiveData<Boolean>()
    val loadingDoneLD = MutableLiveData<Boolean>()

    fun refresh(){
        val hotelbook1 = HotelBook("Myrlene","Di Loreto","http://dummyimage.com/100x75.png/cc0000/ffffff","21-10-2021")
        val hotelbook2 = HotelBook("Fransisco","La Follette","http://dummyimage.com/100x75.png/dddddd/000000","25-10-2021")

        booksLD.value = arrayListOf<HotelBook>(hotelbook1,hotelbook2)
        loadingErrorLD.value = false
        loadingDoneLD.value = true
    }
}