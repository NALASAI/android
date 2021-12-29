package com.example.materialtoolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    MaterialToolbar topAppBar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        topAppBar = findViewById(R.id.topAppBar);
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);

        addMenuEventListener();
    }

    private void addMenuEventListener(){
        // todo 추후 연결
        topAppBar.setNavigationOnClickListener(view -> {
            drawerLayout.openDrawer(Gravity.LEFT);
        });

        topAppBar.setOnMenuItemClickListener(item -> {
            return selectedMenuItem(item);
        });

        navigationView.setNavigationItemSelectedListener(item -> {
            return selectedMenuItem(item);
        });
    }// end of addEvent menu listener

    private boolean selectedMenuItem(android.view.MenuItem item) {
        switch (item.getItemId()){
            case R.id.favorite:
                Log.d("TAG", "favorite");
                changeActivity(this, FavoriteActivity.class);
                break;
            case R.id.search:
                Log.d("TAG", "search");
                changeActivity(this, SearchActivity.class);
                break;
            case R.id.more:
                Log.d("TAG", "more");
                changeActivity(this, MoreActivity.class);
                break;
        }
        return true;
    }

    private void changeActivity(Context packageContext, Class<?> cls){
        Intent intent = new Intent(packageContext, cls);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(navigationView)){
            drawerLayout.closeDrawer(navigationView);
        }else {
            super.onBackPressed();
        }
    }
}