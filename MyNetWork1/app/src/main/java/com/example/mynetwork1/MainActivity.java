package com.example.mynetwork1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.mynetwork1.models.POST;
import com.example.mynetwork1.models.Todo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(() -> {
            String urlString = "https://jsonplaceholder.typicode.com/posts";
            try {
                URL url = new URL(urlString);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");
                connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");

                JSONObject jsonObject = new JSONObject();

                jsonObject.put("name", "홍길동");
                jsonObject.put("age", 30);
                jsonObject.put("job", "CEO");

                // connection <-- 값을 넣겠다
                connection.setDoInput(true);

                try(OutputStream os = connection.getOutputStream()){
                    byte[] input = jsonObject.toString().getBytes(StandardCharsets.UTF_8);
                    os.write(input, 0, input.length);
                }

                Log.d("TAG", connection.getResponseCode() + "");
                if(connection.getResponseCode() == 201){
                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(
                                    connection.getInputStream(),
                                    "UTF-8"
                            )
                    );

                    // 타입을 만들어 줘야 한다.
                    Type postType = new TypeToken<POST>(){}.getType();

                    POST post = new Gson().fromJson(reader, postType);
                    Log.d("TAG", "post : " + post.toString());

                }else{
                    // 실패
                }

            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }
        }).start();


    }

    private void getMethodTest(){new Thread(() -> {
        // 통신하기
        String urlString = "https://jsonplaceholder.typicode.com/todos";
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            //설정

            connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            Log.d("TAG", "상태 값 : " + connection.getResponseCode());
            String buffer = "";
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                Log.d("TAG", "성공");
                // 기반, 보조 스트림 - 데코레이션 패턴
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                connection.getInputStream(),
                                "UTF-8"
                        )
                );
                //1.  한 라인
                buffer = reader.readLine();
//                    Log.d("TAG", "buffer : " + buffer);

                // 2.
                String line = null;
                StringBuffer sb = new StringBuffer();
                while ( (line = reader.readLine()) != null ) {
                    sb.append(line + "\n");
                }
                Log.d("TAG", sb.toString());

            } else {
                Log.d("TAG", "실패");
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }).start();}
    private void sampleJson() {
        // JSONObject

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("이름", "홍길동");
            jsonObject.put("나이", 23);
            jsonObject.put("직업", "CEO");
            jsonObject.put("취미", "노래");
            jsonObject.put("결혼여부", true);

            jsonObject.getString("이름");

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
        // Log.d("TAG", jsonObject2.toString());
        // 제이슨 만드는 방법

        // 오브젝트, array 에서 꺼내는 방법
        try {
            JSONArray jsonArray1 = jsonObject2.getJSONArray("arr");
            JSONObject object0 = jsonArray1.getJSONObject(0);

            String name = object0.getString("이름");
            int age = object0.getInt("나이");
            String job = object0.getString("직업");

            // 2번 추출
            String hob = object0.getString("취미");
            // 3번 추출
            Boolean isMarried = object0.getBoolean("결혼여부");

            Log.d("TAG", name + " : " + age + " : " + job);
            Log.d("TAG", name + " : " + age + " : " + job + " : " + hob);
            Log.d("TAG", name + " : " + age + " : " + job + " : " + hob + " : " + isMarried);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}