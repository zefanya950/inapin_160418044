package com.ubaya.inapin_160418044.view.hotels

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ubaya.inapin_160418044.R
import com.ubaya.inapin_160418044.util.loadImage
import kotlinx.android.synthetic.main.fragment_hotel_detail.*
import kotlinx.android.synthetic.main.fragment_hotel_detail.view.*

class HotelDetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hotel_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(arguments!=null){
            val hotelName = HotelDetailFragmentArgs.fromBundle(requireArguments()).hotelName
            val hotelAddress = HotelDetailFragmentArgs.fromBundle(requireArguments()).hotelAddress
            val hotelPhone = HotelDetailFragmentArgs.fromBundle(requireArguments()).hotelPhone
            val hotelPrice = HotelDetailFragmentArgs.fromBundle(requireArguments()).hotelPrice
            val urlPhoto = HotelDetailFragmentArgs.fromBundle(requireArguments()).urlPhoto
            txtHotelNameDetail.text = "$hotelName"
            txtHotelAddressDetail.text = "$hotelAddress"
            txtPhoneDetail.text = "You can call us at $hotelPhone"
            txtPriceDetail.text = "$hotelPrice /night"
            view.imageHotelDetail.loadImage(urlPhoto,view.progressBarDetail)

        }
    }

}