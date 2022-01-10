package com.example.jwt_app.repository.models.response;

import com.example.jwt_app.repository.models.response.common.Data;
import com.example.jwt_app.repository.models.response.common.Result;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResPost extends Result {
    @SerializedName("data")
    @Expose
    private List<Data> listdata = null;

    public List<Data> getListdata() {
        return listdata;
    }
}
