package com.ubaya.inapin_160418044.model

import androidx.room.*

@Dao
interface HotelBookDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBook(vararg hotelbook: HotelBook)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHotel(vararg hotel: Hotel)

    @Query("SELECT * from hotelbook")
    suspend fun selectAllBook():List<HotelBook>

    @Query("SELECT * FROM hotelbook where bookId =:id")
    suspend fun selectBook(id:Int):HotelBook

    @Query("UPDATE hotelbook SET hotelName=:hotelName, hotelAddress=:hotelAddress, photoUrl=:photoUrl,dateBook=:dateBook WHERE bookId=:uuid")
    suspend fun update(hotelName:String,hotelAddress:String,photoUrl:String,dateBook:String,uuid:Int)

    @Delete
    suspend fun deleteBook(hotelbook: HotelBook)
}