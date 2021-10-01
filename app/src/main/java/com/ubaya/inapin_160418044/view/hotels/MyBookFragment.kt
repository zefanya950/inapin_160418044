package com.ubaya.inapin_160418044.view.hotels

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ubaya.inapin_160418044.R
import com.ubaya.inapin_160418044.viewmodel.BookViewModel
import com.ubaya.inapin_160418044.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.fragment_hotel_list.*
import kotlinx.android.synthetic.main.fragment_my_book.*

class MyBookFragment : Fragment() {
    private lateinit var viewModel: BookViewModel
    private val hotelBookAdapter = MyBookListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_book, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(BookViewModel::class.java)
        viewModel.refresh()

        bookView.layoutManager=LinearLayoutManager(context)
        bookView.adapter = hotelBookAdapter

        observeViewModel()
    }

    fun observeViewModel(){
        viewModel.booksLD.observe(viewLifecycleOwner, Observer {
            hotelBookAdapter.updateBookList(it)
        })

        viewModel.loadingErrorLD.observe(viewLifecycleOwner, Observer {
            txtBookError.visibility = if (it) View.VISIBLE else View.GONE

        })

        viewModel.loadingDoneLD.observe(viewLifecycleOwner, Observer {
            if (it){
                progressBookLoad.visibility = View.GONE
                bookView.visibility = View.VISIBLE
            }
            else{
                progressBookLoad.visibility = View.VISIBLE
                bookView.visibility = View.GONE
            }
        })
    }


}