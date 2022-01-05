package com.example.mynetwork1.models;

public class comments {
    int postId;
    int id;
    String name;
    String email;
    String body;

    @Override
    public String toString() {
        return "comments{" +
                "postId=" + postId +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
