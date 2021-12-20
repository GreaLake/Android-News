package com.example.androidnewsui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.androidnewsui.entry.NewsData;
import com.example.androidnewsui.R;

import java.util.List;

public class NewsApapter extends RecyclerView.Adapter<NewsApapter.ViewHolder>{
    private List<NewsData> newsDataList;

    // 构造器
    public NewsApapter(List<NewsData> newsDataList) {
        this.newsDataList = newsDataList;
    }

    //
    @Override
    public NewsApapter.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        ViewHolder holder = new ViewHolder(view);
        holder.newsCategoryView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                NewsData newsData = newsDataList.get(position);
                Toast.makeText(v.getContext(), "you clicked view " + newsData.getContent(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.newsImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                NewsData newsData = newsDataList.get(position);
                Toast.makeText(v.getContext(), "you clicked image " + newsData.getContent(), Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    // 为每个图片绑定数据
    @Override
    public void onBindViewHolder( NewsApapter.ViewHolder holder, int position) {
        NewsData newsData = newsDataList.get(position);
        holder.newsImage.setImageResource(newsData.getImgId());
        holder.newsTitle.setText(newsData.getContent());
    }

    // 统计新闻的条数
    @Override
    public int getItemCount() {
        return newsDataList.size();
    }

    //为每个图片绑定点击事件
    public class ViewHolder extends RecyclerView.ViewHolder {
        View newsCategoryView;
        ImageView newsImage;
        TextView newsTitle;
        public ViewHolder( View view) {
            super(view);
            newsCategoryView =view;
            newsImage = (ImageView) view.findViewById(R.id.img_news);
            newsTitle = (TextView) view.findViewById(R.id.txt_news);
        }
    }
}
