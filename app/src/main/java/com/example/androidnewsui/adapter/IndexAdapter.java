package com.example.androidnewsui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;
import com.example.androidnewsui.R;
import com.example.androidnewsui.entry.NewsData;

import java.util.List;

public class IndexAdapter extends RecyclerView.Adapter<IndexAdapter.ViewHolder>{
    private List<NewsData> newsList ;
    // 构造器
    public IndexAdapter(List<NewsData> newsDataList) {
        this.newsList = newsDataList;
    }
    //
    @Override
    public IndexAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_index, parent, false);
        IndexAdapter.ViewHolder holder = new IndexAdapter.ViewHolder(view);
        holder.newsCategoryView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                NewsData news= newsList.get(position);
                Toast.makeText(v.getContext(), "you clicked view " + news.getContent(),Toast.LENGTH_SHORT).show();
            }
        });
        holder.newsImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                NewsData news = newsList.get(position);
                Toast.makeText(v.getContext(), "you clicked image " + news.getImgId() , Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    // 为每个图片绑定数据
    @Override
    public void onBindViewHolder( IndexAdapter.ViewHolder holder, int position) {
        NewsData news = newsList.get(position);
        holder.newsImage.setImageResource(news.getImgId());
        holder.newsTitle.setText(news.getContent());
    }

    // 统计新闻的条数
    @Override
    public int getItemCount() {
        return newsList.size();
    }

    //为每个图片绑定点击事件
    public class ViewHolder extends RecyclerView.ViewHolder {
        View newsCategoryView;
        ImageView newsImage;
        TextView newsTitle;
        public ViewHolder( View view) {
            super(view);
            newsCategoryView =view;
            newsImage = (ImageView) view.findViewById(R.id.indexImg);
            newsTitle = (TextView) view.findViewById(R.id.indexMessage);
        }
    }
}
