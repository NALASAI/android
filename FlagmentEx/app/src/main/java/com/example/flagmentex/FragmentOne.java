package com.example.flagmentex;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentOne extends Fragment {
    @Override
    public void onAttach(@NonNull Context context) {
        Log.d("TAG", "F onAttach");
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d("TAG", "F onCreate");
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("TAG", "F onCreateView");
        /*
        * inflater --> 뷰를 그리는 속성
        * container --> 내가(Fragment) 위치할 곳이 어디인지 넘겨 받는 곳
        * attachToRoot --> 처음부터 그릴지 진행될 때 그릴지 결정
        * */
        View view = inflater.inflate(R.layout.fragment_one, container, false);
//        return super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.d("TAG", "F onViewCreated");
        if(getArguments() != null){
            String data = getArguments().getString("param1", "");
        }
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.d("TAG", "F onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.d("TAG", "F onResume");
        super.onResume();
    }
}
