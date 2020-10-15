package com.example.cardi;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class fragmentpolitics extends Fragment {
    // Store instance variables
    private String title;
    private int page;

    // newInstance constructor for creating fragment with arguments
    public static fragmentpolitics newInstance(int page, String title) {
        fragmentpolitics fragment = new fragmentpolitics();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragment.setArguments(args);
        return fragment;
    }


    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");


    }


    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_politics, container, false);

        //세부토픽으로 전환하기 위한 Intent
        Button button = (Button) view.findViewById(R.id.button);
        Button button2 = (Button) view.findViewById(R.id.button2);
        Button button3 = (Button) view.findViewById(R.id.button3);
        Button button4 = (Button) view.findViewById(R.id.button4);

        final String s1 = "김정은 건강이상설 해프닝";
        final String s2 = "한미 방위비 협상";
        final String s3 = "공수처 설치 추진";
        final String s4 = "北, 발사체 발사";

        button.setText("#\n"+s1);
        button2.setText("#\n"+s2);
        button3.setText("#\n"+s3);
        button4.setText("#\n"+s4);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), politics_topic.class);
                intent.putExtra("title", s1);
                intent.putExtra("topic", 1);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), politics_topic.class);
                intent.putExtra("title", s2);
                intent.putExtra("topic", 2);
                startActivity(intent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), politics_topic.class);
                intent.putExtra("title", s3);
                intent.putExtra("topic", 3);
                startActivity(intent);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), politics_topic.class);
                intent.putExtra("title", s4);
                intent.putExtra("topic", 4);
                startActivity(intent);
            }
        });

        return view;
    }
}