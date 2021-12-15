package com.example.androidnewsui.service;


import com.example.androidnewsui.base.Category;
import com.example.androidnewsui.base.Comment;
import com.example.androidnewsui.base.Login;
import com.example.androidnewsui.base.News;
import com.example.androidnewsui.base.RegisterAndLogout;
import com.example.androidnewsui.base.User;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

/**
 * @author FZN
 */
public interface ApiService {
    /**
     * 获取所有类别
     *
     * @return
     */
    @GET("/base/listCategory")
    Call<Category> listCategory();

    /**
     * 根据id获取类别
     * @param categoryId
     * @return
     */
    @GET("/base/listNewsByCategory")
    Call<News> listNewsByCategory(@Query("categoryId") String categoryId);

    /**
     * 获取全部评论
     * @param commentFather
     * @param newsId
     * @return
     */
    @GET("/base/listComment")
    Call<Comment> listComment(@Query("commentFather") Integer commentFather, @Query("newsId") Integer newsId);

    /**
     * 登录
     *
     * @param body
     * @return
     */
    @POST("/base/login")
    Call<Login> login(@Body RequestBody body);

    /**
     * 根据id获取新闻
     * @param newsKeyWord
     * @return
     */
    @GET("/base/newsFind")
    Call<News> newsFind(@Query("newsKeyWord") int newsKeyWord);

    /**
     * 获取所有新闻
     * @return
     */
    @GET("/base/newsList")
    Call<News> newsList();

    /**
     * 注册
     * @param body
     * @return
     */
    @PUT("/base/register")
    Call<RegisterAndLogout> register(@Body RequestBody body);

    /**
     * 根据关键字查找用户
     * @param userKeyWord
     * @return
     */
    @GET("/base/userFind")
    Call<User> userFind(@Query("userKeyWord") String userKeyWord);

}
