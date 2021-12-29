package com.example.glideex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

//        ImageView imageView1 = findViewById(R.id.imageView1);
//        ImageView imageView2 = findViewById(R.id.imageView2);
//
//        Glide.with(this)
//                .load(R.drawable.image)
//                .into(imageView1);
//
//        Glide.with(this)
//                .load("https://picsum.photos/seed/picsum/200/300")
//                .circleCrop()
//                .into(imageView2);
        // Glide 사용해서 코드를 완성

        ImageView glideImageView1 = findViewById(R.id.glideImageView1);
        ImageView glideImageView2 = findViewById(R.id.glideImageView2);
        ImageView glideImageView3 = findViewById(R.id.glideImageView3);
        ImageView glideImageView4 = findViewById(R.id.glideImageView4);
        ImageView glideImageView5 = findViewById(R.id.glideImageView5);
        ImageView glideImageView6 = findViewById(R.id.glideImageView6);
        ImageView glideImageView7 = findViewById(R.id.glideImageView7);
        ImageView glideImageView8 = findViewById(R.id.glideImageView8);

        Glide.with(this)
                .load("https://picsum.photos/seed/picsum/200/300")
                .circleCrop()
                .into(glideImageView1);
        Glide.with(this)
                .load("https://picsum.photos/seed/picsum/200/300")
                .circleCrop()
                .into(glideImageView2);
        Glide.with(this)
                .load("https://picsum.photos/seed/picsum/200/300")
                .circleCrop()
                .into(glideImageView3);
        Glide.with(this)
                .load("https://picsum.photos/seed/picsum/200/300")
                .circleCrop()
                .into(glideImageView4);
        Glide.with(this)
                .load("https://picsum.photos/seed/picsum/200/300")
                .circleCrop()
                .into(glideImageView5);
        Glide.with(this)
                .load("https://picsum.photos/seed/picsum/200/300")
                .circleCrop()
                .into(glideImageView6);
        Glide.with(this)
                .load("https://picsum.photos/seed/picsum/200/300")
                .circleCrop()
                .into(glideImageView7);
        Glide.with(this)
                .load("https://picsum.photos/seed/picsum/200/300")
                .circleCrop()
                .into(glideImageView8);
    }
}