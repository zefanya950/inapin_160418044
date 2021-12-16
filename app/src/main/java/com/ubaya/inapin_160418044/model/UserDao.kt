package com.ubaya.inapin_160418044.model

import androidx.room.*

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(vararg user: User)

    @Query("SELECT * FROM user")
    suspend fun selectAllUser():List<User>

    @Query("SELECT * FROM user WHERE userId=:userId")
    suspend fun selectUserDetail(userId: Int):User

    @Query("SELECT * FROM user where username =:username AND password=:password")
    suspend fun selectUser(username:String,password: String):User

    @Query("SELECT * FROM user where is_online=1")
    suspend fun selectOnlineUser():User

    @Query("UPDATE user SET name=:name, username=:username, password=:password WHERE userId=:userId")
    suspend fun update(name:String,username:String,password:String,userId:Int)

    @Query("UPDATE user SET is_online=1 WHERE username=:username")
    suspend fun updateOnline(username: String)

    @Query("UPDATE user SET is_online=0 WHERE username=:username")
    suspend fun updateOffline(username: String)

    @Delete
    suspend fun deleteUser(user: User)
}