package com.example.jwt_app.repository.models.request;


public class ReqSignUp {

    String username;
    String password;
    String email;

    public ReqSignUp(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
