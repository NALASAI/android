package com.example.flagmentex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {

    Button btn1;
    Button btn2;

    FragmentOne fragment1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("TAG", "A onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);

        btn1.setOnClickListener(view -> {

            fragment1 = new FragmentOne();

            // 프래그먼트로 데이터를 전달하는 방법
            // 생성자를 통해 전달
            // public 메서드를 통해서 전달
            // 콜백메서드를 활용해서 전달

            // 번들을 통해서 전달하는 방법
            Bundle bundle = new Bundle();
            bundle.putString("param1", "안녕하세요");
            fragment1.setArguments(bundle);

            // 프래그먼트를 동적으로 만들기 위해서 필요한 재료
            // 1. FragmentManager
            // 2. FragmentTransaction : 트랜잭션 => 작업의 단위(시작과 끝이 있다)

            FragmentManager manager = getSupportFragmentManager();// FragmentTransaction 가지고 오는 속성
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.container, fragment1);
            transaction.commit();
            // 끝을 내는 방법 ->
            // commit() : 시간이 될때 완료(시스템에 요청) 정석
            // commitNow() 지금 당장
            // comitAllowingStateLoss(); <-- 위험(커밋이 삭제될 수도 있다)
        });

        btn2.setOnClickListener(view -> {
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.remove(fragment1);
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