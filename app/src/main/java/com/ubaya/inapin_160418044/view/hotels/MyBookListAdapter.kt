package com.ubaya.inapin_160418044.view.hotels

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.inapin_160418044.R
import com.ubaya.inapin_160418044.model.HotelBook
import com.ubaya.inapin_160418044.util.loadImage
import kotlinx.android.synthetic.main.book_list_item.view.*

class MyBookListAdapter(val bookList:ArrayList<HotelBook>):RecyclerView.Adapter<MyBookListAdapter.HotelBookViewHolder>() {
    class HotelBookViewHolder(val view:View) : RecyclerView.ViewHolder(view)

    fun updateBookList(newBookList:List<HotelBook>){
        bookList.clear()
        bookList.addAll(newBookList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotelBookViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.book_list_item,parent,false)

        return HotelBookViewHolder(v)
    }

    override fun onBindViewHolder(holder: HotelBookViewHolder, position: Int) {
        holder.view.txtAddressBook.text = bookList[position].hotelAddress
        holder.view.txtHotelBook.text = bookList[position].hotelName
        holder.view.txtDateBook.text = bookList[position].dateBook
        holder.view.imageHotelBook.loadImage(bookList[position].photoUrl,holder.view.progressBar2)

    }

    override fun getItemCount(): Int {
        return bookList.size
    }

}