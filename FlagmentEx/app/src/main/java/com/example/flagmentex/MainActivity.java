package com.example.flagmentex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnCreateFragment;
    Button btnRemoveFragment;

    FragmentOne fragmentOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("TAG", "A onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. 코드로 프래그먼트 생성하기
        btnCreateFragment = findViewById(R.id.btnCreateFragment);
        btnRemoveFragment = findViewById(R.id.btnRemoveFragment);

        btnCreateFragment.setOnClickListener(view -> {

            fragmentOne = new FragmentOne();

            // 프래그먼트를 동적으로 만들기 위해서 필요한 재료
            // 1. FragmentManager
            // 2. FragmentTransaction : 트랜잭션이란 -> 작업에 단위(시작과 끝이 있다)

            FragmentManager manager = getSupportFragmentManager(); // FragmentTransaction 가지고 오는 녀석
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.fragmentContainer, fragmentOne);
            transaction.commit();
            // 끝을 내는 방법
            // commit() : 종료 (시스템에 요청) 정석
            // commitNow() : 바로 종료
            // commitAllowingStateLoss(); : 커밋이 삭제될 수도 있다.
        });

        btnRemoveFragment.setOnClickListener(view -> {

            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.remove(fragmentOne);
            transaction.commit();
        });
    }

    @Override
    protected void onStart() {
        Log.d("TAG", "A onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d("TAG", "A onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d("TAG", "A onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d("TAG", "A onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("TAG", "A onDestroy");
        super.onDestroy();
    }


}