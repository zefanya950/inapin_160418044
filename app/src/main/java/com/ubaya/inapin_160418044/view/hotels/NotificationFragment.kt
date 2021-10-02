package com.ubaya.inapin_160418044.view.hotels

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ubaya.inapin_160418044.R
import com.ubaya.inapin_160418044.viewmodel.NotificationViewModel
import kotlinx.android.synthetic.main.fragment_my_book.*
import kotlinx.android.synthetic.main.fragment_notification.*


class NotificationFragment : Fragment() {
    private lateinit var viewModel:NotificationViewModel
    private val notificationListAdapter = NotificationListAdapter(arrayListOf())
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notification, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(NotificationViewModel::class.java)
        viewModel.refresh()

        recNotif.layoutManager = LinearLayoutManager(context)
        recNotif.adapter = notificationListAdapter

        observeViewModel()
    }

    fun observeViewModel(){
        viewModel.notificationsLD.observe(viewLifecycleOwner, Observer {
            notificationListAdapter.updateNotificationList(it)
        })

        viewModel.loadingErrorLD.observe(viewLifecycleOwner, Observer {
            txtErrorNotif.visibility = if (it) View.VISIBLE else View.GONE
        })

        viewModel.loadingDoneLD.observe(viewLifecycleOwner, Observer {
            if (it){
                progressBarNotif.visibility = View.GONE
                recNotif.visibility = View.VISIBLE
            }
            else{
                progressBarNotif.visibility = View.VISIBLE
                recNotif.visibility = View.GONE
            }
        })
    }

}