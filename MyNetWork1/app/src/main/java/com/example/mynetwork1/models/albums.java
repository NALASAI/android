package com.example.mynetwork1.models;

public class albums {
    int userId;
    int id;
    String title;

    @Override
    public String toString() {
        return "albums{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
