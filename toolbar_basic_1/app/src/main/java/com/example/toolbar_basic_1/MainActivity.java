package com.example.toolbar_basic_1;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    // 대체방법
    ActivityResultLauncher<Intent> sResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if(result.getResultCode() == Activity.RESULT_OK){
                    // 정상적으로 값이 돌아 왔다
                    // 값을 꺼내는 방법
                    Intent resultData = result.getData();
                    int getValue = resultData.getIntExtra("result", 0);
                    Log.d("TAG", "getValue : " + getValue);
                    textView.setText(String.valueOf(getValue));
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.tool_bar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        textView = findViewById(R.id.HelloTv);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuItem1:
                Intent intent = new Intent(this, SubActivity.class);
                intent.putExtra("value1", 10);
//                startActivity(intent);
//                startActivityForResult(intent, 10001);

                sResult.launch(intent);

                break;
            case R.id.menuItem2:
                Log.d("TAG", "menuItem2 Click");
                break;
            case R.id.menuItem3:
                Log.d("TAG", "menuItem3 Click");
                break;
        }


        return super.onOptionsItemSelected(item);
    }
}