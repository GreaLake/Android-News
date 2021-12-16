package com.example.androidnewsui.result;

import android.util.Log;

import com.example.androidnewsui.api.Api;
import com.example.androidnewsui.base.SingleBool;
import com.example.androidnewsui.service.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author LZH
 */
public class LogoutResult {
    String TAG = "LogoutResult";

    public void post(String token) {
        new Retrofit.Builder()
                .baseUrl(Api.getUrlId())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class)
                .logout(token)
                .enqueue(new Callback<SingleBool>() {
                    @Override
                    public void onResponse(Call<SingleBool> call, Response<SingleBool> response) {
                        SingleBool body = response.body();
                        Boolean result = body.getData().getResult();
                        Log.d(TAG, "onResponse: " + result);
                    }

                    @Override
                    public void onFailure(Call<SingleBool> call, Throwable t) {

                    }
                });
    }
}
