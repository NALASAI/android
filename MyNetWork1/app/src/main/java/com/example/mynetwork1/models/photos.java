package com.example.mynetwork1.models;

public class photos {
    int albumId;
    int id;
    String title;
    String url;
    String thumbnailUrl;

    @Override
    public String toString() {
        return "photos{" +
                "albumId=" + albumId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", thumbnailUrl='" + thumbnailUrl + '\'' +
                '}';
    }
}
