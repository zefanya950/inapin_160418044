package com.ubaya.inapin_160418044.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ubaya.inapin_160418044.model.Hotel

class ListViewModel:ViewModel() {
    val hotelsLD = MutableLiveData<List<Hotel>>()
    val loadingErrorLD = MutableLiveData<Boolean>()
    val loadingDoneLD = MutableLiveData<Boolean>()

    fun refresh(){
        val hotel1 = Hotel("JW Marriott","Surabaya","Rp.500.000","3839633326","https://lh5.googleusercontent.com/p/AF1QipMHmcuqWuRiYC_IG4aCZfRDwxiVDBBQUii1BHT6=w325-h487-k-no")
        val hotel2 = Hotel("Amaris Hotel","Ponorogo","Rp.200.000","1708790073","https://lh3.googleusercontent.com/p/AF1QipMkTttyeIl5CRZ2qSErZX6mSJcbY2fdFmnQbhJ1=w296-h202-n-k-rw-no-v1")
        val hotel3 = Hotel("Hotel Indonesia","Jakarta","Rp.1.000.000","9246738382","https://www.wowkeren.com/display/images/photo/2020/01/20/00292949_1.jpg")
        val hotel4 = Hotel("Novotel Semarang","Semarang","Rp.750.000","4136254396","https://lh4.googleusercontent.com/proxy/11sE4GwxBFldSH2L75clPzKf9tpKTKnLTRZBk5Xc_qI5uLSV83asW4fnVHTZyzJJJPgo98QY195NV2JUQ9DRd84bF7LytrRGYBevE0IIWySwQqQnEg1-x1PgB5E9LECxhsZwvSR4udyODdC7Z7KaZK4gUwXo854=w325-h178-k-no")
        val hotel5 = Hotel("Aryaduta Hotel Bandung","Bandung","Rp.1.250.000","1308545179","https://lh5.googleusercontent.com/p/AF1QipPBJ0z4S1yoQH7nRzzzgcn_8TikWYRReMMl18q-=w325-h216-k-no")

        hotelsLD.value = arrayListOf<Hotel>(hotel1,hotel2,hotel3,hotel4,hotel5)
        loadingErrorLD.value = false
        loadingDoneLD.value = true
    }
}