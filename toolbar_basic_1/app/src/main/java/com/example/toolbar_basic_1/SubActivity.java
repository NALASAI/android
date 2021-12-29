package com.example.toolbar_basic_1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        // 값을 꺼내는 방법
        int value1 = getIntent().getIntExtra("value1", 0);
        Log.d("TAG", "value1 : " + value1);

        Button button = findViewById(R.id.btnend);
        button.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.putExtra("result", value1 + 100);
            setResult(Activity.RESULT_OK, intent);
            finish();
        });
    }
}