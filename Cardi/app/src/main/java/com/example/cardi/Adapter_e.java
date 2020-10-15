package com.example.cardi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.viewpager.widget.PagerAdapter;

public class Adapter_e extends PagerAdapter {

    private int[] images = {R.drawable.economics1_0_0, R.drawable.economics1_0_1, R.drawable.economics1_0_2,
    R.drawable.economics1_0_3, R.drawable.economics1_0_4, R.drawable.economics1_0_5};

    private LayoutInflater inflater;
    private Context context;

    public Adapter_e(Context context){
        this.context = context;
    }



    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((View)object);
    }

    public Object instantiateItem(ViewGroup container, int position) {
        //초기화
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.slider, container, false);
        ImageView imageView = (ImageView)v.findViewById(R.id.imageView);
        imageView.setImageResource(images[position]);
        container.addView(v);
        return v;
    }

    //할당을 해제
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.invalidate();
    }


}
