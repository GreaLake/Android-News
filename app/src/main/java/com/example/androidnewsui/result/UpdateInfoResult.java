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
 * @Description 更改用户信息
 * @author LZH
 */
public class UpdateInfoResult {
    String TAG = "UpdateInfoResult";

    /**
     * 使用Retrofit框架获取body
     * .getData()获取具体信息
     * .getResult()获取类别信息,TYPE：Boolean
     *
     * @param token 内容
     * @param content 内容
     * @param icon 图标
     */
    public void post(String token,String content,String icon) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("content", content);
            jsonObject.put("icon", icon);

        } catch (
                JSONException e) {
            e.printStackTrace();
        }

        new Retrofit.Builder()
                .baseUrl(Api.getUrlId())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class)
                .updateInfo(token, RequestBody.create(jsonObject.toString(), MediaType.parse("application/json;charset=utf-8")))
                .enqueue(new Callback<SingleBool>() {
                    @Override
                    public void onResponse(Call<SingleBool> call, Response<SingleBool> response) {
                        SingleBool body = response.body();
                        Boolean result = body.getData().getResult();
                        Log.d(TAG, "onResponse: "+result);
                        Log.d(TAG, "onResponse: "+body);
                    }

                    @Override
                    public void onFailure(Call<SingleBool> call, Throwable t) {

                    }
                });
    }
}
