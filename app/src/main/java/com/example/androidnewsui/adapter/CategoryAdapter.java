package com.example.androidnewsui.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.example.androidnewsui.R;
import com.example.androidnewsui.activity.MainActivity;
import com.example.androidnewsui.activity.NewsCategoryActivity;
import com.example.androidnewsui.base.Category;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder>{

    private List<Category.DataDTO.ResultDTO> categoryList;

    private Context mContext = null;

    // 构造器


    public CategoryAdapter(List<Category.DataDTO.ResultDTO> categoryList, Context mContext) {
        this.categoryList = categoryList;
        this.mContext = mContext;
    }

    //
    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_item,
                parent, false);
        ViewHolder holder = new ViewHolder(view);
        holder.newsCategoryView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Category.DataDTO.ResultDTO category = categoryList.get(position);
                Toast.makeText(v.getContext(),
                        "you clicked view " + category.getName(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(mContext,NewsCategoryActivity.class);
                intent.putExtra("id",category.getId());
                intent.putExtra("message","listNewsByCategory");
                mContext.startActivity(intent);
            }
        });
        return holder;
    }

    // 为每个新闻类别绑定数据
    @Override
    public void onBindViewHolder( CategoryAdapter.ViewHolder holder, int position) {
        Category.DataDTO.ResultDTO category = categoryList.get(position);
        holder.newsCategory.setText(category.getName());
    }

    // 统计新闻类别数量
    @Override
    public int getItemCount() {
        return categoryList.size();
    }
    //为每个类别绑定点击事件
    public class ViewHolder extends RecyclerView.ViewHolder {
        View newsCategoryView;
        TextView newsCategory;
        public ViewHolder( View view) {
            super(view);
            newsCategoryView =view;
            newsCategory = (TextView) view.findViewById(R.id.category);
        }
    }
}
