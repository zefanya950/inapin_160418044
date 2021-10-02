package com.ubaya.inapin_160418044.view.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.ubaya.inapin_160418044.R
import com.ubaya.inapin_160418044.util.loadImage
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.fragment_profile.view.*

class ProfileFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.imageViewProfile.loadImage("https://cdn.myanimelist.net/r/360x360/images/characters/2/284121.jpg?s=5b0448ce14c283b38583b9ceaf86ae73",view.progressBarProfile)

        btnDetailProfile.setOnClickListener {
            val action = ProfileFragmentDirections.actionProfileDetail()
            Navigation.findNavController(it).navigate(action)
        }
    }

}