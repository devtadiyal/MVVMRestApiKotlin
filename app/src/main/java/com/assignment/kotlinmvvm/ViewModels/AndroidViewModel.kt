package com.assignment.kotlinmvvm.ViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.util.Log
import com.assignment.kotlinmvvm.CommonService.RetrofitService
import com.assignment.kotlinmvvm.DataModel.Android

class AndroidViewModel: ViewModel() {

    private val mService  =  RetrofitService()

    fun getAndroidData() : MutableLiveData<List<Android>>? {
        Log.e("getAndroidData","yes")
        return mService.loadAndroidData()
    }

}
