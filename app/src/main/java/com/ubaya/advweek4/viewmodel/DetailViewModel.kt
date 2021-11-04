package com.ubaya.advweek4.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ubaya.advweek4.model.Student
import com.ubaya.advweek4.view.StudentDetailFragmentArgs

class DetailViewModel(application: Application): AndroidViewModel(application) {
    val TAG = "volleyTag"
    private var queue: RequestQueue?= null
    val studentLD = MutableLiveData<Student>()
    fun fetch(id: String?) {
        queue = Volley.newRequestQueue(getApplication())
        val url = "http://adv.jitusolution.com/student.php?id="+id.toString()
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->
                val result = Gson().fromJson<Student>(response,
                    Student::class.java)
                val student1 = Student(id,result.name,result.bod,result.phone,result.photoUrl)
                studentLD.value = student1
            },
            {
            })
        stringRequest.tag = TAG
        queue?.add(stringRequest)

    }
}