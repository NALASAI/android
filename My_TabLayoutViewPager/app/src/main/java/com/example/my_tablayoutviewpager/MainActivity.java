package com.example.my_tablayoutviewpager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.tabs.TabLayout;

/*
* pager(종이 넘기듯이 화면을 넘겨 주는 역할)
* - Adapter 가 필요하다
*
* TabLayout
* - tab 을 담당하는 역할
*
* = 보통 같이 작성을 하지만 필요하다면 따로 따로 만들어도 된다.
*
* 리스너
* - pager 와 TabLayout 을 연결해 줄 때 필요하다.
*
* */
public class MainActivity extends AppCompatActivity {

    static final int TAB_COUNT = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("One"));
        tabLayout.addTab(tabLayout.newTab().setText("Two"));
        tabLayout.addTab(tabLayout.newTab().setText("Three"));

        ViewPager viewPager = findViewById(R.id.viewPager);
        // 어댑터 생성
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(), TAB_COUNT);
        viewPager.setAdapter(pagerAdapter);
        
        // tabLayout 이벤트시 viewPager 연동처리
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                Log.d("TAG", "position : " + position);
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        // viewPager 이벤트시 tabLayout 연동처리
        viewPager.addOnPageChangeListener(
                new TabLayout.TabLayoutOnPageChangeListener(tabLayout)
        );

    }
}

class PagerAdapter extends FragmentPagerAdapter{

    public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;

        switch (position){
            case 0:
                Log.d("TAG", "fragment 0");
                fragment = new FragmentOne();
                break;
            case 1:
                Log.d("TAG", "fragment 1");
                fragment = new FragmentTwo();
                break;
            case 2:
                Log.d("TAG", "fragment 2");
                fragment = new FragmentThree();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
}