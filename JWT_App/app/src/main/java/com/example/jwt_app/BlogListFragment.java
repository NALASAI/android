package com.example.jwt_app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.jwt_app.interfaces.OnBlogListRefresh;
import com.example.jwt_app.repository.JwtService;
import com.example.jwt_app.adapter.BlogListAdapter;
import com.example.jwt_app.repository.models.response.ResPost;
import com.example.jwt_app.utils.BlogUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BlogListFragment extends Fragment {

    private JwtService jwtService;
    private String token;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private OnBlogListRefresh onBlogListRefresh;

    public BlogListFragment(OnBlogListRefresh onBlogListRefresh) {
        this.onBlogListRefresh = onBlogListRefresh;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 토큰 : SharedPreferences
        token = BlogUtil.getToken(getContext());
        jwtService = JwtService.retrofit.create(JwtService.class);
        requestPostData(token);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blog_list, container, false);
        recyclerView = view.findViewById(R.id.blogListRv);
        swipeRefreshLayout = view.findViewById(R.id.refreshLayout);
        requestPostData(token);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                listRefresh();
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        return view;
    }

    public void listRefresh(){
        requestPostData(token);
    }

    private void requestPostData(String token) {
        jwtService.getPostList(token).enqueue(new Callback<ResPost>() {
            @Override
            public void onResponse(Call<ResPost> call, Response<ResPost> response) {
                ResPost resPost = response.body();

                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                BlogListAdapter adapter = new BlogListAdapter(getContext());
                adapter.setItemData(resPost.getListdata());

                adapter.setOnBlogListRefresh(onBlogListRefresh);

                recyclerView.hasFixedSize();
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ResPost> call, Throwable t) {
                Toast.makeText(getContext(), "fail ~~ ", Toast.LENGTH_SHORT).show();
            }
        });
    }
}