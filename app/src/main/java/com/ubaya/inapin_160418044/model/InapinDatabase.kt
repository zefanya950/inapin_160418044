package com.ubaya.inapin_160418044.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Hotel::class,HotelBook::class,Notification::class,User::class),version = 2)
abstract class InapinDatabase:RoomDatabase() {
    abstract fun hotelDao():HotelDao
    abstract fun hotelBookDao():HotelBookDao
    abstract fun NotificationDao():NotificationDao
    abstract fun UserDao():UserDao

    companion object{
        @Volatile private var instance: InapinDatabase ?= null
        private val LOCK = Any()

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,InapinDatabase::class.java,"inapindb")
                .build()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }
    }
}