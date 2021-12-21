package com.example.androidnewsui.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.androidnewsui.adapter.CategoryAdapter;
import com.example.androidnewsui.entry.Category;
import com.example.androidnewsui.entry.NewsData;
import com.example.androidnewsui.R;
import com.example.androidnewsui.adapter.NewsAdapter;

import java.util.ArrayList;
import java.util.List;

public class NewsCategoryActivity  extends AppCompatActivity {
    //
    private List<NewsData> newsDataList = new ArrayList<>();
    private List<Category> categoriesList = new ArrayList<>();
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_news_category);
            // 初始化数据
            initCategories();
            initNewsData();
            // 绑定布局
            RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
            RecyclerView navigationView = findViewById(R.id.navigation);
            // 瀑布布局,spanCount为一行占几个
            StaggeredGridLayoutManager newsLayoutManager = new StaggeredGridLayoutManager(
                    2, StaggeredGridLayoutManager.VERTICAL
            );
            // 线性布局
            LinearLayoutManager categoryLayoutManager = new LinearLayoutManager(this);
            // 设置布局格式
            recyclerView.setLayoutManager(newsLayoutManager);
            categoryLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            navigationView.setLayoutManager(categoryLayoutManager);
            //
            NewsAdapter newsAdapter = new NewsAdapter(newsDataList);
            CategoryAdapter categoryAdapter = new CategoryAdapter(categoriesList);
            //
            recyclerView.setAdapter(newsAdapter);
            navigationView.setAdapter(categoryAdapter);
        }

    //初始化新闻数据
    private void initNewsData() {
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
    //初始话新闻类别数据
    private void initCategories() {
            Category c1 = new Category(1, "世界");
            categoriesList.add(c1);
            Category c2 = new Category(2, "中国");
            categoriesList.add(c2);
            Category c3 = new Category(3, "浙江");
            categoriesList.add(c3);
            Category c4 = new Category(4, "杭州");
            categoriesList.add(c4);
            Category c5 = new Category(5, "富阳");
            categoriesList.add(c5);
            Category c6 = new Category(6, "富春");
            categoriesList.add(c6);
    }
}