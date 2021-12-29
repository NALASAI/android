package com.example.a03_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView zero;
    TextView one;
    TextView two;
    TextView three;
    TextView four;
    TextView five;
    TextView six;
    TextView seven;
    TextView eight;
    TextView nine;
    TextView ca;
    TextView plus;
    TextView result;

    // new -> old
    String newValue = "0";
    String oldValue = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        addEventListener();
    }

    private void initData(){
        // xml 파일에 있는 변수를 초기화 한다.(값을 넣다)
        zero = findViewById(R.id.zero);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        ca = findViewById(R.id.ca);
        plus = findViewById(R.id.plus);
        result = findViewById(R.id.result);
    }

    private void addEventListener(){
        // 이벤트 리스트 등록(람다 포현식)
        zero.setOnClickListener(view -> {
            Log.d("TAG", "zero Click");
            newValue = newValue + "0";
            result.setText(newValue);
        });

        one.setOnClickListener(view -> {
            Log.d("TAG", "one Click");
            newValue = newValue + "1";
            result.setText(newValue);
        });

        two.setOnClickListener(view -> {
            Log.d("TAG", "two Click");
            newValue = newValue + "2";
            result.setText(newValue);
        });

        three.setOnClickListener(view -> {
            Log.d("TAG", "three Click");
            newValue = newValue + "3";
            result.setText(newValue);
        });

        four.setOnClickListener(view -> {
            Log.d("TAG", "four Click");
            newValue = newValue + "4";
            result.setText(newValue);
        });

        five.setOnClickListener(view -> {
            Log.d("TAG", "five Click");
            newValue = newValue + "5";
            result.setText(newValue);
        });

        six.setOnClickListener(view -> {
            Log.d("TAG", "six Click");
            newValue = newValue + "6";
            result.setText(newValue);
        });

        seven.setOnClickListener(view -> {
            Log.d("TAG", "seven Click");
            newValue = newValue + "7";
            result.setText(newValue);
        });

        eight.setOnClickListener(view -> {
            Log.d("TAG", "eight Click");
            newValue = newValue + "8";
            result.setText(newValue);
        });

        nine.setOnClickListener(view -> {
            Log.d("TAG", "nine Click");
            newValue = newValue + "9";
            result.setText(newValue);
        });

        ca.setOnClickListener(view -> {
            Log.d("TAG", "ca Click");
            newValue = "0";
            oldValue = "0";
            result.setText(newValue);
        });

        plus.setOnClickListener(view -> {
            // "임의 값"
            // "임의 값" == oldValue
            // result => 초기화
            // newValue = "0";
            // "임의 값"
            // "임의 값" == newValue
            // oldValue + newValue
            // result 셋팅
            Log.d("TAG", "plus Click");
            int number1 = Integer.parseInt(oldValue);
            int number2 = Integer.parseInt(newValue);
            int sum = number1 + number2;

            oldValue = String.valueOf(sum); // sum 값을 valueOf 를 통해 String 형태로 변환
            newValue = "0";

            result.setText(oldValue);
        });
    }
}