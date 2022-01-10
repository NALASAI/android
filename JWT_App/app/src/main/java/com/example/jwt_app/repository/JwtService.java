package com.example.jwt_app.repository;

import com.example.jwt_app.BuildConfig;
import com.example.jwt_app.repository.models.request.ReqLogin;
import com.example.jwt_app.repository.models.request.ReqPost;
import com.example.jwt_app.repository.models.request.ReqSignUp;
import com.example.jwt_app.repository.models.response.ResDelete;
import com.example.jwt_app.repository.models.response.ResLogin;
import com.example.jwt_app.repository.models.response.ResPost;
import com.example.jwt_app.repository.models.response.ResSignUp;
import com.example.jwt_app.repository.models.response.ResUpdatePost;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface JwtService {

    @POST("login")
    Call<ResLogin> getLogin(@Body ReqLogin reqLogin);

    @POST("join")
    Call<ResSignUp> saveMember(@Body ReqSignUp reqSignUp);

    @GET("post")
    Call<ResPost> getPostList(@Header("Authorization") String token);

    @PUT("post/{postId}")
    Call<ResUpdatePost> updatePost(@Header("Authorization") String token,
                                   @Path("postId") int postId,
                                   @Body ReqPost reqPost);

    @DELETE("post/{postId}")
    Call<ResDelete> deletePost(@Header("Authorization") String token,
                               @Path("postId") int postId);

    @POST("post")
    Call<ResUpdatePost> savePost(@Header("Authorization") String token,
                                 @Body ReqPost reqPost);

    @GET("user/{myId}")
    Call<ResLogin> myInfo(@Header("Authorization") String token, @Path("myId") int myId);

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
