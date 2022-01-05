package com.example.myproject.repository.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.bumptech.glide.Glide;
import com.example.myproject.ItemFragment;
import com.example.myproject.R;
import com.example.myproject.repository.model.ItemList;

import java.util.ArrayList;

public class ItemListAdapter extends BaseAdapter {

    ArrayList<ItemList> data;
    Context context;

    public ItemListAdapter(ArrayList<ItemList> data, ItemFragment context) {
        this.data = data;
//        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView;
        ItemListViewHolder itemListViewHolder;

        if(view == null) {
            itemListViewHolder = new ItemListViewHolder();
            LayoutInflater inflater = LayoutInflater.from(context);
            itemView = inflater.inflate(R.layout.fragment_item ,viewGroup, false);
            itemListViewHolder.imageView = itemView.findViewById(R.id.thumbnailImageView);
            itemListViewHolder.titleTextView = itemView.findViewById(R.id.titleTextView);
            itemListViewHolder.detailTextView = itemView.findViewById(R.id.detailTextView);
            itemListViewHolder.subtitleTextView = itemView.findViewById(R.id.subtitleTextView);

            // 중요!
            // 찾을 수 있도록 태그를 달아놓는다.
            itemView.setTag(itemListViewHolder);
        } else {
            itemListViewHolder = (ItemListViewHolder) view.getTag();
            itemView = view;
        }

        ItemList itemList = data.get(i);

        Glide.with(context)
                .load(itemList.getThumbnail())
                .centerCrop()
                .into(itemListViewHolder.imageView);

        itemListViewHolder.titleTextView.setText(itemList.getTitle());
        itemListViewHolder.subtitleTextView.setText(itemList.getSubTitle());
        itemListViewHolder.detailTextView.setText(itemList.getDetail());


        return itemView;
    }

}
