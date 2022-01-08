package com.example.fractitiousassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.fractitiousassignment.databinding.ActivityMainBinding
import com.example.fractitiousassignment.databinding.ItemGridBinding

class MainActivity : AppCompatActivity() {

    private lateinit var bindingMain: ActivityMainBinding
    private lateinit var bindingGrid: ItemGridBinding
    private lateinit var viewPager2: ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bindingMain.parentRecyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = RecyclerViewAdapter()
        bindingMain.parentRecyclerView.adapter = adapter
        viewPager2 = findViewById(R.id.viewPager_ImageSlider)

        val sliderItems: MutableList<SliderItem> = ArrayList()
        sliderItems.add(SliderItem(R.drawable.image1))
        sliderItems.add(SliderItem(R.drawable.image2))
        sliderItems.add(SliderItem(R.drawable.image3))

        viewPager2.adapter = SliderAdapter(sliderItems, viewPager2)
    }
}