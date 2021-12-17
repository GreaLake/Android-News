package com.example.androidnewsui.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.androidnewsui.entry.NewsData;
import com.example.androidnewsui.R;
import com.example.androidnewsui.adapter.NewsApapter;

import java.util.ArrayList;
import java.util.List;

public class NewsCategoryActivity  extends AppCompatActivity {
    private List<NewsData> newsDataList = new ArrayList<>();
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_news_category);
            initNews();
            RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
            //瀑布布局,spanCount为一行占几个
            StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(
                    2, StaggeredGridLayoutManager.VERTICAL
            );
            recyclerView.setLayoutManager(layoutManager);
            NewsApapter adapter = new NewsApapter(newsDataList);
            recyclerView.setAdapter(adapter);
        }

    //初始化数据
    private void initNews() {
        for (int i = 0; i < 2; i++) {
            NewsData news_1 = new NewsData(R.drawable.news_1,"新闻事件1");
            newsDataList.add(news_1);
            NewsData news_2 = new NewsData(R.drawable.news_2,"新闻事件2");
            newsDataList.add(news_2);
            NewsData news_3 = new NewsData(R.drawable.news_3,"新闻事件3");
            newsDataList.add(news_3);
            NewsData news_4 = new NewsData(R.drawable.news_4,"新闻事件4");
            newsDataList.add(news_4);
            NewsData news_5 = new NewsData(R.drawable.news_5,"新闻事件5");
            newsDataList.add(news_5);
        }
    }
}