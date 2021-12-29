package com.example.myviewpager2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.myviewpager2.adapter.ImageSliderAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 sliderImageViewPager;
    private ArrayList<String> images = new ArrayList<>();
    private LinearLayout layoutIndicators;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layoutIndicators = findViewById(R.id.layoutIndicators);

        // setup sample data
        images.add("https://cdn.pixabay.com/photo/2021/12/05/17/16/new-years-day-6848235__340.jpg");
        images.add("https://cdn.pixabay.com/photo/2021/11/29/20/08/happy-new-year-6833712__340.jpg");
        images.add("https://cdn.pixabay.com/photo/2019/11/27/12/23/clock-4656853__340.jpg");
        images.add("https://cdn.pixabay.com/photo/2021/12/07/09/33/happy-new-year-6852726__340.jpg");

        // xml 파일에서 주소값 들고 오기
        sliderImageViewPager = findViewById(R.id.sliderViewPager2);
        // viewPager2 도 어댑터가 필요하다
        sliderImageViewPager.setAdapter(new ImageSliderAdapter(this, images));

        sliderImageViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                Log.d("TAG", "position " + position);
                setCurrentIndicator(position);
            }
        });
        
        // 기본 인디케이터 셋팅
        setupIndicators(images.size());

    }// end of onCreated

    private void setupIndicators(int count){
        // 배열 선언
        ImageView[] indicators = new ImageView[count];

        // LayoutParams
        // 뷰가 어떻게 배치 될지를 정의하는 속성
        // xml 파일에서 layout_붙는 속성들을 말하며 코드상에서 LayoutParams 객체를 통해 파라미터 속성을 다룰 수 있다.
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        params.setMargins(16, 8, 16, 8);

        for(int i = 0; i < indicators.length; i++){
            indicators[i] = new ImageView(this);
            indicators[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.bg_indicator_inactive));
            indicators[i].setLayoutParams(params);

            // addView
            layoutIndicators.addView(indicators[i]);
        }
    }

    private void setCurrentIndicator(int position){
        int childCount = layoutIndicators.getChildCount();
        for(int i = 0; i < childCount; i++){
            ImageView imageView = (ImageView) layoutIndicators.getChildAt(i);
            if(i == position){
                imageView.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.bg_indicator_active));
            }else{
                imageView.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.bg_indicator_inactive));
            }
        }
    }

}