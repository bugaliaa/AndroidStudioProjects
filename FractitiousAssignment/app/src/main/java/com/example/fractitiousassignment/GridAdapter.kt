package com.example.fractitiousassignment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.fractitiousassignment.databinding.ItemGridBinding
import com.example.fractitiousassignment.databinding.ItemGridviewCellBinding


class GridAdapter(var name: Array<String>, var icon: IntArray, var context: Context): BaseAdapter() {

    override fun getCount(): Int {
        return name.size
    }

    override fun getItem(position: Int): Any {
        return name[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = View.inflate(context, R.layout.item_gridview_cell, null)
        val imageView: ImageView = view.findViewById(R.id.cellIcon)
        val textView: TextView = view.findViewById(R.id.cellText)

        imageView.setImageResource(icon[position])
        textView.text = name[position]

        return view

    }
}