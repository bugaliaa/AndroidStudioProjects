package com.example.blogapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.example.blogapp.databinding.ActivityMainBinding
import org.jsoup.Jsoup

class MainActivity : AppCompatActivity(), BlogItemClicked {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: BlogListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        fetchData()
        adapter = BlogListAdapter(this)
        binding.recyclerView.adapter = adapter
    }

    private fun fetchData() {

        val url = "https://indianbureaucracy.com/wp-json/wp/v2/posts"

        val jsonObjectRequest = JsonArrayRequest(Request.Method.GET, url, null,
                {
                    val blogArray = ArrayList<Blog>()
                    for (i in 0 until it.length()) {
                        val blogObject = it.getJSONObject(i)
                        val title = blogObject.getJSONObject("title").getString("rendered")
                        val contentHTML = blogObject.getJSONObject("content").getString("rendered")
                        val content = removeHTML(contentHTML)
                        val imageUrl = blogObject.getString("jetpack_featured_media_url")
                        val blog = Blog(title, content, imageUrl)

                        blogArray.add(blog)
                    }

                    adapter.updateNews(blogArray)
                },
                {
                    Log.d("VOLLEY ERROR", "VOLLEY FAILED TO DO ANY SHIT!!!")
                })
        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest)
    }

    override fun onItemClicked(item: Blog) {
        Toast.makeText(this, "Hello World", Toast.LENGTH_LONG).show()
        val intent = Intent(this, BlogActivity::class.java)
        intent.putExtra("title", item.title)
        intent.putExtra("content", item.content)
        intent.putExtra("imageURL", item.imageURL)

        this.startActivity(intent)
    }

    private fun removeHTML(text: String): String {
        return Jsoup.parse(text).text()
    }
}