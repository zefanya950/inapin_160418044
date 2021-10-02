package com.ubaya.inapin_160418044.view.hotels

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.inapin_160418044.R
import com.ubaya.inapin_160418044.model.Hotel
import com.ubaya.inapin_160418044.util.loadImage
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
        holder.view.imageView.loadImage(hotelList[position].photoUrl,holder.view.progressBar)

        holder.view.btnDetail.setOnClickListener {
            val hotelName = hotelList[position].hotelName
            val hotelAddress = hotelList[position].hotelAddress
            val hotelPrice = hotelList[position].hotelPrice
            val hotelPhone = hotelList[position].hotelPhone
            val urlPhoto = hotelList[position].photoUrl
            val action = HotelListFragmentDirections.actionHotelDetail(hotelName.toString(),hotelAddress.toString(),hotelPrice.toString(),urlPhoto.toString(),hotelPhone.toString())
            Navigation.findNavController(it).navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return hotelList.size
    }
}