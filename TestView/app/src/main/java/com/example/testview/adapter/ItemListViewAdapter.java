package com.example.testview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.testview.R;
import com.example.testview.inteface.ItemClickListener;
import com.example.testview.models.Item;

import java.util.ArrayList;

/*
* 내부 클래스로 뷰 폴더 클래스를 만들어 준다
* */
public class ItemListViewAdapter extends RecyclerView.Adapter<ItemListViewAdapter.ViewHolder>{

    ArrayList<Item> list;
    Context context;
    ItemClickListener itemClickListener;

    public ItemListViewAdapter(ArrayList<Item> list, Context context, ItemClickListener itemClickListener) {
        this.list = list;
        this.context = context;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // 데이터 맵핑
        Item item = list.get(position);
        Glide.with(context)
                .load(item.getThumbnail())
                .centerCrop()
                .transform(new CenterCrop(), new RoundedCorners(30))
                .into(holder.thumbnail);

        holder.titleTextView.setText(item.getTitle());
        holder.subTitleTextView.setText(item.getSubTitle());
        holder.detailTextView.setText(item.getDetail());
        holder.priceTextView.setText(item.getPrice());
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
        TextView priceTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            thumbnail = itemView.findViewById(R.id.thumbnailImageView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            subTitleTextView = itemView.findViewById(R.id.subtitleTextView);
            detailTextView = itemView.findViewById(R.id.detailTextView);
            priceTextView = itemView.findViewById(R.id.PriceTextView);

            itemView.setOnClickListener(view -> {
                itemClickListener.onItemClicked(getLayoutPosition());
            });

        }
    }

}
