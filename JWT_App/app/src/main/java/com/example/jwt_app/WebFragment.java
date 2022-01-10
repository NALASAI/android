package com.example.jwt_app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jwt_app.interfaces.OnBlogListRefresh;
import com.example.jwt_app.repository.JwtService;
import com.example.jwt_app.repository.models.request.ReqPost;
import com.example.jwt_app.repository.models.response.ResUpdatePost;
import com.example.jwt_app.utils.BlogUtil;
import com.google.android.material.snackbar.Snackbar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WebFragment extends Fragment {

    private EditText writeTitleEt;
    private EditText writeContentEt;
    private Button blogSaveOkBtn;
    private OnBlogListRefresh onBlogListRefresh;
    private String token;
    private JwtService jwtService;

    public WebFragment(OnBlogListRefresh onBlogListRefresh) {
        this.onBlogListRefresh = onBlogListRefresh;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // 1. retrofit 초기화
        jwtService = JwtService.retrofit.create(JwtService.class);
        View view = inflater.inflate(R.layout.fragment_web, container, false);
        writeTitleEt = view.findViewById(R.id.writeTitleEt);
        writeContentEt = view.findViewById(R.id.writeContentEt);
        blogSaveOkBtn = view.findViewById(R.id.blogSaveOkBtn);

        blogSaveOkBtn.setOnClickListener(view1 -> {
            // 2. 네트워크 통신
            ReqPost reqPost = new ReqPost(writeTitleEt.getText().toString(), writeContentEt.getText().toString());
            jwtService.savePost(BlogUtil.getToken(view.getContext()), reqPost).enqueue(new Callback<ResUpdatePost>() {
                @Override
                public void onResponse(Call<ResUpdatePost> call, Response<ResUpdatePost> response) {
                    // 통신
                    // 성공
                    Log.d("TAG", "writeTitleET : " + writeTitleEt.getText().toString());
                    Log.d("TAG", "writeContentET : " + writeContentEt.getText().toString());
                     onBlogListRefresh.refresh(response.body().getMsg());
                }

                @Override
                public void onFailure(Call<ResUpdatePost> call, Throwable t) {
                    // 실패
                }
            });
//            onBlogListRefresh.refresh("글 등록 완료");
        });

        return view;
    }
}