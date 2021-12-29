package com.example.secretdiary;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class DiaryActivity extends AppCompatActivity {

    EditText diaryEditText;
    Handler handler = new Handler(Looper.getMainLooper());
    Runnable runnable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);
        initData();
        setInitData();
        addEventListener();
    }

    private void initData() {
        diaryEditText = findViewById(R.id.diaryEditText);
        // thread 기능 구현
        runnable = getRunnable();
    }

    private void setInitData() {
        SharedPreferences detailPreferences = getSharedPreferences("diary", Context.MODE_PRIVATE);
        diaryEditText.setText(detailPreferences.getString("detail", ""));
    }

    // 이벤트 리스너 등록
    private void addEventListener() {

        diaryEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                handler.removeCallbacks(runnable);
                handler.postDelayed(runnable, 500);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private Runnable getRunnable() {
        Runnable runnable = () -> {
            SharedPreferences preferences = getSharedPreferences("diary", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("detail", diaryEditText.getText().toString());
            editor.apply();
        };
        return runnable;
    }

}
