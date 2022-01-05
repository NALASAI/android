package com.example.mynetwork1.models;

public class Todo {

    int userId;
    int id;
    String title;
    String completed;

    @Override
    public String toString() {
        return "Todo{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", completed='" + completed + '\'' +
                '}';
    }
}
