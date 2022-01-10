package com.example.jwt_app.repository.models.response;

import com.example.jwt_app.repository.models.response.common.Data;
import com.example.jwt_app.repository.models.response.common.Result;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ResUpdatePost extends Result {

    @SerializedName("data")
    @Expose
    private Data data = null;

    public Data getData() {
        return data;
    }
}
