package com.example.cardi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ImageViewCompat;
import androidx.viewpager.widget.ViewPager;


public class showcard extends AppCompatActivity {
    Adapter adapter_p;
    Adapter_e adapter_e;
    ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showcard);

        ImageButton btn = (ImageButton)findViewById(R.id.back);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), politics_topic.class);
                startActivity(intent2);
            }
        });

        Intent intent = getIntent();
        String title = intent.getExtras().getString("topic");
        int pne = intent.getExtras().getInt("pne");

        TextView topic = (TextView)findViewById(R.id.topic);
       // TextView news_title = (TextView)findViewById(R.id.news_title);

        if (pne == 0) {
            topic.setBackgroundResource(R.drawable.blue_text);
        }
        else {
            topic.setBackgroundResource(R.drawable.green_text);
        }

        //String news = intent.getExtras().getString("news");
        topic.setText(title);
        //news_title.setText(news);
        //news_title.setSelected(true);

        // 아까 만든 view
        if (pne == 0) {
            viewPager = (ViewPager) findViewById(R.id.view);
            //adapter 초기화
            adapter_p = new Adapter(this);
            viewPager.setAdapter(adapter_p);
        }
        else {
            viewPager = (ViewPager)findViewById(R.id.view);
            //adapter 초기화
            adapter_e = new Adapter_e(this);
            viewPager.setAdapter(adapter_e);
        }
    }


}
