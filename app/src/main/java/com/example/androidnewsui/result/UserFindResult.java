package com.example.androidnewsui.result;

import android.util.Log;

import com.example.androidnewsui.api.Api;
import com.example.androidnewsui.base.User;
import com.example.androidnewsui.service.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @Description 搜索用户
 * @author FZN
 */
public class UserFindResult {
    String TAG = "UserFindResult";

    /**
     * 使用Retrofit框架获取body
     * .getData()获取具体信息
     * .getResult()获取用户是否修改成功信息,TYPE：List
     *
     * @param userKeyWord 用户关键词
     */
    public void get(String userKeyWord) {
        new Retrofit.Builder()
                .baseUrl(Api.getUrlId())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class)
                .userFind(userKeyWord)
                .enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        User body = response.body();
                        List<User.DataDTO.ResultDTO> result = body.getData().getResult();
                        Log.d(TAG, "onResponse: " + result);
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Log.d(TAG, "onFailure: " + t);
                    }
                });
    }
}
