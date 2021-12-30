package com.example.mysharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnSave;
    Button btnLoad;
    Button btnDelete;
    Button btnDeleteAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // 데이터 저장
        
        // 데이터 불러오기
        
        // 데이터 삭제

        initData();
        addEventListener();

        //
//        SharedPreferences sharedPreferences = getSharedPreferences("sp1", MODE_PRIVATE);
        // MODE
        // MODE_PRIVATE : 생성한 어플리케이션에서만 사용 가능
        // MODE_WORLD_READABLE : 모든앱에서 사용가능(단 읽기만 가능)
        // MODE_WORLD_WRITEABLE : 모든앱에서 사용가능(기록도 가능)
        // MODE_APPEND : 기존 sharedPreferences 에 신규로 추가

        // 수정모드로 SharedPreferences 만들어 줘야 한다.
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putString("name", "홍길동");
//        editor.apply(); // 1, 9

        // apply() 와 commit() 차이
        // apply()
        // - 스레드를 블록시키지 않는다.
        // - 비동기 방식
        // - 저장 성공여부 true, false 값을 주지 않는다.

        // commit()
        // - 스레드가 블록된다.
        // - 동기방식
        // - 저장이 성공되면 boolean 타입인 true 값 반환

        // clear()
//        editor.putString();
//        editor.putBoolean();
//        editor.putFloat();
//        editor.putLong();
//        remove
    }

    private void addEventListener() {
        btnSave.setOnClickListener(view -> {
            SharedPreferences.Editor editor = getShared("sp1").edit();
            editor.putString("name", "홍길동");
            editor.putInt("age", 20);
            editor.putBoolean("isMarried", true);
            editor.apply();
        });

        btnLoad.setOnClickListener(view -> {
            SharedPreferences preferences = getShared("sp1");
            String name = getShared("sp1").getString("name", "");
            int age = preferences.getInt("age", 0);
            boolean isMarried = preferences.getBoolean("isMarried", false);
            String tempStr = name + " : " + age + " : " + isMarried;
            Toast.makeText(this, tempStr, Toast.LENGTH_SHORT).show();
        });

        btnDelete.setOnClickListener(view -> {
            getShared("sp1").edit().remove("age").apply();
            
            // 이벤트 리스너 트리거 하기
            btnLoad.callOnClick();
        });

        btnDeleteAll.setOnClickListener(view -> {
            getShared("sp1").edit().clear().apply();
            btnLoad.callOnClick();
        });
    }

    private SharedPreferences getShared(String name) {
        return getSharedPreferences(name, MODE_PRIVATE);
    }

    private void initData() {
        btnSave = findViewById(R.id.btnSave);
        btnLoad = findViewById(R.id.btnLoad);
        btnDelete = findViewById(R.id.btnDelete);
        btnDeleteAll = findViewById(R.id.btnDeleteAll);
    }
}