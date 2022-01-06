package com.example.jwt_app.repository;

import com.example.jwt_app.BuildConfig;
import com.example.jwt_app.repository.models.request.ReqLogin;
import com.example.jwt_app.repository.models.request.ReqSignUp;
import com.example.jwt_app.repository.models.response.ResLogin;
import com.example.jwt_app.repository.models.response.ResPost;
import com.example.jwt_app.repository.models.response.ResSignUp;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface JwtService {

    @POST("login")
    Call<ResLogin> getLogin(@Body ReqLogin reqLogin);

    @POST("join")
    Call<ResSignUp> saveMember(@Body ReqSignUp reqSignUp);

    @GET("post")
    Call<ResPost> getPostList(@Header("Authorization") String token);

    // ipconfig | ifconfig
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://lalacoding.site")
            .client(httpLoggingInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    static OkHttpClient httpLoggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();

        if (BuildConfig.DEBUG) {
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            interceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        }

        return new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();
    }
}
