package com.ubaya.inapin_160418044.view.profile

import android.opengl.Visibility
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.google.android.material.snackbar.Snackbar
import com.ubaya.inapin_160418044.R
import com.ubaya.inapin_160418044.databinding.FragmentLoginBinding
import com.ubaya.inapin_160418044.databinding.FragmentProfileBinding
import com.ubaya.inapin_160418044.util.loadImage
import com.ubaya.inapin_160418044.view.DetailUserClickListener
import com.ubaya.inapin_160418044.view.LogoutButtonClickListener
import com.ubaya.inapin_160418044.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_hotel_detail.*
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.fragment_profile.view.*

class ProfileFragment : Fragment(),DetailUserClickListener,LogoutButtonClickListener {

    private lateinit var viewModel: UserViewModel
    private lateinit var dataBinding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate<FragmentProfileBinding>(inflater,R.layout.fragment_profile,container,false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        dataBinding.listener = this
        dataBinding.logoutListener = this
        view.imageViewProfile.loadImage("https://cdn.myanimelist.net/r/360x360/images/characters/2/284121.jpg?s=5b0448ce14c283b38583b9ceaf86ae73",view.progressBarProfile)
        viewModel.refresh()
//        var nama = viewModel.profile.value?.name.toString()
//        txtNama.text = nama
        observeViewModel()
//        btnDetailProfile.setOnClickListener {
//            val action = ProfileFragmentDirections.actionProfileDetail()
//            Navigation.findNavController(it).navigate(action)
//        }
    }

    fun observeViewModel(){
        viewModel.profile.observe(viewLifecycleOwner, Observer {
            dataBinding.user = it
            if(viewModel.profile.value?.is_online==1){
                btnLogout.visibility = View.VISIBLE
                btnDetailProfile.visibility = View.VISIBLE
            }
            else{
                btnLogout.visibility = View.GONE
                btnDetailProfile.visibility = View.GONE
            }
        })
    }

    override fun onDetailUserClick(v: View) {
        val action = ProfileFragmentDirections.actionProfileDetail(v.tag.toString().toInt())
            Navigation.findNavController(v).navigate(action)
    }

    override fun onLogoutButtonClick(v: View) {
        viewModel.updateOffline(viewModel.profile.value?.username.toString())
        val snackbar = Snackbar.make(v, "Logout Successful",
            Snackbar.LENGTH_LONG).setAction("Action", null)
        snackbar.show()
    }

}