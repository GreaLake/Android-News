package com.example.androidnewsui.result;

import android.util.Log;

import com.example.androidnewsui.api.Api;
import com.example.androidnewsui.base.SingleBool;
import com.example.androidnewsui.service.ApiService;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @Description 注册
 * @author FZN
 */
public class RegisterResult {
    String TAG = "RegisterResult";

    /**
     * 使用Retrofit框架获取body
     * .getData()获取具体信息
     * .getResult()获取是否注册成功信息,TYPE：Boolean
     *
     * @param username 用户名
     * @param password 用户密码
     */
    public void put(String username, String password) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("username", username);
            jsonObject.put("password", password);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        new Retrofit.Builder()
                .baseUrl(Api.getUrlId())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class)
                .register(RequestBody.create(jsonObject.toString(), MediaType.parse("application/json;charset=utf-8")))
                .enqueue(new Callback<SingleBool>() {
                    @Override
                    public void onResponse(Call<SingleBool> call, Response<SingleBool> response) {
                        SingleBool body = response.body();
                        Boolean result = body.getData().getResult();
                        Log.d(TAG, "onResponse: " + result);


                    }

                    @Override
                    public void onFailure(Call<SingleBool> call, Throwable t) {
                        Log.d(TAG, "onFailure: " + t);
                    }
                });
    }
}
