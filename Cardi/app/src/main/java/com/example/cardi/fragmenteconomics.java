package com.example.cardi;


import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class fragmenteconomics extends Fragment {
    // Store instance variables
    private String title;
    private int page;

    // newInstance constructor for creating fragment with arguments
    public static fragmenteconomics newInstance(int page, String title) {
        fragmenteconomics fragment = new fragmenteconomics();
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
        View view = inflater.inflate(R.layout.fragment_economics, container, false);

        Button button = (Button) view.findViewById(R.id.button);
        Button button2 = (Button) view.findViewById(R.id.button2);
        Button button3 = (Button) view.findViewById(R.id.button3);
        Button button4 = (Button) view.findViewById(R.id.button4);

        final String s1 = "한일 수출규제";
        final String s2 = "두산중공업 유동성 위기";
        final String s3 = "라임펀드 사태";
        final String s4 = "3기 신도시 개발";

        button.setText("#\n"+s1);
        button2.setText("#\n"+s2);
        button3.setText("#\n"+s3);
        button4.setText("#\n"+s4);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), economics_topic.class);
                intent.putExtra("title", s1);
                intent.putExtra("topic", 1);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), economics_topic.class);
                intent.putExtra("title", s2);
                intent.putExtra("topic", 2);
                startActivity(intent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), economics_topic.class);
                intent.putExtra("title", s3);
                intent.putExtra("topic", 3);
                startActivity(intent);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), economics_topic.class);
                intent.putExtra("title", s4);
                intent.putExtra("topic", 4);
                startActivity(intent);
            }
        });

        return view;
    }
}