package com.example.mylottoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private final Set<Integer> pickerNumberSet = new HashSet<>();
    private Button plus;
    private Button reset;
    private Button play;
    private NumberPicker numberPicker;
    private final ArrayList<TextView> numberTextViewList = new ArrayList<>();
    private boolean didRun = false;

    private static final String TAG = MainActivity.class.getName();

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        getRandomNumber();
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        addEventListener();
    }

    private void addEventListener() {
        // 번호 추가하기 이벤트 처리
        plus.setOnClickListener(view -> {
            int selectNumber = numberPicker.getValue();

            // 데이터 초기화 여부 확인
            if(didRun){
                Toast.makeText(this, "초기화 후에 다시 실행해주세요", Toast.LENGTH_SHORT).show();
                return;
            }

            // 번호는 5개 까지만 선택 가능하다
            if(pickerNumberSet.size() >= 5){
                Toast.makeText(this, "번호는 5개까지만 선택 가능합니다.", Toast.LENGTH_SHORT).show();
                return;
            }
            
            // 동일한 숫자가 포함되었는지 여부 확인
            if(pickerNumberSet.contains(selectNumber)){
                Toast.makeText(this, "이미 선택한 번호입니다.", Toast.LENGTH_SHORT).show();
                return;
            }

            Log.d(TAG, "selectedNumber : " + selectNumber);
            // 게임모드 완료 여부 확인

            // 사용자가 선택한 번호를 자료 구조에 넣기
            TextView textView = numberTextViewList.get(pickerNumberSet.size());
            textView.setVisibility(View.VISIBLE);
            textView.setText(String.valueOf(selectNumber));
            // todo -> 동적으로 drawable setting

            // 자료구조에 선택한 번호를 저장 완료
            pickerNumberSet.add(selectNumber);

        });

        // 초기화 하기 이벤트 처리
        reset.setOnClickListener(view -> {
            didRun = false;
            pickerNumberSet.clear();
            for (TextView tv : numberTextViewList){
                tv.setVisibility(View.GONE);
            }
        });

        // 게임 실행하기 이벤트 처리
        play.setOnClickListener(view -> {
            List<Integer> list = getRandomNumber();

            // numberPickerSet 에 저장된 값 더하기
            list.addAll(pickerNumberSet);
            Collections.sort(list);
            Log.d(TAG, list.toString());

            didRun = true;

            for(int i = 0; i < list.size(); i++){
                numberTextViewList.get(i).setText(String.valueOf(list.get(i)));
                numberTextViewList.get(i).setVisibility(View.VISIBLE);
                numberTextViewList.get(i).setBackground(setTextViewBackground(list.get(i)));
            }

        });
    }

    private void initData(){
        plus = findViewById(R.id.plus);
        reset = findViewById(R.id.reset);
        play = findViewById(R.id.play);

        numberPicker = findViewById(R.id.numberPicker);
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(45);

        numberTextViewList.add(findViewById(R.id.textView1));
        numberTextViewList.add(findViewById(R.id.textView2));
        numberTextViewList.add(findViewById(R.id.textView3));
        numberTextViewList.add(findViewById(R.id.textView4));
        numberTextViewList.add(findViewById(R.id.textView5));
        numberTextViewList.add(findViewById(R.id.textView6));
    }

    /*
    * Context
    * 역할 --> ActivityManagerService() 에 접근할 수 있는 기능
    * --> 주변 정보
    *
    *
    * 종류
    *  - activity 에서 context
    *  - ApplicationContext =>
    * 
    * */
    private Drawable setTextViewBackground(int number){
        Drawable drawable;
        // Drawable Resource 가져오는 방법
        // todo : 1 ~ 10, 11 ~ 20, 21 ~ 30, 31 ~ 45 : 색상을 다르게 변경
        if(number >= 1 && number <= 10){
            drawable = ContextCompat.getDrawable(this, R.drawable.round_background);
        } else if(number >= 11 && number <= 20){
            drawable = ContextCompat.getDrawable(this, R.drawable.round_background_2);
        } else if(number >= 21 && number <= 30){
            drawable = ContextCompat.getDrawable(this, R.drawable.round_background_3);
        }else{
            drawable = ContextCompat.getDrawable(this, R.drawable.round_background_4);
        }


        return drawable;
    }

    // 2중 for 문
    private void getRandomNumber1(){
        Random random = new Random();
        int number = random.nextInt(45) + 1; // 0 ~ 44 --> 1 ~ 45
        int[] lottoNumber = new int[6];
        Log.d("TAG", "number : " + number);

        // 실제 로또 넘버 생성
        for(int i = 0; i < lottoNumber.length; i++){
            int selectedNumber = random.nextInt(45) + 1;
            lottoNumber[i] = selectedNumber;
            // 중복된 값이 있는지 확인
            for(int j = 0; j < i; j++){
                if(lottoNumber[j] == lottoNumber[i]){
                    i = i - 1;
                    break;
                }
            }
        }
        Arrays.sort(lottoNumber);
        for(int i = 0; i < lottoNumber.length; i++){
            Log.d("TAG", "number" + i + " : " + lottoNumber[i]);
        }
    }
    
    // while
    private void getRandomNumber2(){
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        while(list.size() < 6){
            int number = random.nextInt(45) + 1;
            if(list.contains(number)){
                continue;
            }
            list.add(number);
        }
        Collections.sort(list);
        Log.d("TAG", list.toString());
    }
    
    // 전체 1 ~ 45 까지 선택
    private List<Integer> getRandomNumber(){
        ArrayList<Integer> numberList = new ArrayList<>();
        for(int i = 1; i < 46; i++){

            numberList.add(i);
        }
        Collections.shuffle(numberList);
        Log.d("TAG", numberList.toString());

        return numberList.subList(0, (6 - pickerNumberSet.size()));
    }
}