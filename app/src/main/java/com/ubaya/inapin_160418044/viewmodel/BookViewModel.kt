package com.ubaya.inapin_160418044.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ubaya.inapin_160418044.model.HotelBook

class BookViewModel:ViewModel() {
    val booksLD = MutableLiveData<List<HotelBook>>()
    val loadingErrorLD = MutableLiveData<Boolean>()
    val loadingDoneLD = MutableLiveData<Boolean>()

    fun refresh(){
        val hotelbook1 = HotelBook("JW Marriott","Surabaya","https://lh5.googleusercontent.com/p/AF1QipMHmcuqWuRiYC_IG4aCZfRDwxiVDBBQUii1BHT6=w325-h487-k-no","21-10-2021")
        val hotelbook2 = HotelBook("Novotel Semarang","Semarang","https://lh4.googleusercontent.com/proxy/11sE4GwxBFldSH2L75clPzKf9tpKTKnLTRZBk5Xc_qI5uLSV83asW4fnVHTZyzJJJPgo98QY195NV2JUQ9DRd84bF7LytrRGYBevE0IIWySwQqQnEg1-x1PgB5E9LECxhsZwvSR4udyODdC7Z7KaZK4gUwXo854=w325-h178-k-no","25-10-2021")

        booksLD.value = arrayListOf<HotelBook>(hotelbook1,hotelbook2)
        loadingErrorLD.value = false
        loadingDoneLD.value = true
    }
}