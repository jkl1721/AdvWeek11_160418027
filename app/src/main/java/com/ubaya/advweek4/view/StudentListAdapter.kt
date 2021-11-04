package com.ubaya.advweek4.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.ubaya.advweek4.R
import com.ubaya.advweek4.databinding.StudentListItemBinding
import com.ubaya.advweek4.model.Student
import kotlinx.android.synthetic.main.student_list_item.view.*
import com.ubaya.advweek4.util.loadImage

class StudentListAdapter(val studenList:ArrayList<Student>):RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>(),ButtonDetailClickListener
{
    class StudentViewHolder(var view: StudentListItemBinding) : RecyclerView.ViewHolder(view.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):StudentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<StudentListItemBinding>(inflater, R.layout.student_list_item, parent, false)
        return StudentViewHolder(view)
    }
    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.view.student = studenList[position]
        holder.view.listener = this
//        holder.view.txtID.text = studenList[position].id
//        holder.view.txtName.text = studenList[position].name
//        holder.view.btnDetail.setOnClickListener {
//            val action = studenList[position].id?.let { it1 ->
//                StudentListFragmentDirections.actionStudentDetail(
//                    it1,studenList[position].name,studenList[position].bod,studenList[position].phone,studenList[position].photoUrl)
//            }
//            if (action != null) {
//                Navigation.findNavController(it).navigate(action)
//            }
//        }
//        holder.view.imageView.loadImage(studenList[position].photoUrl,
//            holder.view.progressBar)
    }

    override fun onButtonDetailClick(v: View) {
         val action = StudentListFragmentDirections.actionStudentDetail(v.tag.toString())
         Navigation.findNavController(v).navigate(action)
    }
    override fun getItemCount(): Int {
        return studenList.size
    }
    fun updateStudentList(newStudentList: List<Student>) {
        studenList.clear()
        studenList.addAll(newStudentList)
        notifyDataSetChanged()
    }
}