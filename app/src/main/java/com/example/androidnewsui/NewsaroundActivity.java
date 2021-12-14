package com.example.androidnewsui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class NewsaroundActivity extends AppCompatActivity {
//    private List<NewsData> mData = null;
//    private Context mContext;
//    private MyAdapter mAdapter = null;
//    private LinearLayout ly_content;
    private ListView list_one;
    private String texts []=new  String[]{"新闻1","新闻2","新闻3","新闻4","新闻5"};
    private int imgIds[]=new  int[]{R.drawable.news_1,R.drawable.news_2,R.drawable.news_3,R.drawable.news_4,R.drawable.news_5,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsaround);
//        mContext = NewsaroundActivity.this;
        list_one = findViewById(R.id.list_item);
        List<Map<String,Object>> listItem=new ArrayList<Map<String,Object>>();
        for (int i=0;i<texts.length;i++) {
            Map<String, Object> showItem = new HashMap<String, Object>();
            showItem.put("imgtou", imgIds[i]);
            showItem.put("words", texts[i]);
            listItem.add(showItem);
        }

//        //动态加载顶部View和底部View
//        final LayoutInflater inflater = LayoutInflater.from(this);
//        View headView = inflater.inflate(R.layout.view_header, null, false);
//        View footView = inflater.inflate(R.layout.view_footer, null, false);
//        mData = new LinkedList<NewsData>();
//        mData.add(new NewsData(1,"新闻1"));
//        mData.add(new NewsData(2,"新闻2"));
//        mData.add(new NewsData(3,"新闻3"));
//        mData.add(new NewsData(4,"新闻4"));
//        mData.add(new NewsData(5,"新闻5"));
//        mAdapter = new MyAdapter(mContext,((LinkedList<NewsData>)mData));
//        //添加表头和表尾需要写在setAdapter方法调用之前！！！
//        list_one.addHeaderView(headView);
//        list_one.addFooterView(footView);
//
//        list_one.setAdapter(mAdapter);
//        list_one.setOnItemClickListener(this);
        SimpleAdapter myAdapter =new SimpleAdapter(getApplicationContext(),listItem,R.layout.item_list,new String[]{"imgIds","texts"},new int[]{R.id.img_news,R.id.txt_news}) ;
        ListView listView=findViewById(R.id.list_item);
        listView.setAdapter(myAdapter);
    }
//    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        Toast.makeText(mContext,"你点击了第" + position + "项",Toast.LENGTH_SHORT).show();
//    }
}