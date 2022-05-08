package com.example.a10119232latihan4;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

/*M Faisal Obara
10119232
IF 6
06 Mei 2022*/

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context){
        this.context = context;
    }

    // Arrays
    public int[] slide_image = {
            R.drawable.logo_example1,
            R.drawable.logo_example2,
            R.drawable.logo_example3
    };

    public int[] slide_header = {
            R.string.header1,
            R.string.header2,
            R.string.header3
    };

    @Override
    public int getCount() {
        return slide_header.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.logo);
        TextView slideHeader = (TextView) view.findViewById(R.id.header);

        slideImageView.setImageResource(slide_image[position]);
        slideHeader.setText(slide_header[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((RelativeLayout) object);


    }
}
