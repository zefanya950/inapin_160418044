package com.ubaya.inapin_160418044.view

import android.view.View
import com.ubaya.inapin_160418044.model.Hotel
import com.ubaya.inapin_160418044.model.User

interface DetailHotelClickListener{
    fun onDetailHotelClick(v: View)
}

interface ButtonBookHotelClickListener{
    fun onButtonBookHotelClick(v: View)
}

interface RegisterButtonClickListener{
    fun onRegisterButtonClick(v: View)
}

interface LoginButtonClickListener{
    fun onLoginButtonClickListener(v: View)
}

interface GoRegisterButtonClickListener{
    fun onGoRegisterButtonClick(v: View)
}

interface DetailUserClickListener{
    fun onDetailUserClick(v: View)
}

interface UserSaveChangesClick{
    fun onUserSaveChangesClick(v: View,obj: User)
}

interface LogoutButtonClickListener{
    fun onLogoutButtonClick(v: View)
}