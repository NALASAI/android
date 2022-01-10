
package com.example.jwt_app.repository.models.response;

import com.example.jwt_app.repository.models.response.common.Data;
import com.example.jwt_app.repository.models.response.common.Result;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResLogin extends Result {

    @SerializedName("data")
    @Expose
    private Data data;

    public Data getData() {
        return data;
    }
}
