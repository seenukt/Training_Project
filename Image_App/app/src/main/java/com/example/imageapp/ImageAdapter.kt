package com.example.imageapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.core.net.toUri
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.imagelayout.view.*

class ImageAdapter(val context: Context,val list :List<ImagePath>): RecyclerView.Adapter<ImageAdapter.holder>() {
    class holder(itemview:View):RecyclerView.ViewHolder(itemview) {
 val imageview = itemview.imageView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): holder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.imagelayout,parent,false)
        return holder((view))
    }

    override fun onBindViewHolder(holder: holder, position: Int) {
      val currentitem = list[position]
        Glide.with(context).load(currentitem.path).into(holder.imageview)
//       holder.imageview.setImageURI(currentitem.path.toUri())
    }

    override fun getItemCount(): Int {
      return list.size
    }


}