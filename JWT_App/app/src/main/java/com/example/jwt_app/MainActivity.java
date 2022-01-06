package com.example.jwt_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.jwt_app.repository.JwtService;
import com.example.jwt_app.repository.models.response.ResPost;
import com.example.jwt_app.utils.FragmentType;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    BlogListFragment blogListFragment;
    UserListFragment userListFragment;
    WebFragment webFragment;
    MYInfoFragment myInfoFragment;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getIntent() != null){
            String msg = getIntent().getStringExtra("msg");
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }

        // 토큰 : SharedPreferences
//        SharedPreferences preferences = getSharedPreferences("token",  MODE_PRIVATE);
//        String token = preferences.getString("jwt", "");
//        JwtService jwtService = JwtService.retrofit.create(JwtService.class);
//
//        jwtService.getPostList(token).enqueue(new Callback<ResPost>() {
//            @Override
//            public void onResponse(Call<ResPost> call, Response<ResPost> response) {
//
//            }
//
//            @Override
//            public void onFailure(Call<ResPost> call, Throwable t) {
//
//            }
//        });
        
        initData();
        addMenuEventListener();
        addFragment(FragmentType.BLOG_LIST);

    }

    private void initData() {
        blogListFragment = new BlogListFragment();
        userListFragment = new UserListFragment();
        webFragment = new WebFragment();
        myInfoFragment = new MYInfoFragment();
        bottomNavigationView = findViewById(R.id.bottom_navigation);
    }

    private void addMenuEventListener() {
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.page_1:
                        addFragment(FragmentType.BLOG_LIST);
                        break;
                    case R.id.page_2:
                        addFragment(FragmentType.USERS);
                        break;
                    case R.id.page_3:
                        addFragment(FragmentType.WEB);
                        break;
                    case R.id.page_4:
                        addFragment(FragmentType.MY_INFO);
                        break;
                }
                return true;
            }
        });
    }

    private void addFragment(FragmentType type) {
        Fragment fragment = null;
        switch(type){
            case BLOG_LIST:
                fragment = blogListFragment;
                break;
            case USERS:
                fragment = userListFragment;
                break;
            case WEB:
                fragment = webFragment;
                break;
            case MY_INFO:
                fragment = myInfoFragment;
                break;
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.commit();
    }
}