package com.example.myretrofit2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.myretrofit2.repository.RetrofitService;
import com.example.myretrofit2.repository.models.Comment;
import com.example.myretrofit2.repository.models.Post;
import com.example.myretrofit2.repository.models.Todo;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Retrofit retrofit;
    RetrofitService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // retrofit 객체 초기화
        retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(RetrofitService.class);

//        getCommentsById();
        getTodoById();
//        createPost();
//        getComments();
//        getTodoData();
    }

    private void getCommentsById() {
        service.getCommentsById(10).enqueue(new Callback<Comment>() {
            @Override
            public void onResponse(Call<Comment> call, Response<Comment> response) {
                if (response.isSuccessful()){
                    Comment comment = response.body();
                    Log.d("TAG", comment.toString());
                }
            }

            @Override
            public void onFailure(Call<Comment> call, Throwable t) {

            }
        });
    }

    private void getTodoById() {
        service.getTodoById(3).enqueue(new Callback<Todo>() {
            @Override
            public void onResponse(Call<Todo> call, Response<Todo> response) {
                if(response.isSuccessful()){
                    Todo todo = response.body();
                    Log.d("TAG", todo.toString());
                }
            }

            @Override
            public void onFailure(Call<Todo> call, Throwable t) {

            }
        });
    }

    private void createPost() {
        //  Post 보내는 방법 -- 반드시 @FormUrlEncoded 선언
        Call<Post> call = service.createPost(30, "제목필드작성함", "사용자가 글을 입력함");

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (response.isSuccessful()) {
                    Log.d("TAG", "status code : " + response.code());
                    if(response.isSuccessful()) {
                        Post postRes = response.body();
                        Log.d("TAG", postRes.toString());
                    }
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });
    }

    private void getComments() {
        service.getComments().enqueue(new Callback<ArrayList<Comment>>() {
            @Override
            public void onResponse(Call<ArrayList<Comment>> call, Response<ArrayList<Comment>> response) {
                if (response.isSuccessful()) {
                    Log.d("TAG", response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Comment>> call, Throwable t) {

            }
        });


    }

    private void getTodoData() {
        service.getTodos().enqueue(new Callback<ArrayList<Todo>>() {
            // 성공
            @Override
            public void onResponse(Call<ArrayList<Todo>> call, Response<ArrayList<Todo>> response) {
                Log.d("TAG", "return : " + response.isSuccessful());
                if (response.isSuccessful()) {
                    Log.d("TAG", response.body().toString());
                }
            }

            // 실패
            @Override
            public void onFailure(Call<ArrayList<Todo>> call, Throwable t) {

            }
        });
    }
}