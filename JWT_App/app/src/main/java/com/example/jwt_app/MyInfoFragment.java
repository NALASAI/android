package com.example.jwt_app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jwt_app.repository.JwtService;
import com.example.jwt_app.repository.models.response.ResLogin;
import com.example.jwt_app.utils.BlogUtil;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyInfoFragment extends Fragment {

    private JwtService jwtService;
    private ResLogin resLogin;

    private ImageView userImg;
    private TextView userNameTv;
    private TextView userEmailTv;
    private Button myInfoUpdateBtn;
    private Button logoutBtn;

    public MyInfoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        jwtService = JwtService.retrofit.create(JwtService.class);
        String myId = BlogUtil.getMyId(getContext());
        jwtService.myInfo(BlogUtil.getToken(getContext()),
                Integer.parseInt(myId)).enqueue(new Callback<ResLogin>() {
            @Override
            public void onResponse(Call<ResLogin> call, Response<ResLogin> response) {
                resLogin = response.body();
            }

            @Override
            public void onFailure(Call<ResLogin> call, Throwable t) {
                Log.d("TAG", "error : " + t.toString());
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View myInfoView = inflater.inflate(R.layout.fragment_my_info, container, false);
        initData(myInfoView);
        addEventListener();

        return myInfoView;
    }

    private void initData(View view) {
        userImg = view.findViewById(R.id.userImage);
        userNameTv = view.findViewById(R.id.userNameTv);
        userEmailTv = view.findViewById(R.id.userEmailTv);
        myInfoUpdateBtn = view.findViewById(R.id.myInfoUpdateBtn);
        logoutBtn = view.findViewById(R.id.logoutBtn);
    }

    private void addEventListener() {
        myInfoUpdateBtn.setOnClickListener(view -> {

        });
        logoutBtn.setOnClickListener(view -> {
            SharedPreferences preferences = getActivity()
                    .getSharedPreferences("token", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("jwt", "");
            editor.apply();

            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);
            getActivity().finish();
        });
    }


}