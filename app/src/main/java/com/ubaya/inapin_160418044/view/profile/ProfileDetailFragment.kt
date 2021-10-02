package com.ubaya.inapin_160418044.view.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.snackbar.Snackbar
import com.ubaya.inapin_160418044.R
import com.ubaya.inapin_160418044.util.loadImage
import kotlinx.android.synthetic.main.fragment_profile_detail.*
import kotlinx.android.synthetic.main.fragment_profile_detail.view.*


class ProfileDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.imageProfilePict.loadImage("https://cdn.myanimelist.net/r/360x360/images/characters/2/284121.jpg?s=5b0448ce14c283b38583b9ceaf86ae73",view.progresBarProfileDetail)
        view.imageProfileBackground.loadImage("https://www.koalahero.com/wp-content/uploads/2020/03/0.IDR0038.jpg",view.progresBarProfileDetail)
        btnUpdate.setOnClickListener {
            val snackbar = Snackbar.make(view, "Profile Updated",
                Snackbar.LENGTH_LONG).setAction("Action", null)
            snackbar.show()
        }
    }

}