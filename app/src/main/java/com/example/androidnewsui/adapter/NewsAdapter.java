package com.example.androidnewsui.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.androidnewsui.activity.NewsCategoryActivity;
import com.example.androidnewsui.activity.SigelActivity;
import com.example.androidnewsui.base.News;
import com.example.androidnewsui.entry.NewsData;
import com.example.androidnewsui.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder>{

    private List<News.DataDTO.ResultDTO> newsDataList = null;

    private Context mContext = null;

    // 构造器


    public NewsAdapter(List<News.DataDTO.ResultDTO> newsDataList, Context context) {
        this.newsDataList = newsDataList;
        this.mContext = context;
    }

    //
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent,
                false);
        ViewHolder holder = new ViewHolder(view);
        holder.newsCategoryView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                News.DataDTO.ResultDTO newsData = newsDataList.get(position);
                Toast.makeText(v.getContext(), "you clicked view " +
                        newsData.getContent(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(mContext, SigelActivity.class);
                intent.putExtra("title",newsData.getTitle());
                intent.putExtra("content",newsData.getContent());
                mContext.startActivity(intent);
            }
        });
        holder.newsImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                News.DataDTO.ResultDTO newsData = newsDataList.get(position);
                Toast.makeText(v.getContext(), "you clicked image " +
                        newsData.getContent(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(mContext, SigelActivity.class);
                intent.putExtra("title",newsData.getTitle());
                intent.putExtra("content",newsData.getContent());
                mContext.startActivity(intent);
            }

        });
        return holder;
    }

    // 为每个图片绑定数据
    @Override
    public void onBindViewHolder(NewsAdapter.ViewHolder holder, int position) {
        News.DataDTO.ResultDTO newsData = newsDataList.get(position);
        String ip = "http://www.namelesshome.com/";
        String path = newsData.getFilePath();
        new MyTask(holder.newsImage).execute(ip+path);

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

    class MyTask extends AsyncTask<String, Void, Bitmap>{

        private ImageView imageView;

        public MyTask(ImageView imageView) {
            this.imageView = imageView;
        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            Bitmap bitmap = null;
            try {
                String url = strings[0];
                HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
                connection.setDoInput(true);
                connection.connect();
                InputStream is = connection.getInputStream();
                bitmap = BitmapFactory.decodeStream(is);
                is.close();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            imageView.setImageBitmap(bitmap);
        }
    }
}
