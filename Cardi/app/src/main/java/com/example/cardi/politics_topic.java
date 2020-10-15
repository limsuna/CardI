package com.example.cardi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


public class politics_topic extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.politics_topic);

        TextView tx1 = (TextView) findViewById(R.id.TextView1);

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

        switch (topic) {
            case 1:
                button1.setImageResource(R.drawable.politics1_0_0);
                button2.setImageResource(R.drawable.politics1_1_0);
                button3.setImageResource(R.drawable.politics1_2_0);
                button4.setImageResource(R.drawable.politics1_3_0);
                button5.setImageResource(R.drawable.politics1_4_0);
                button6.setImageResource(R.drawable.politics1_5_0);
                break;
            case 2:
                button1.setImageResource(R.drawable.politics2_0_0);
                button2.setImageResource(R.drawable.politics2_1_0);
                button3.setImageResource(R.drawable.politics2_2_0);
                button4.setImageResource(R.drawable.politics2_3_0);
                button5.setImageResource(R.drawable.politics2_4_0);
                button6.setImageResource(R.drawable.politics2_5_0);
                break;
            case 3:
                button1.setImageResource(R.drawable.politics3_0_0);
                button2.setImageResource(R.drawable.politics3_1_0);
                button3.setImageResource(R.drawable.politics3_2_0);
                button4.setImageResource(R.drawable.politics3_3_0);
                button5.setImageResource(R.drawable.politics3_4_0);
                button6.setImageResource(R.drawable.politics3_5_0);
                break;
            case 4:
                button1.setImageResource(R.drawable.politics4_0_0);
                button2.setImageResource(R.drawable.politics4_1_0);
                button3.setImageResource(R.drawable.politics4_2_0);
                button4.setImageResource(R.drawable.politics4_3_0);
                button5.setImageResource(R.drawable.politics4_4_0);
                button6.setImageResource(R.drawable.politics4_5_0);
                break;
            default:

        }

        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), showcard.class);
                intent.putExtra("pne", 0); // 정치 or 경제
                intent.putExtra("topic", name); // 토픽
                intent.putExtra("number", 1); // 기사번호
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), showcard.class);
                intent.putExtra("pne", 0);
                intent.putExtra("topic", name);
                intent.putExtra("number", 2);
                startActivity(intent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), showcard.class);
                intent.putExtra("pne", 0);
                intent.putExtra("topic", name);
                intent.putExtra("number", 3);
                startActivity(intent);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), showcard.class);
                intent.putExtra("pne", 0);
                intent.putExtra("topic", name);
                intent.putExtra("number", 4);
                startActivity(intent);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), showcard.class);
                intent.putExtra("pne", 0);
                intent.putExtra("topic", name);
                intent.putExtra("number", 5);
                startActivity(intent);
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), showcard.class);
                intent.putExtra("pne", 0);
                intent.putExtra("topic", name);
                intent.putExtra("number", 6);
                startActivity(intent);
            }
        });

    }
}
