package com.example.mylistview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mylistview.models.Food;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        
        // 직렬화로 객체를 넘겨 받았으면 역직렬화를 해줘야 한다.
        // 역질렬화 : 데이터를 본래의 객체로 되돌리는 작업
        if(getIntent() != null){
            Food food = (Food)getIntent().getSerializableExtra("serialObj");
        }
    }
}
