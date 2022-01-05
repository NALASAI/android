package com.example.mymovie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    MoviesFragment moviesFragment;
    MyInfoFragment myInfoFragment;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        addEventListener();
    }

    private void addMoviesFragment(){
        // 동적으로 프래그먼트 만드는 방법
        moviesFragment = MoviesFragment.newInstance();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.mainContainer, moviesFragment);
        transaction.commit();
    }

    private void addMyInfoFragment(){
        myInfoFragment = MyInfoFragment.newInstance();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.mainContainer, myInfoFragment);
        transaction.commit();
    }

    private void initData() {
        bottomNavigationView = findViewById(R.id.bottom_navigation);
    }

    private void addEventListener() {
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch(item.getItemId()){
                case R.id.page_1:
                    addMoviesFragment();
                    Log.d("TAG", "page_1");
                    break;
                case R.id.page_2:
                    addMyInfoFragment();
                    Log.d("TAG", "page_2");
                    break;
            }
            return true;
        });
    }
}