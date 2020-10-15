package com.example.cardi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class economics_topic extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.economics_topic);

        TextView tx1 = (TextView)findViewById(R.id.TextView1);

        Intent intent = getIntent();
        final String name = intent.getExtras().getString("title"); /*String형*/
        int topic = intent.getExtras().getInt("topic");
        tx1.setText(name);


        ImageButton button1 = (ImageButton) findViewById(R.id.button1);
        ImageButton button2 = (ImageButton) findViewById(R.id.button2);
        ImageButton button3 = (ImageButton) findViewById(R.id.button3);
        ImageButton button4 = (ImageButton) findViewById(R.id.button4);
        ImageButton button5 = (ImageButton) findViewById(R.id.button5);
        ImageButton button6 = (ImageButton) findViewById(R.id.button6);

        // politics -> economics 로 바꾸기
        switch (topic) {
            case 1:
                button1.setImageResource(R.drawable.economics1_0_0);
                button2.setImageResource(R.drawable.economics1_1_0);
                button3.setImageResource(R.drawable.economics1_2_0);
                button4.setImageResource(R.drawable.economics1_3_0);
                button5.setImageResource(R.drawable.economics1_4_0);
                button6.setImageResource(R.drawable.economics1_5_0);
                break;
            case 2:
                button1.setImageResource(R.drawable.economics2_0_0);
                button2.setImageResource(R.drawable.economics2_1_0);
                button3.setImageResource(R.drawable.economics2_2_0);
                button4.setImageResource(R.drawable.economics2_3_0);
                button5.setImageResource(R.drawable.economics2_4_0);
                button6.setImageResource(R.drawable.economics2_5_0);
                break;
            case 3:
                button1.setImageResource(R.drawable.economics3_0_0);
                button2.setImageResource(R.drawable.economics3_1_0);
                button3.setImageResource(R.drawable.economics3_2_0);
                button4.setImageResource(R.drawable.economics3_3_0);
                button5.setImageResource(R.drawable.economics3_4_0);
                button6.setImageResource(R.drawable.economics3_5_0);
                break;
            case 4:
                button1.setImageResource(R.drawable.economics4_0_0);
                button2.setImageResource(R.drawable.economics4_1_0);
                button3.setImageResource(R.drawable.economics4_2_0);
                button4.setImageResource(R.drawable.economics4_3_0);
                button5.setImageResource(R.drawable.economics4_4_0);
                button6.setImageResource(R.drawable.economics4_5_0);
                break;
            default:
        }

        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), showcard.class);
                intent.putExtra("pne", 1);
                intent.putExtra("topic", name); // 토픽
                intent.putExtra("number", 1); // 기사번호
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), showcard.class);
                intent.putExtra("pne", 1);
                intent.putExtra("topic", name);
                intent.putExtra("number", 2);
                startActivity(intent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), showcard.class);
                intent.putExtra("pne", 1);
                intent.putExtra("topic", name);
                intent.putExtra("number", 3);
                startActivity(intent);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), showcard.class);
                intent.putExtra("pne", 1);
                intent.putExtra("topic", name);
                intent.putExtra("number", 4);
                startActivity(intent);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), showcard.class);
                intent.putExtra("pne", 1);
                intent.putExtra("topic", name);
                intent.putExtra("number", 5);
                startActivity(intent);
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), showcard.class);
                intent.putExtra("pne", 1);
                intent.putExtra("topic", name);
                intent.putExtra("number", 6);
                startActivity(intent);
            }
        });
    }

}
