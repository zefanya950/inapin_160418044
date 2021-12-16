package com.ubaya.inapin_160418044.view.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.ubaya.inapin_160418044.R
import com.ubaya.inapin_160418044.databinding.FragmentProfileBinding
import com.ubaya.inapin_160418044.databinding.FragmentProfileDetailBinding
import com.ubaya.inapin_160418044.model.User
import com.ubaya.inapin_160418044.util.loadImage
import com.ubaya.inapin_160418044.view.UserSaveChangesClick
import com.ubaya.inapin_160418044.view.hotels.HotelDetailFragmentArgs
import com.ubaya.inapin_160418044.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_profile_detail.*
import kotlinx.android.synthetic.main.fragment_profile_detail.view.*


class ProfileDetailFragment : Fragment(),UserSaveChangesClick {
    private lateinit var viewModel: UserViewModel
    private lateinit var dataBinding: FragmentProfileDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate<FragmentProfileDetailBinding>(inflater,R.layout.fragment_profile_detail,container,false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        val userId = ProfileDetailFragmentArgs.fromBundle(requireArguments()).userId
        viewModel.selectUser(userId)
        dataBinding.listener = this
        observeViewModel()
        view.imageProfilePict.loadImage("https://cdn.myanimelist.net/r/360x360/images/characters/2/284121.jpg?s=5b0448ce14c283b38583b9ceaf86ae73",view.progresBarProfileDetail)
        view.imageProfileBackground.loadImage("https://www.koalahero.com/wp-content/uploads/2020/03/0.IDR0038.jpg",view.progresBarProfileDetail)
//        btnUpdate.setOnClickListener {
//            val snackbar = Snackbar.make(view, "Profile Updated",
//                Snackbar.LENGTH_LONG).setAction("Action", null)
//            snackbar.show()
//        }
    }

    fun observeViewModel(){
        viewModel.user.observe(viewLifecycleOwner, Observer {
            dataBinding.user = it
        })
    }

    override fun onUserSaveChangesClick(v: View, obj: User) {
        viewModel.updateUser(obj.name.toString(),obj.username.toString(),obj.password.toString(),obj.userId)
        Toast.makeText(v.context, "User Updated", Toast.LENGTH_SHORT).show()
    }

}