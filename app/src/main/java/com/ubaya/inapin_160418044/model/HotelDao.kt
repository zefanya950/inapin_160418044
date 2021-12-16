package com.ubaya.inapin_160418044.model

import androidx.room.*

@Dao
interface HotelDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHotel(vararg hotel: Hotel)

    @Query("SELECT * from hotel")
    suspend fun selectAllHotel():List<Hotel>

    @Query("SELECT * FROM hotel where hotelID =:id")
    suspend fun selectHotel(id:Int):Hotel

    @Query("UPDATE hotel SET hotelName=:hotelName, hotelAddress=:hotelAddress,hotelPrice=:hotelPrice, hotelPhone=:hotelPhone, photoUrl=:photoUrl WHERE hotelId=:uuid")
    suspend fun update(hotelName:String,hotelAddress:String,hotelPrice:String,hotelPhone:String,photoUrl:String,uuid:Int)

    @Delete
    suspend fun deleteHotel(hotel: Hotel)
}