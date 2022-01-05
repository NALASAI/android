package com.example.myretrofit2.repository;

import com.example.myretrofit2.repository.models.Comment;
import com.example.myretrofit2.repository.models.Post;
import com.example.myretrofit2.repository.models.Todo;
import com.example.myretrofit2.repository.models.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

// 비즈니스 로직을 처리하는 부분을 요청사항에 따라 언제든지 변할 수 있고 확장을 염두해서 인터페이스를 구성한다.
public interface RetrofitService {
    // https://jsonplaceholder.typicode.com/comments
    @GET("todos")
    Call<ArrayList<Todo>> getTodos();

    @GET("todos/{id}")
    Call<Todo> getTodoById(@Path("id") int id);

    @GET("comments")
    Call<ArrayList<Comment>> getComments();

    // comments/10 데이터 받아오기
    @GET("comments/{id}")
    Call<Comment> getCommentsById(@Path("id") int id);

    @FormUrlEncoded
    @POST("posts")
    Call<Post> createPost(
        @Field("userId") int userId,
        @Field("title") String title,
        @Field("body") String text
    );

    //
}
