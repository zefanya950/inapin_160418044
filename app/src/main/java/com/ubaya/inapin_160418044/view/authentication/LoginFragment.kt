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
import com.ubaya.inapin_160418044.databinding.FragmentLoginBinding
import com.ubaya.inapin_160418044.databinding.FragmentRegisterBinding
import com.ubaya.inapin_160418044.view.GoRegisterButtonClickListener
import com.ubaya.inapin_160418044.view.LoginButtonClickListener
import com.ubaya.inapin_160418044.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment : Fragment(),LoginButtonClickListener,GoRegisterButtonClickListener {
    private lateinit var viewModel: UserViewModel
    private lateinit var dataBinding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate<FragmentLoginBinding>(inflater,R.layout.fragment_login,container,false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        dataBinding.listener = this
        dataBinding.goRegistListener = this
    }

    override fun onLoginButtonClickListener(v: View) {
        viewModel.fetch(txtUsername.text.toString(),txtPassword.text.toString())
        if(viewModel.user.value?.username==txtUsername.text.toString()){
            viewModel.updateOnline(txtUsername.text.toString())
            val snackbar = Snackbar.make(v, "Login Successful",
                Snackbar.LENGTH_LONG).setAction("Action", null)
            snackbar.show()
            val action = LoginFragmentDirections.actionHotelList()
            Navigation.findNavController(v).navigate(action)
        }
        else
        {
            val snackbar = Snackbar.make(v, "Login Failed",
                Snackbar.LENGTH_LONG).setAction("Action", null)
            snackbar.show()
        }
    }

    override fun onGoRegisterButtonClick(v: View) {
        val action = LoginFragmentDirections.actionRegister()
            Navigation.findNavController(v).navigate(action)
    }

}