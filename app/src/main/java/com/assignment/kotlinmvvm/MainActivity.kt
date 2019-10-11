package com.assignment.kotlinmvvm

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.assignment.kotlinmvvm.DataModel.Android
import com.assignment.kotlinmvvm.ViewModels.AndroidViewModel
import com.assignment.kotlinmvvm.interfaces.ItemClickListener
import com.assignment.trainenquiry.adapter.EmpAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        linearLayoutManager = LinearLayoutManager(this@MainActivity)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.hasFixedSize()

        getAndroidVersion()

    }

    private fun getAndroidVersion() {
        Log.e("getAndroidVersion","yes")

        val mAndroidViewModel = ViewModelProviders.of(this@MainActivity).get(AndroidViewModel::class.java)
        mAndroidViewModel.getAndroidData()?.observe(this, Observer<List<Android>> { androidList ->

            Log.e("list",androidList?.size.toString())
            recyclerView.adapter = EmpAdapter(this@MainActivity, androidList as ArrayList<Android>, object : ItemClickListener {
                override fun onItemClick(pos: Int) {
                    Toast.makeText(applicationContext, "item $pos clicked", Toast.LENGTH_LONG).show()
                }
            })
        })

    }
}

