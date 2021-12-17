package com.example.androidnewsui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.androidnewsui.R;
import com.example.androidnewsui.entry.New;
import com.example.androidnewsui.entry.NewsData;
import com.example.androidnewsui.fragment.NewsContentFragment;

import java.util.ArrayList;
import java.util.List;

public class NewsContentActivity extends AppCompatActivity {
    List<New> newsList = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_content);
        initNews();
        String title=this.getIntent().getStringExtra("news_title");
        String content=this.getIntent().getStringExtra("news_content");
        if (title!=null && content!=null){
            FragmentManager fragmentManager=this.getSupportFragmentManager();
            NewsContentFragment fragment= (NewsContentFragment) fragmentManager.findFragmentById(R.id.newsContentFrag);
            fragment.refresh(title,content);
        }
    }

    public static void actionStart(Context context, String title,String content){
        Intent intent=new Intent(context,NewsContentActivity.class);
        intent.putExtra("news_title",title);
        intent.putExtra("news_content",content);
        context.startActivity(intent);
    }

    //初始化数据
    private void initNews() {
        for (int i = 0; i < 2; i++) {
            New news_1 = new New("第一观察丨从三个关键词深悟总书记的“文艺观”","12月14日，中国文联第十一次全国代表大会、中国作协第十次全国代表大会在京开幕，习近平总书记出席大会并发表重要讲话。\n" +
                    "\n" +
                    "　　文艺事业是党和人民的重要事业，文艺战线是党和人民的重要战线。建党百年之际，在党的十九届六中全会后召开的这场文艺界盛会，其意义不言而喻。\n" +
                    "\n" +
                    "　　在北京人民大会堂，习近平总书记面向全国文艺工作者代表等发表的重要讲话，站在民族复兴的高度对做好新时代文艺工作提出许多新的重要思想和重大判断，对广大文艺工作者提出5点殷切希望。\n" +
                    "\n" +
                    "　　党的十八大以来，习近平总书记针对文艺发展的关键问题，作出系列重要论述和决策部署，为推动社会主义文艺繁荣发展提供了根本遵循。\n" +
                    "\n" +
                    "　　有三个关键词，始终贯穿于总书记的“文艺观”之中。");
           newsList.add(news_1);
            New news_2 = new New("31省区市新增确诊病例76例 其中本土病例56例","12月16日0—24时，31个省（自治区、直辖市）和新疆生产建设兵团报告新增确诊病例76例。" +
                    "\n" +
                    "其中境外输入病例20例（广西7例，云南5例，广东4例，上海3例，北京1例）；本土病例56例（浙江44例，其中绍兴市40例、杭州市2例、宁波市2例；陕西5例，其中西安市4例、延安市1例；" +
                    "\n" +
                    "内蒙古4例，均在呼伦贝尔市；广东2例，其中广州市1例、东莞市1例；四川1例，在成都市）。" +
                    "\n" +
                    "无新增死亡病例。新增疑似病例3例，均为境外输入病例（均在上海）。");
            newsList.add(news_2);
            New news_3 = new New("美国参议院批准尼古拉斯-伯恩斯为新任美驻华大使","综合路透社和法新社消息，当地时间16日，美国参议院投票通过了尼古拉斯·伯恩斯（Nicholas Burns）担任美驻华大使一职的任命，填补了该职位一年多以来的空缺。（央视记者 殷岳）");
            newsList.add(news_2);
            New news_4 = new New();
            newsList.add(news_2);
            New news_5 = new New();
            newsList.add(news_2);
            New news_6 = new New();
            newsList.add(news_2);
        }
    }
}
