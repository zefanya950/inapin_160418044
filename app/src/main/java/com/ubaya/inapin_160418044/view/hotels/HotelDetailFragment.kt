package com.ubaya.inapin_160418044.view.hotels

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.ubaya.inapin_160418044.R
import com.ubaya.inapin_160418044.databinding.FragmentHotelDetailBinding
import com.ubaya.inapin_160418044.model.Hotel
import com.ubaya.inapin_160418044.model.HotelBook
import com.ubaya.inapin_160418044.model.Notification
import com.ubaya.inapin_160418044.util.loadImage
import com.ubaya.inapin_160418044.view.ButtonBookHotelClickListener
import com.ubaya.inapin_160418044.viewmodel.DetailHotelViewModel
import kotlinx.android.synthetic.main.fragment_hotel_detail.*
import kotlinx.android.synthetic.main.fragment_hotel_detail.view.*
import java.text.SimpleDateFormat
import java.util.*

class HotelDetailFragment : Fragment(),ButtonBookHotelClickListener {
    private lateinit var viewModel:DetailHotelViewModel
    private lateinit var dataBinding:FragmentHotelDetailBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_hotel_detail, container, false)
        dataBinding = DataBindingUtil.inflate<FragmentHotelDetailBinding>(inflater,R.layout.fragment_hotel_detail,container,false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailHotelViewModel::class.java)
        val hotelId = HotelDetailFragmentArgs.fromBundle(requireArguments()).hotelId
        viewModel.fetch(hotelId)

        dataBinding.bookListener = this


        observeViewModel()
    }

    fun Date.toString(format: String, locale: Locale = Locale.getDefault()): String {
        val formatter = SimpleDateFormat(format, locale)
        return formatter.format(this)
    }

    fun getCurrentDateTime(): Date {
        return Calendar.getInstance().time
    }

    fun observeViewModel(){
        viewModel.hotelLD.observe(viewLifecycleOwner, Observer {
            dataBinding.hotel = it
        })
    }

    override fun onButtonBookHotelClick(v: View) {
        var time = getCurrentDateTime()
        var title = "${viewModel.hotelLD.value?.hotelName} berhasil di booking"
        var book = HotelBook(viewModel.hotelLD.value?.hotelName,viewModel.hotelLD.value?.hotelAddress,viewModel.hotelLD.value?.photoUrl,time.toString())
        viewModel.addBook(book)
        var notif = Notification(title,"booking notification",time.toString())
        viewModel.addNotification(notif)
        val snackbar = Snackbar.make(v, "Hotel berhasil di booking",
            Snackbar.LENGTH_LONG).setAction("Action", null)
        snackbar.show()
    }

}