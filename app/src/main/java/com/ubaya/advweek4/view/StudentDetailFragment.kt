package com.ubaya.advweek4.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.squareup.picasso.Picasso
import com.ubaya.advweek4.R
import com.ubaya.advweek4.databinding.FragmentStudentDetailBinding
import com.ubaya.advweek4.util.loadImage
import com.ubaya.advweek4.viewmodel.DetailViewModel
import com.ubaya.advweek4.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.fragment_student_detail.*
import kotlinx.android.synthetic.main.fragment_student_list.*
import kotlinx.android.synthetic.main.student_list_item.view.*

class StudentDetailFragment : Fragment(),ButtonNotifClickListener,ButtonUpdateDetailClickListener {
    private lateinit var viewModel: DetailViewModel
    private lateinit var dataBinding: FragmentStudentDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate<FragmentStudentDetailBinding>(inflater, R.layout.fragment_student_detail, container, false)
        return dataBinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.fetch(StudentDetailFragmentArgs.fromBundle(requireArguments()).id)
        observerStudent()
        dataBinding.listener1=this
        dataBinding.listener2=this
    }
    fun observerStudent(){
        viewModel.studentLD.observe(viewLifecycleOwner, Observer {
            dataBinding.student = it
//            txtID.setText(viewModel.studentLD.value?.id)
//            txtName.setText(viewModel.studentLD.value?.name)
//            txtBoD.setText(viewModel.studentLD.value?.bod)
//            txtPhone.setText(viewModel.studentLD.value?.phone)
//            imageView2.loadImage(viewModel.studentLD.value?.photoUrl, progressBar2)
        })
    }

    override fun onButtonNotifClick(v: View) {
        TODO("Not yet implemented")
    }

    override fun onButtonUpdateDetailClick(v: View) {
        TODO("Not yet implemented")
    }
}