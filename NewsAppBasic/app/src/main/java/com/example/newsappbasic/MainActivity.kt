package com.example.newsappbasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NewsItemClicked {

    private lateinit var mAdapter: NewsListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)
        fetchData()
        mAdapter = NewsListAdapter(this)
        recyclerView.adapter = mAdapter
    }

    private fun fetchData() {
        val url = "http://indianbureaucracy.com/wp-json/wp/v2/posts"
        val jsonObjectRequest = JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                {
                    val newsJsonArray = it.getJSONArray("title")
                    val newsArray = ArrayList<News>()
                    for(i in 0 until newsJsonArray.length()) {
                        val newsJsonObject = newsJsonArray.getJSONObject(i)
                        Log.d("name", "$")
                        val news = News(
                                newsJsonObject.getString("rendered"),
//                                newsJsonObject.getString("url"),
//                                newsJsonObject.getString("description"),
//                                newsJsonObject.getString("jetpack_featured_media_url")
                        )
                        newsArray.add(news)
                    }
                    mAdapter.updateNews(newsArray)


                    val imageJsonArray = it.getJSONArray("jetpack_featured_media_url")
                    val imageArray = ArrayList<Image>()
                    for(i in 0 until newsJsonArray.length()) {
                        val newsJsonObject = newsJsonArray.getJSONObject(i)
                        Log.d("name", "$")
                        val image = Image(
                                newsJsonObject.getString("rendered"),
//                                newsJsonObject.getString("url"),
//                                newsJsonObject.getString("description"),
//                                newsJsonObject.getString("jetpack_featured_media_url")
                        )
                        imageArray.add(image)
                    }
                    mAdapter.updateNews(imageArray)
                },
                {
                    Log.d("VOLLEY CONDITION: ", "VOLLEY FAILED TO GET DATA")
                }
        )
        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest)
    }

    override fun onItemClicked(item: News) {

    }
}