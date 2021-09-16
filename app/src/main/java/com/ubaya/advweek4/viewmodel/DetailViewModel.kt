package com.ubaya.advweek4.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ubaya.advweek4.model.Student
import com.ubaya.advweek4.view.StudentDetailFragmentArgs

class DetailViewModel:ViewModel() {
    val studentLD = MutableLiveData<Student>()
    fun fetch(id: String?,name:String?,bod:String?,phone:String?,photoUrl:String?) {
        val student1 = Student(id,name,bod,phone,photoUrl)
        studentLD.value = student1
    }
}