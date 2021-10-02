package com.ubaya.inapin_160418044.view.authentication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.google.android.material.snackbar.Snackbar
import com.ubaya.inapin_160418044.R
import kotlinx.android.synthetic.main.fragment_register.*

class RegisterFragment : Fragment() {
   override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnRegist.setOnClickListener {
            val snackbar = Snackbar.make(view, "Register Successful",
                Snackbar.LENGTH_LONG).setAction("Action", null)
            snackbar.show()
            val action = RegisterFragmentDirections.actionToLogin()
            Navigation.findNavController(it).navigate(action)
        }
    }

}