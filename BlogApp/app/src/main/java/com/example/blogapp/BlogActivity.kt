package com.example.blogapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.blogapp.databinding.ActivityBlogBinding

class BlogActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBlogBinding

    companion object{
        const val IMAGE = "imageURL"
        const val TITLE = "title"
        const val CONTENT = "content"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBlogBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val intent = intent
        Glide.with(binding.blogImage.context).load(intent.getStringExtra(IMAGE)).into(binding.blogImage)
        binding.blogTitle.text = intent.getStringExtra(TITLE)
        binding.blogText.text = intent.getStringExtra(CONTENT)
    }
}