package com.example.myretrofit3.repository;

import com.example.myretrofit3.BuildConfig;
import com.example.myretrofit3.repository.models.Todo;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface FakeService {

    @GET ("todos")
    @Headers({
            "Accept: application/json",
            "user=Agent: myapp"
    })
    Call<ArrayList<Todo>> getTodos();

    @GET ("todos/{id}")
    Call<Todo> getTodoById(@Path("id") int id);

    // 레트로핏 초기화
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .client(httpLoggingInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    static OkHttpClient httpLoggingInterceptor(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();

        if(BuildConfig.DEBUG){
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        }else{
            interceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        }
        return new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();
    }

}
