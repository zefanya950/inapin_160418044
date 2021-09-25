package com.ubaya.inapin_160418044.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ubaya.inapin_160418044.model.Hotel

class ListViewModel:ViewModel() {
    val hotelsLD = MutableLiveData<List<Hotel>>()
    val loadingErrorLD = MutableLiveData<Boolean>()
    val loadingDoneLD = MutableLiveData<Boolean>()

    fun refresh(){
        val hotel1 = Hotel("Myrlene","Di Loreto","$168.38","3839633326","http://dummyimage.com/100x75.png/cc0000/ffffff")
        val hotel2 = Hotel("Cassandry","Victoria","$187.69","1708790073","http://dummyimage.com/100x75.png/5fa2dd/ffffff")
        val hotel3 = Hotel("Fransisco","La Follette","$99.45","9246738382","http://dummyimage.com/100x75.png/dddddd/000000")
        val hotel4 = Hotel("Anatole","Park Meadow","$90.12","4136254396","http://dummyimage.com/100x75.png/ff4444/ffffff")
        val hotel5 = Hotel("Westbrook","5th Avenue","$75.23","1308545179","http://dummyimage.com/100x75.png/dddddd/000000")

        hotelsLD.value = arrayListOf<Hotel>(hotel1,hotel2,hotel3,hotel4,hotel5)
        loadingErrorLD.value = false
        loadingDoneLD.value = true
    }
}