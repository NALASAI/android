package com.example.myproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.myproject.repository.adapter.ItemListAdapter;
import com.example.myproject.repository.model.ItemList;

import java.util.ArrayList;

public class ItemFragment extends Fragment {

    ItemListAdapter itemListAdapter;
    ListView listView;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public ItemFragment() {
    }

    public static ItemFragment newInstance() {
        return new ItemFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemView =  inflater.inflate(R.layout.fragment_item, container, false);
        listView = itemView.findViewById(R.id.itemListView);

        ArrayList<ItemList> lists = ItemList.getSampleData();

        itemListAdapter = new ItemListAdapter(lists, this);

        listView.setAdapter(itemListAdapter);
        return itemView;
    }
}