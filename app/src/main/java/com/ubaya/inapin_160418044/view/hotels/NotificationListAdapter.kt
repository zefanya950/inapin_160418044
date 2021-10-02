package com.ubaya.inapin_160418044.view.hotels

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.inapin_160418044.R
import com.ubaya.inapin_160418044.model.Notification
import kotlinx.android.synthetic.main.notification_list_item.view.*

class NotificationListAdapter(val notificationList:ArrayList<Notification>):RecyclerView.Adapter<NotificationListAdapter.NotificationViewHolder>() {
    class NotificationViewHolder(val view:View):RecyclerView.ViewHolder(view)

    fun updateNotificationList(newNotificationList:List<Notification>){
        notificationList.clear()
        notificationList.addAll(newNotificationList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        var inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.notification_list_item,parent,false)
        return NotificationViewHolder(v)
    }

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        holder.view.txtNotifTitle.text = notificationList[position].title
        holder.view.txtType.text = notificationList[position].type
        holder.view.txtTime.text = notificationList[position].time

    }

    override fun getItemCount(): Int {
        return notificationList.size
    }

}