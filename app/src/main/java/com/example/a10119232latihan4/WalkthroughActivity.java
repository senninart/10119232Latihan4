package com.example.a10119232latihan4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.transition.Slide;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/*M Faisal Obara
10119232
IF 6
06 Mei 2022*/

public class WalkthroughActivity extends AppCompatActivity {

    private ViewPager mSlideViewPager;
    private LinearLayout mDotLayout;

    private TextView[] mDots;

    private SliderAdapter sliderAdapter;

    private Button mBtnNext;
    private Button mBtnBack;

    private int mCurrentPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walkthrough);

        mSlideViewPager = (ViewPager) findViewById(R.id.slideViewPager);
        mDotLayout = (LinearLayout) findViewById(R.id.dotsLayout);
        mBtnNext = (Button) findViewById(R.id.btnNext);
        mBtnBack = (Button) findViewById(R.id.btnBack);

        sliderAdapter = new SliderAdapter(this);

        mSlideViewPager.setAdapter(sliderAdapter);

        addDotsIndicator(0);

        mSlideViewPager.addOnPageChangeListener(viewListener);

        // OnClickListeners

        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // FINISH BUTTON
                if  (mCurrentPage == mDots.length - 1) {
                    Intent intent = new Intent(WalkthroughActivity.this, Home.class);
                    startActivity(intent);
                    finish();
                } else {
                    mSlideViewPager.setCurrentItem(mCurrentPage + 1);
                }
            }
        });

        mBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSlideViewPager.setCurrentItem(mCurrentPage - 1);
            }
        });

    }

    public void addDotsIndicator(int position){
        mDots = new TextView[3];
        mDotLayout.removeAllViews();

        for(int i = 0; i < mDots.length; i++){
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.whitetransparent));

            mDotLayout.addView(mDots[i]);
        }

        if (mDots.length > 0){
            mDots[position].setTextColor(getResources().getColor(R.color.white));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener(){

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int i) {
            addDotsIndicator(i);

            mCurrentPage = i;

            if (i == 0) {
                mBtnBack.setVisibility(View.INVISIBLE);
                mBtnNext.setEnabled(true);
                mBtnBack.setEnabled(false);

                mBtnNext.setText(R.string.next);
            }
            else if (i == mDots.length - 1){
                mBtnBack.setVisibility(View.VISIBLE);
                mBtnNext.setEnabled(true);
                mBtnBack.setEnabled(true);

                mBtnNext.setText(R.string.finish);
                mBtnBack.setText(R.string.back);
            } else {
                mBtnBack.setVisibility(View.VISIBLE);
                mBtnNext.setEnabled(true);
                mBtnBack.setEnabled(true);

                mBtnNext.setText(R.string.next);
                mBtnBack.setText(R.string.back);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private int getItem(int i) {
        return mSlideViewPager.getCurrentItem();
    }
}