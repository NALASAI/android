package com.example.jwt_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.jwt_app.repository.JwtService;
import com.example.jwt_app.repository.models.request.ReqPost;
import com.example.jwt_app.repository.models.response.ResDelete;
import com.example.jwt_app.repository.models.response.ResPost;
import com.example.jwt_app.repository.models.response.ResUpdatePost;
import com.example.jwt_app.repository.models.response.common.Data;
import com.example.jwt_app.utils.BlogUtil;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {

    static final String TAG = DetailActivity.class.getName();
    private EditText detailTitleEt;
    private EditText detailContentEt;
    private Button blogUpdateBtn;
    private Button blogDeleteBtn;
    private Button blogUpdateOkBtn;

    private Data data;
    private JwtService jwtService;
    private String token;
    private String myId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        if (getIntent() != null) {
            // 데이터 가져오기
            data = (Data) getIntent().getSerializableExtra("postData");
            Log.d(TAG, data.getTitle());
            Log.d(TAG, data.getContent());

            initData();
            setData();
            addEventListener();
        }
    }

    private void addEventListener() {
        blogUpdateBtn.setOnClickListener(view -> {
            blogUpdateOkBtn.setVisibility(View.VISIBLE);
            detailTitleEt.setEnabled(true);
            detailContentEt.setEnabled(true);
        });

        blogDeleteBtn.setOnClickListener(view -> {
            // 모든 정보
            new MaterialAlertDialogBuilder(this)
                    .setTitle("게시글 삭제")
                    .setMessage("해당글을 삭제하시겠습니까?")
                    .setNegativeButton("취소", (dialogInterface, i) -> {
                        dialogInterface.dismiss();
                    })
                    .setPositiveButton("삭제", (dialogInterface, i) -> {
                        deletePage(view);
                    }).show();
        });

        blogUpdateOkBtn.setOnClickListener(view -> {
            ReqPost reqPost = new ReqPost(detailTitleEt.getText().toString(),
                    detailContentEt.getText().toString());
            jwtService.updatePost(token, data.getId(), reqPost).enqueue(new Callback<ResUpdatePost>() {
                @Override
                public void onResponse(Call<ResUpdatePost> call, Response<ResUpdatePost> response) {
                    setResultData(response.body().getMsg());
                    finish();
                }

                @Override
                public void onFailure(Call<ResUpdatePost> call, Throwable t) {
                    Snackbar.make(view, "잘못된 접근입니다.", Snackbar.LENGTH_SHORT).show();
                }
            });
        });
    }

    private void deletePage(View view) {
        jwtService.deletePost(token, data.getId()).enqueue(new Callback<ResDelete>() {
            @Override
            public void onResponse(Call<ResDelete> call, Response<ResDelete> response) {
                setResultData(response.body().getMsg());
                finish();
            }

            @Override
            public void onFailure(Call<ResDelete> call, Throwable t) {
                Snackbar.make(view, "잘못된 접근입니다.", Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    private void setResultData(String msg){
        Intent intent = new Intent();
        intent.putExtra("msg", msg);
        setResult(Activity.RESULT_OK, intent);
    }

    private void setData() {
        detailTitleEt.setText(data.getTitle());
        detailContentEt.setText(data.getContent());

        if (myId.equals(data.getUser().getId().toString())) {
            blogUpdateBtn.setVisibility(View.VISIBLE);
            blogDeleteBtn.setVisibility(View.VISIBLE);
        } else {
            blogUpdateBtn.setVisibility(View.GONE);
            blogDeleteBtn.setVisibility(View.GONE);
        }

    }

    private void initData() {
        detailTitleEt = findViewById(R.id.detailTitleEt);
        detailContentEt = findViewById(R.id.detailContentEt);

        blogUpdateBtn = findViewById(R.id.blogUpdateBtn);
        blogDeleteBtn = findViewById(R.id.blogDeleteBtn);
        blogUpdateOkBtn = findViewById(R.id.blogUpdateOkBtn);

        jwtService = JwtService.retrofit.create(JwtService.class);
        token = BlogUtil.getToken(this);
        SharedPreferences preferences = getSharedPreferences("token", MODE_PRIVATE);
        myId = preferences.getString("userId", "");
    }
}