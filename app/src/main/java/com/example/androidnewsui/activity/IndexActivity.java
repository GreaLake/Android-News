package com.example.androidnewsui.activity;


import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.androidnewsui.R;
import com.example.androidnewsui.adapter.IndexAdapter;
import com.example.androidnewsui.api.Api;
import com.example.androidnewsui.base.News;
import com.example.androidnewsui.entry.NewsData;
import com.example.androidnewsui.service.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class IndexActivity extends AppCompatActivity {
    final String TAG = "IndexActivity";

    private List<NewsData> newsDataList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        // 初始化数据
        initNewsData();
        // 绑定布局
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.newsIndex);
        // 瀑布布局
        StaggeredGridLayoutManager newsLayoutManager = new StaggeredGridLayoutManager(
                1, StaggeredGridLayoutManager.VERTICAL
        );
        // 设置布局格式
        recyclerView.setLayoutManager(newsLayoutManager);
        //
        IndexAdapter indexAdapter = new IndexAdapter(newsDataList);
        //
        recyclerView.setAdapter(indexAdapter);
    }

    //初始化新闻数据
    private void initNewsData() {
        Log.d(TAG, "initNewsData: get");
        get();
        for (int i = 0; i < 1; i++) {
            NewsData news_1 = new NewsData(R.drawable.news_1,"新闻1");
            newsDataList.add(news_1);
            NewsData news_2 = new NewsData(R.drawable.news_2,"新闻2");
            newsDataList.add(news_2);
            NewsData news_3 = new NewsData(R.drawable.news_3,"新闻3");
            newsDataList.add(news_3);
            NewsData news_4 = new NewsData(R.drawable.news_4,"新闻4");
            newsDataList.add(news_4);
            NewsData news_5 = new NewsData(R.drawable.news_5,"新闻5");
            newsDataList.add(news_5);
        }
    }

    /**
     * 使用Retrofit框架获取body
     * .getData()获取具体信息
     * .getResult()获取新闻信息,TYPE：List
     */
    public void get() {
        new Retrofit.Builder()
                .baseUrl(Api.getUrlId())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class)
                .newsList().enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                News body = response.body();
                List<News.DataDTO.ResultDTO> result = body.getData().getResult();
                Log.d(TAG, "onResponse: " + result);

            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t);
            }
        });
    }
}