package com.example.myrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.myrecyclerview.adapter.FoodListViewAdapter;
import com.example.myrecyclerview.models.Food;

/*
* RecyclerView
* 장점
* - ListView 개선판(ViewHolder 개념 포함)
* - 유연하다 : LayoutManager(수평으로 리스트를 만들기 쉽다)
* - Linear, Grid, 스태거드그리드 타입으로도 만들 수 있다.
*
* 1. 라이브러리 추가
* 2. itemView xml 파일 생성
* 3. Adapter 클래스 생성
* 4. LayoutManager 생성 및 연결
* */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        // 어댑터 클래스를 만들어 준다.
        FoodListViewAdapter adapter = new FoodListViewAdapter(Food.getSampleData(), this, position -> {
//            Toast.makeText(this, "return value : " + position, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, DetailActivity.class);
            startActivity(intent);
        });
        // recyclerView 뷰에 어댑터를 연결해 준다.
        recyclerView.setAdapter(adapter);

        // 2. 레이아웃 매니저 생성
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
//        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, LinearLayout.VERTICAL);

        // recyclerView 뷰에 매니저를 셋팅한다.
        recyclerView.setLayoutManager(layoutManager);

        // divider 생성해보기
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, layoutManager.getOrientation());
        // divider 장착 <-- recyclerView
        recyclerView.addItemDecoration(dividerItemDecoration);

    }
}