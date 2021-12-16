package com.ubaya.inapin_160418044.view.hotels

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.inapin_160418044.R
import com.ubaya.inapin_160418044.databinding.HotelListItemBinding
import com.ubaya.inapin_160418044.model.Hotel
import com.ubaya.inapin_160418044.util.loadImage
import com.ubaya.inapin_160418044.view.DetailHotelClickListener
import kotlinx.android.synthetic.main.hotel_list_item.view.*

class HotelListAdapter(val hotelList:ArrayList<Hotel>):RecyclerView.Adapter<HotelListAdapter.HotelListViewHolder>(),DetailHotelClickListener {
    class HotelListViewHolder(val view:HotelListItemBinding):RecyclerView.ViewHolder(view.root)

    fun updateHotelList(newHotelList:List<Hotel>){
        hotelList.clear()
        hotelList.addAll(newHotelList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotelListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
//        val v = inflater.inflate(R.layout.hotel_list_item,parent,false)
        val v = DataBindingUtil.inflate<HotelListItemBinding>(inflater,R.layout.hotel_list_item,parent,false)
        return HotelListViewHolder(v)
    }

    override fun onBindViewHolder(holder: HotelListViewHolder, position: Int) {
        holder.view.hotel = hotelList[position]
        holder.view.detailClickListener = this
//        holder.view.txtAddress.text = hotelList[position].hotelAddress
//        holder.view.txtHotelName.text = hotelList[position].hotelName
//        holder.view.imageView.loadImage(hotelList[position].photoUrl,holder.view.progressBar)

//        holder.view.btnDetail.setOnClickListener {
//            val hotelName = hotelList[position].hotelName
//            val hotelAddress = hotelList[position].hotelAddress
//            val hotelPrice = hotelList[position].hotelPrice
//            val hotelPhone = hotelList[position].hotelPhone
//            val urlPhoto = hotelList[position].photoUrl
//            val action = HotelListFragmentDirections.actionHotelDetail(hotelName.toString(),hotelAddress.toString(),hotelPrice.toString(),urlPhoto.toString(),hotelPhone.toString())
//            Navigation.findNavController(it).navigate(action)
//        }

    }

    override fun getItemCount(): Int {
        return hotelList.size
    }

    override fun onDetailHotelClick(v: View) {
        val action = HotelListFragmentDirections.actionHotelDetail(v.tag.toString().toInt())
            Navigation.findNavController(v).navigate(action)
    }
}