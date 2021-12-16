package com.ubaya.inapin_160418044.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.ubaya.inapin_160418044.model.User
import com.ubaya.inapin_160418044.util.buildDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class UserViewModel(application: Application): AndroidViewModel(application), CoroutineScope {
    val usersLd = MutableLiveData<List<User>>()
    val user = MutableLiveData<User>()
    val profile = MutableLiveData<User>()
    val loadingErrorLD = MutableLiveData<Boolean>()
    val loadingDoneLD = MutableLiveData<Boolean>()

    private var job = Job()

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    fun fetch(username:String,password:String){
        launch{
            val db = buildDB(getApplication())
            user.value = db.UserDao().selectUser(username,password)
        }
    }

    fun updateOnline(username: String){
        launch{
            val db = buildDB(getApplication())
            db.UserDao().updateOnline(username)
        }
    }

    fun updateOffline(username: String){
        launch{
            val db = buildDB(getApplication())
            db.UserDao().updateOffline(username)
        }
    }

    fun selectUser(userId: Int){
        launch {
            val db = buildDB(getApplication())
            user.value= db.UserDao().selectUserDetail(userId)
        }
    }

    fun updateUser(name:String,username: String,password: String,userId: Int){
        launch {
            val db = buildDB(getApplication())
            db.UserDao().update(name,username,password,userId)
        }
    }

    fun refresh(){
        loadingErrorLD.value = false
        loadingDoneLD.value = true
        launch{
            val db = buildDB(getApplication())
            profile.value = db.UserDao().selectOnlineUser()
        }
    }

    fun addUser(user: User){
        launch {
            val db = buildDB(getApplication())
            db.UserDao().insertUser(user)
        }
    }
}