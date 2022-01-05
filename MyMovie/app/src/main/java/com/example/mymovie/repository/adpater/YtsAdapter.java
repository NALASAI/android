package com.example.mymovie.repository.adpater;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mymovie.R;
import com.example.mymovie.repository.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class YtsAdapter extends  RecyclerView.Adapter<YtsAdapter.MyViewHolder>{

    List<Movie> list = new ArrayList<>();

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_movie_card, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Movie movie = list.get(position);
        holder.setItem(movie);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    // 리스트값 넘겨 받기
    public void addItems(List<Movie> list){
        this.list = list;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView posterIv;
        private TextView titleTv;
        private TextView ratingTv;
        private RatingBar ratingBar;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            posterIv = itemView.findViewById(R.id.posterIv);
            titleTv = itemView.findViewById(R.id.titleTv);
            ratingBar = itemView.findViewById(R.id.ratingBar);
            ratingTv = itemView.findViewById(R.id.ratingTv);
        }

        public void setItem(Movie movie){
            titleTv.setText(movie.getTitle());
            ratingTv.setText(movie.getRating() + "");
            Picasso.with(posterIv.getContext())
                    .load(movie.getMediumCoverImage())
                    .placeholder(R.drawable.round_image)
                    .into(posterIv);
            
            ratingBar.setRating((float) Math.floor(movie.getRating()));
        }

    }

}
