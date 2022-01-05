package com.example.myretrofit3.repository.models;

public class Todo {

    public  int userId;
    public int id;
    public String completed;

    @Override
    public String toString() {
        return "Todo{" +
                "userId=" + userId +
                ", id=" + id +
                ", completed='" + completed + '\'' +
                '}';
    }
}
