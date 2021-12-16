package com.ubaya.inapin_160418044.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Hotel(
    @ColumnInfo(name = "hotelName")
    val hotelName:String?,
    @ColumnInfo(name = "hotelAddress")
    val hotelAddress:String?,
    @ColumnInfo(name = "hotelPrice")
    val hotelPrice:String?,
    @ColumnInfo(name = "hotelPhone")
    val hotelPhone:String?,
    @ColumnInfo(name = "photoUrl")
    val photoUrl:String?
){
    @PrimaryKey(autoGenerate = true)
    var hotelId:Int =0
}

@Entity
data class HotelBook(
    @ColumnInfo(name = "hotelName")
    val hotelName:String?,
    @ColumnInfo(name = "hotelAddress")
    val hotelAddress:String?,
    @ColumnInfo(name = "photoUrl")
    val photoUrl:String?,
    @ColumnInfo(name = "dateBook")
    val dateBook:String?
){
    @PrimaryKey(autoGenerate = true)
    var bookId:Int =0
}

@Entity
data class Notification(
    @ColumnInfo(name = "title")
    val title:String?,
    @ColumnInfo(name = "type")
    val type:String?,
    @ColumnInfo(name = "time")
    val time:String?
){
    @PrimaryKey(autoGenerate = true)
    var notifId:Int =0
}

@Entity
data class User(
    @ColumnInfo(name = "name")
    var name:String?,
    @ColumnInfo(name = "username")
    var username:String?,
    @ColumnInfo(name = "password")
    var password:String?,
    @ColumnInfo(name = "is_online")
    var is_online:Int?
){
    @PrimaryKey(autoGenerate = true)
    var userId:Int =0
}