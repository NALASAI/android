package com.example.myretrofit2.repository.models;

import com.google.gson.annotations.SerializedName;

public class Todo {
    @SerializedName("userId")
    String userId;
    @SerializedName("id")
    int id;
    @SerializedName("title")
    String title;
    @SerializedName("completed")
    String completed;

    @Override
    public String toString() {
        return "Todo{" +
                "userId='" + userId + '\'' +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", completed='" + completed + '\'' +
                '}';
    }
}
