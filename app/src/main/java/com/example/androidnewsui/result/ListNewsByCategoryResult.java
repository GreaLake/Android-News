package com.example.androidnewsui.result;

import android.util.Log;

import com.example.androidnewsui.api.Api;
import com.example.androidnewsui.base.News;
import com.example.androidnewsui.service.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @Description 根据获取类别信息
 * @author FZN
 */
public class ListNewsByCategoryResult {
    final String TAG = "ListNewsByCategory";

    /**
     * 使用Retrofit框架获取body
     * .getData()获取具体信息
     * .getResult()获取类别信息,TYPE：List
     *
     * @param id 新闻类别
     */
    public void get(String id) {
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
                    }

                    @Override
                    public void onFailure(Call<News> call, Throwable t) {
                        Log.d(TAG, "onFailure: " + t);
                    }
                });
    }
}
