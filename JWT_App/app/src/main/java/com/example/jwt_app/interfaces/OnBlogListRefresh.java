package com.example.jwt_app.interfaces;

import com.example.jwt_app.repository.models.response.common.Data;

public interface OnBlogListRefresh {
    void refresh(String msg);
    void movePage(Data data);
}
