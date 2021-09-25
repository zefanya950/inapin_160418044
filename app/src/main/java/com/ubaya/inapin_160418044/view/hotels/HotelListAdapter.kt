package com.ubaya.inapin_160418044.view.hotels

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.inapin_160418044.R
import com.ubaya.inapin_160418044.model.Hotel
import kotlinx.android.synthetic.main.hotel_list_item.view.*

class HotelListAdapter(val hotelList:ArrayList<Hotel>):RecyclerView.Adapter<HotelListAdapter.HotelViewHolder>() {
    class HotelViewHolder(val view:View):RecyclerView.ViewHolder(view)

    fun updateHotelList(newHotelList:List<Hotel>){
        hotelList.clear()
        hotelList.addAll(newHotelList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotelViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.hotel_list_item,parent,false)
        return HotelViewHolder(v)
    }

    override fun onBindViewHolder(holder: HotelViewHolder, position: Int) {
        holder.view.txtAddress.text = hotelList[position].hotelAddress
        holder.view.txtHotelName.text = hotelList[position].hotelName

        holder.view.btnDetail.setOnClickListener {
            val action = HotelListFragmentDirections.actionHotelDetail()
            Navigation.findNavController(it).navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return hotelList.size
    }
}