package com.example.myrecyclerview.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.myrecyclerview.DetailActivity;
import com.example.myrecyclerview.R;
import com.example.myrecyclerview.inteface.OnFoodItemClickListener;
import com.example.myrecyclerview.models.Food;

import java.util.ArrayList;

/*
* 내부 클래스로 뷰 폴더 클래스를 만들어 준다
* */
public class FoodListViewAdapter extends RecyclerView.Adapter<FoodListViewAdapter.ViewHolder>{

    ArrayList<Food> list;
    Context context;
    OnFoodItemClickListener onFoodItemClickListener;

    public FoodListViewAdapter(ArrayList<Food> list, Context context,
                               OnFoodItemClickListener onFoodItemClickListener) {
        this.list = list;
        this.context = context;
        this.onFoodItemClickListener = onFoodItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.item_food, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // 데이터 맵핑
        Food food = list.get(position);
        Glide.with(context)
                .load(food.getThumbnail())
                .centerCrop()
                .transform(new CenterCrop(), new RoundedCorners(30))
                .into(holder.thumbnail);

        holder.titleTextView.setText(food.getTitle());
        holder.subTitleTextView.setText(food.getSubTitle());
        holder.detailTextView.setText(food.getDetail());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView thumbnail;
        TextView titleTextView;
        TextView subTitleTextView;
        TextView detailTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            thumbnail = itemView.findViewById(R.id.thumbnailImageView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            subTitleTextView = itemView.findViewById(R.id.subtitleTextView);
            detailTextView = itemView.findViewById(R.id.detailTextView);
            
            // 이벤트 리스너 생성
            itemView.setOnClickListener(view -> {
//                Toast.makeText(context, "TEST" + getLayoutPosition(), Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(context, DetailActivity.class);
//                context.startActivity(intent);
                onFoodItemClickListener.onItemClicked(getLayoutPosition());
            });
        }
    }

}
