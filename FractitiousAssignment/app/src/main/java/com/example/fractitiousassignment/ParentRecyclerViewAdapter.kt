package com.example.fractitiousassignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2

class RecyclerViewAdapter(): RecyclerView.Adapter<RecyclerViewItemHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewItemHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recyclerview_parent, parent, false)
        return RecyclerViewItemHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewItemHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 1
    }
}

class RecyclerViewItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val sliderView: ViewPager2 = itemView.findViewById(R.id.viewPager_ImageSlider)
}