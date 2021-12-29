package com.example.secretdiary;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private NumberPicker numberPicker1;
    private NumberPicker numberPicker2;
    private NumberPicker numberPicker3;
    private Button openButton;
    private Button changePasswordButton;

    private boolean changePasswordMode = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        addEventListener();
    }

    private void initData() {
        numberPicker1 = findViewById(R.id.numberPicker1);
        numberPicker2 = findViewById(R.id.numberPicker2);
        numberPicker3 = findViewById(R.id.numberPicker3);

        numberPicker1.setMinValue(0);
        numberPicker1.setMaxValue(9);

        numberPicker2.setMinValue(0);
        numberPicker2.setMaxValue(9);

        numberPicker3.setMinValue(0);
        numberPicker3.setMaxValue(9);

        openButton = findViewById(R.id.openButton);
        changePasswordButton = findViewById(R.id.changePasswordButton);
    }

    private void addEventListener() {

        openButton.setOnClickListener(view -> {
            if(changePasswordMode){
                Toast.makeText(this, "비밀번호 변경중 입니다", Toast.LENGTH_SHORT).show();
                return;
            }

            SharedPreferences sharedPreferences = getSharedPreferences("password", Context.MODE_PRIVATE);
            String passwordForUser = "" + numberPicker1.getValue() + numberPicker2.getValue() + numberPicker3.getValue();

            if(sharedPreferences.getString("password", "000").equals(passwordForUser)){
                // 성공
                Intent intent = new Intent(this, DiaryActivity.class);
                startActivity(intent);
            }else{
                // 실패
                showErrorAlertDialog();
            }
        });

        changePasswordButton.setOnClickListener(view -> {

            // todo 비밀번호 저장 기능
            // 파일에 저장하는 방법
            SharedPreferences passwordPreferences = getSharedPreferences("password", Context.MODE_PRIVATE);

            // 비밀번호를 화면에서 가져온다.
            String passwordForUser = "" + numberPicker1.getValue() + numberPicker2.getValue() + numberPicker3.getValue();
            Log.d("TAG", passwordForUser);

            if (changePasswordMode) {
                // todo 비밀번호 저장하는 기술
                SharedPreferences.Editor editor = passwordPreferences.edit();
                editor.putString("password", passwordForUser);
                // apply(비동기 방식), commit(UI 맞추고 기다리는 방식)
                editor.apply();
                changePasswordButton.setBackgroundColor(Color.BLACK);
                changePasswordMode = false;
            } else {
                // todo 비밀번호를 변견하는 모드 활성화 처리
                // 비밀번호가 일치한지 체크
                if(passwordPreferences.getString("password", "000").equals(passwordForUser)){
                    changePasswordMode = true;
                    Toast.makeText(this, "변경할 패스워드를 입력해 주세요", Toast.LENGTH_LONG).show();
                    changePasswordButton.setBackgroundColor(Color.RED);
                }else {
                    showErrorAlertDialog();
                }
            }
        });
    } // end of addEventListener

    private void showErrorAlertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("실패")
                .setMessage("비밀번호가 잘못되었습니다")
                .setPositiveButton("닫기", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // 동작을 정의하지 않음 : 필요하면 기능을 추가하면 된다.
                    }
                });
        builder.show();
    }
}