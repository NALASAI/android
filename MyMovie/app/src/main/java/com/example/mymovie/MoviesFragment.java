package com.example.mymovie;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mymovie.repository.adpater.YtsAdapter;
import com.example.mymovie.repository.models.YtsData;
import com.example.mymovie.repository.models.YtsService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviesFragment extends Fragment {

    RecyclerView recyclerView;

    private MoviesFragment() {
    }

    public static MoviesFragment newInstance() {
        MoviesFragment fragment = new MoviesFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View itemView = inflater.inflate(R.layout.fragment_movies, container, false);
        recyclerView = itemView.findViewById(R.id.moviesContainer);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(manager);

        rvDataSetting();

        return itemView;
    }

    private void rvDataSetting() {
        // 어댑터 생성
        final YtsAdapter ytsAdapter = new YtsAdapter();

        // 레트로핏 사용
        YtsService ytsService = YtsService.retrofit.create(YtsService.class);
        //호출
        Call<YtsData> call = ytsService.repoContributors("rating", 40, 1);
        call.enqueue(new Callback<YtsData>() {
            @Override
            public void onResponse(Call<YtsData> call, Response<YtsData> response) {
                if(response.isSuccessful()){
                    YtsData ytsData = response.body();
                    ytsAdapter.addItems(ytsData.getData().getMovies());
                    recyclerView.setAdapter(ytsAdapter);
                }
            }

            @Override
            public void onFailure(Call<YtsData> call, Throwable t) {
                Toast.makeText(getContext(), "연동실패", Toast.LENGTH_SHORT).show();
            }
        });
    }
}