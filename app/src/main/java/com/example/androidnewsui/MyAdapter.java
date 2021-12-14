package com.example.androidnewsui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;

public class MyAdapter extends BaseAdapter {
    private Context mContext;
    private LinkedList<NewsData> mData;

    public MyAdapter(Context mContext, LinkedList<NewsData> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    public MyAdapter() {
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(mContext).inflate(R.layout.item_list,parent,false);
        ImageView img_news = (ImageView) convertView.findViewById(R.id.img_news);
        TextView txt_news = (TextView) convertView.findViewById(R.id.txt_news);
        img_news.setBackgroundResource(mData.get(position).getImgId());
        txt_news.setText(mData.get(position).getContent());
        return convertView;
    }
}
