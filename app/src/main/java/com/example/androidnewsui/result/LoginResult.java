package com.example.androidnewsui.result;

import android.util.Log;

import com.example.androidnewsui.api.Api;
import com.example.androidnewsui.base.Login;
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

public class LoginResult {
    String TAG = "LoginResult";

    public void post(String username, String password) {
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
                .login(RequestBody.create(jsonObject.toString(), MediaType.parse("application/json;charset=utf-8")))
                .enqueue(new Callback<Login>() {
                    @Override
                    public void onResponse(Call<Login> call, Response<Login> response) {
                        Login body = response.body();
                        Boolean result = body.getData().getResult();
                        String token = body.getData().getToken();
                        Log.d(TAG, "onResponse: " + result);
                        Log.d(TAG, "onResponse: " + token);


                    }

                    @Override
                    public void onFailure(Call<Login> call, Throwable t) {

                    }
                });
    }
}
