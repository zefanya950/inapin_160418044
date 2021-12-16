package com.ubaya.inapin_160418044.view.hotels

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ubaya.inapin_160418044.R
import com.ubaya.inapin_160418044.viewmodel.ListHotelViewModel
import com.ubaya.inapin_160418044.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.fragment_hotel_list.*


class HotelListFragment : Fragment() {
    private lateinit var viewModel:ListHotelViewModel
    private val hotellistAdapter:HotelListAdapter = HotelListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hotel_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(ListHotelViewModel::class.java)
        viewModel.refresh()

        recView.layoutManager = LinearLayoutManager(context)
        recView.adapter = hotellistAdapter

        observeViewModel()
    }

    fun observeViewModel(){
        viewModel.hotelLD.observe(viewLifecycleOwner, Observer {
            hotellistAdapter.updateHotelList(it)
            if(it.isEmpty()) txtError.visibility = View.VISIBLE else txtError.visibility = View.GONE
        })

        viewModel.loadingErrorLD.observe(viewLifecycleOwner, Observer {

        })
    }

}