package com.example.androidnewsui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.androidnewsui.adapter.CategoryAdapter;
import com.example.androidnewsui.api.Api;
import com.example.androidnewsui.base.Category;
import com.example.androidnewsui.base.News;
import com.example.androidnewsui.entry.NewsData;
import com.example.androidnewsui.R;
import com.example.androidnewsui.adapter.NewsAdapter;
import com.example.androidnewsui.service.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsCategoryActivity  extends BaseActivity {
    //
    private List<News.DataDTO.ResultDTO> newsDataList = null;

    private List<Category.DataDTO.ResultDTO> categoriesList = null;

    private ImageButton findNews = null;

    private EditText searchText = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_category);
        listCategory();
        Intent intent = this.getIntent();
        String message = intent.getStringExtra("message");
        if (message == null){
            listNews();
        }else if (message.equals("listNewsByCategory")){
            String id = intent.getStringExtra("id");
            listNewsByCategory(id);
        }
        searchText = findViewById(R.id.search_news_text);
        findNews = findViewById(R.id.search_news_btn);
        findNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String keyWord = searchText.getText().toString();
                newsFind(keyWord);
            }
        });
    }

    private void loadCategory(){
        RecyclerView navigationView = findViewById(R.id.navigation);
        // 线性布局
        LinearLayoutManager categoryLayoutManager = new LinearLayoutManager(this);
        categoryLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        // 设置布局格式
        navigationView.setLayoutManager(categoryLayoutManager);
        CategoryAdapter categoryAdapter = new CategoryAdapter(categoriesList, NewsCategoryActivity.this);
        navigationView.setAdapter(categoryAdapter);
    }

    private void loadNews(){
        // 绑定布局
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        // 瀑布布局,spanCount为一行占几个
        StaggeredGridLayoutManager newsLayoutManager = new StaggeredGridLayoutManager(
                2, StaggeredGridLayoutManager.VERTICAL
        );
        // 设置布局格式
        recyclerView.setLayoutManager(newsLayoutManager);
        NewsAdapter newsAdapter = new NewsAdapter(newsDataList,NewsCategoryActivity.this);
        recyclerView.setAdapter(newsAdapter);
    }

    public void listNewsByCategory(String id) {
        final String TAG = "ListNewsByCategory";
        new Retrofit.Builder()
                .baseUrl(Api.getUrlId())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class)
                .listNewsByCategory(id)
                .enqueue(new Callback<News>() {
                    @Override
                    public void onResponse(Call<News> call, Response<News> response) {
                        News body = response.body();
                        List<News.DataDTO.ResultDTO> result = body.getData().getResult();
                        Log.d(TAG, "onResponse: " + result);
                        newsDataList = result;
                        loadNews();
                    }

                    @Override
                    public void onFailure(Call<News> call, Throwable t) {
                        Log.d(TAG, "onFailure: " + t);
                    }
                });
    }

    public void listCategory() {
        String TAG = "ListCategoryResult";
        new Retrofit.Builder()
                .baseUrl(Api.getUrlId())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class)
                .listCategory().enqueue(new Callback<com.example.androidnewsui.base.Category>() {
            @Override
            public void onResponse(Call<com.example.androidnewsui.base.Category> call, Response<com.example.androidnewsui.base.Category> response) {
                com.example.androidnewsui.base.Category body = response.body();
                Log.d(TAG, body.toString());
                List<com.example.androidnewsui.base.Category.DataDTO.ResultDTO> result = body.getData().getResult();
                Log.d(TAG, result.toString());
                categoriesList = result;
                loadCategory();
            }
            @Override
            public void onFailure(Call<com.example.androidnewsui.base.Category> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t);
            }
        });
    }

    public void listNews() {
        String TAG = "NewsListResult";
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
                newsDataList = result;
                loadNews();
            }
            @Override
            public void onFailure(Call<News> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t);
            }
        });
    }

    public void newsFind(String newsKeyWord) {
        String TAG = "NewsFindResult";
        new Retrofit.Builder()
                .baseUrl(Api.getUrlId())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class)
                .newsFind(newsKeyWord)
                .enqueue(new Callback<News>() {
                    @Override
                    public void onResponse(Call<News> call, Response<News> response) {
                        News body = response.body();
                        List<News.DataDTO.ResultDTO> result = body.getData().getResult();
                        Log.d(TAG, "onResponse: " + result);
                        newsDataList = result;
                        loadNews();
                    }
                    @Override
                    public void onFailure(Call<News> call, Throwable t) {
                        Log.d(TAG, "onFailure: " + t);
                    }
                });
    }
}