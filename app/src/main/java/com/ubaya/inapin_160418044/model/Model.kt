package com.ubaya.inapin_160418044.model

data class Hotel(
    val hotelName:String?,
    val hotelAddress:String?,
    val hotelPrice:String?,
    val hotelPhone:String?,
    val photoUrl:String?,
)

data class HotelBook(
    val hotelName:String?,
    val hotelAddress:String?,
    val photoUrl:String?,
    val dateBook:String?
)

data class Notification(
    val title:String?,
    val type:String?,
    val time:String?
)