package com.example.mylistview.adapter;

import android.content.Context;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mylistview.R;
import com.example.mylistview.models.Food;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class FoodListAdapter extends BaseAdapter {

    // 1. 추가로 생성자 만들어 주기
    ArrayList<Food> data;
    Context context;

    public FoodListAdapter(ArrayList<Food> data, Context context) {
        this.data = data;
        this.context = context;
    }

    /* 전체 갯수를 알아야 adapter 가 조정할 수 있다*/
    @Override
    public int getCount() {
        return data.size();
    }

    /*
    * 하나의 아이템을 알려준다.
    * */

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    /*
    * 고유한 아이디 값을 만들어 주는 녀석
    * 간단하게 하기 위해 항목의 위치를 ID로 사용한다.
    * */
    @Override
    public long getItemId(int i) {
        return i;
    }

    // addView 에서 처리했던 XML 파일을 불러서 데이터를 맵핑 하는 곳
    // 성능 개선 --> viewHolder 개념 추가

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View itemView;
        FoodListViewHolder foodListViewHolder;

        // view 가 한번도 만들어 지지 않았다면 한번은 맵핑을 해주어야 한다.
        // adapter : ListView (또는 다른 형태의 ViewGroup) 와 실제 데이터(List, Array 등)의 중간 역할을 하는 추상 인터페이스
        // inflater : xml 로 정의된 view (또는 menu 등)를 실제 객체화 시키는 용도
        if(view == null) {
            foodListViewHolder = new FoodListViewHolder();
            LayoutInflater inflater = LayoutInflater.from(context);
            itemView = inflater.inflate(R.layout.item_food, null);
            foodListViewHolder.imageView = itemView.findViewById(R.id.thumbnailImageView);
            foodListViewHolder.titleTextView = itemView.findViewById(R.id.titleTextView);
            foodListViewHolder.detailTextView = itemView.findViewById(R.id.detailTextView);
            foodListViewHolder.subtitleTextView = itemView.findViewById(R.id.subtitleTextView);

            // 중요!
            // 찾을 수 있도록 태그를 달아놓는다.
            itemView.setTag(foodListViewHolder);
        } else {
            foodListViewHolder = (FoodListViewHolder) view.getTag();
            itemView = view;
        }

        Food food = data.get(i);

        Glide.with(context)
                .load(food.getThumbnail())
                .centerCrop()
                .into(foodListViewHolder.imageView);

        foodListViewHolder.titleTextView.setText(food.getTitle());
        foodListViewHolder.subtitleTextView.setText(food.getSubTitle());
        foodListViewHolder.detailTextView.setText(food.getDetail());

        return itemView;
    }


//    @Override
//    public View getView(int i, View view, ViewGroup viewGroup) {
//        Log.d("TAG", "getViewID" + i);
//        // 그리고자 하는 아이템을 가져온다.
//        LayoutInflater inflater = LayoutInflater.from(context);
//        View itemView = inflater.inflate(R.layout.item_food, null);
//
//        ImageView imageView = itemView.findViewById(R.id.thumbnailImageView);
//        TextView titleTextView = itemView.findViewById(R.id.titleTextView);
//        TextView detailTextView = itemView.findViewById(R.id.detailTextView);
//        TextView subtitleTextView = itemView.findViewById(R.id.subtitleTextView);
//
//        Food food = data.get(i);
//
//        Glide.with(context)
//                .load(food.getThumbnail())
//                .centerCrop()
//                .into(imageView);
//
//        titleTextView.setText(food.getTitle());
//        subtitleTextView.setText(food.getSubTitle());
//        detailTextView.setText(food.getDetail());
//
//        return itemView;
//    }
}
