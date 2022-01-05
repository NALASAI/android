package com.example.myproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.myproject.repository.utils.FragmentType;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        addBottomMenuListener();
        addFragment(FragmentType.HOME);
    }

    private void initData() {
        bottomNavigationView = findViewById(R.id.bottomNavigation);
    }

    private void addBottomMenuListener() {
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.page_1:
                        addFragment(FragmentType.HOME);
                        break;
                    case R.id.page_2:
                        addFragment(FragmentType.ITEM);
                        break;
                    case R.id.page_3:
                        addFragment(FragmentType.BASKET);
                        break;
                    case R.id.page_4:
                        addFragment(FragmentType.EVENT);
                        break;
                    case R.id.page_5:
                        addFragment(FragmentType.INFO);
                        break;
                }
                return true;
            }
        });
    }

    private void addFragment(FragmentType type) {
        Fragment fragment = null;
        switch (type) {
            case HOME:
                fragment = new HomeFragment();
                break;
            case ITEM:
                fragment = new ItemFragment();
                break;
            case BASKET:
                fragment = new BasketFragment();
                break;
            case EVENT:
                fragment = new EventFragment();
                break;
            case INFO:
                fragment = new InfoFragment();
                break;
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.mainContainer, fragment);
        transaction.commit();
    }
}