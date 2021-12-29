package com.example.mylistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.mylistview.adapter.FoodListAdapter;
import com.example.mylistview.models.Food;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FoodListAdapter foodListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get sample data
        ArrayList<Food> foods = Food.getSampleData();

        // 1. Adapter 를 만들어 줘야 한다.
        foodListAdapter = new FoodListAdapter(foods, this);
        // 2. ListView(xml 파일 : adapter 셋팅)
        ListView listView = findViewById(R.id.foodListView);

        // 설정
        listView.setAdapter(foodListAdapter);

        // 이벤트 리스너 사용방법
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("TAG", "selected : " + i);
                Intent intent = new Intent(view.getContext(), DetailActivity.class);
                intent.putExtra("serialObj", foods.get(i));
                startActivity(intent);
            }
        });
    }
}