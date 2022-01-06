package com.example.jwt_app.repository.models.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResSignUp {

    @SerializedName("code")
    @Expose
    private Integer code;

    @SerializedName("msg")
    @Expose
    private String msg;

    @SerializedName("data")
    @Expose
    private Data data;

    public String getMsg() {
        return msg;
    }

    public Data getData() {
        return data;
    }
}
