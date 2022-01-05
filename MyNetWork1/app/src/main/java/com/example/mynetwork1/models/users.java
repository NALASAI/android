package com.example.mynetwork1.models;

public class users {
    int id;
    String name;
    String username;
    String email;
    String address;
    String phone;
    String website;
    String company;

    @Override
    public String toString() {
        return "users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", website='" + website + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}


