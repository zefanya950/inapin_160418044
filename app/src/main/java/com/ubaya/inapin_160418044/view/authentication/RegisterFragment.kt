package com.ubaya.inapin_160418044.view.authentication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.google.android.material.snackbar.Snackbar
import com.ubaya.inapin_160418044.R
import com.ubaya.inapin_160418044.databinding.FragmentHotelDetailBinding
import com.ubaya.inapin_160418044.databinding.FragmentRegisterBinding
import com.ubaya.inapin_160418044.model.User
import com.ubaya.inapin_160418044.view.RegisterButtonClickListener
import com.ubaya.inapin_160418044.view.hotels.HotelDetailFragmentArgs
import com.ubaya.inapin_160418044.viewmodel.DetailHotelViewModel
import com.ubaya.inapin_160418044.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_register.*

class RegisterFragment : Fragment(),RegisterButtonClickListener {

    private lateinit var viewModel: UserViewModel
    private lateinit var dataBinding: FragmentRegisterBinding

   override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       dataBinding = DataBindingUtil.inflate<FragmentRegisterBinding>(inflater,R.layout.fragment_register,container,false)
       return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        dataBinding.listener = this

    }

    override fun onRegisterButtonClick(v: View) {
        var user = User(txtName.text.toString(),txtUsername.text.toString(),txtPassword.text.toString(),0)
        viewModel.addUser(user)
        val snackbar = Snackbar.make(v, "Register Successful",
            Snackbar.LENGTH_LONG).setAction("Action", null)
        snackbar.show()
        val action = RegisterFragmentDirections.actionToLogin()
        Navigation.findNavController(v).navigate(action)
    }

}