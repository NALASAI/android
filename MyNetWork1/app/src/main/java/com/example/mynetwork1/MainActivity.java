package com.example.mynetwork1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // JSONObject

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("이름","홍길동");
            jsonObject.put("나이", 23);
            jsonObject.put("직업","CEO");
            jsonObject.put("취미","노래");
            jsonObject.put("결혼여부",false);
        } catch (JSONException e) {
            e.printStackTrace();
        }

//        Log.d("TAG", jsonObject.toString());

        // JSONArray
        JSONArray jsonArray = new JSONArray();
        jsonArray.put(jsonObject);
        jsonArray.put(jsonObject);
        jsonArray.put(jsonObject);

//        Log.d("TAG", jsonArray.toString());

        // { arr : [ {}, {}, {} ] }
        JSONObject jsonObject2 = new JSONObject();
        try {
            jsonObject2.put("arr", jsonArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d("TAG", jsonObject2.toString());
        // JSON

    }
}