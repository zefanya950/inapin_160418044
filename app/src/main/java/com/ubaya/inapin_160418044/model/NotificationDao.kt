package com.ubaya.inapin_160418044.model

import androidx.room.*

@Dao
interface NotificationDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNotification(vararg notification: Notification)

    @Query("SELECT * from notification")
    suspend fun selectAllNotification():List<Notification>

    @Query("SELECT * FROM notification where notifId =:id")
    suspend fun selectNotification(id:Int):Notification

    @Query("UPDATE notification SET title=:title, type=:type, time=:time WHERE notifId=:notifId")
    suspend fun update(title:String,type:String,time:String,notifId:Int)

    @Delete
    suspend fun deleteNotification(notification: Notification)
}