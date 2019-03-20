package com.example.appbarsearch;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private List<String> list;

    public RecyclerAdapter(List<String> list){
        this.list = list;
    }

    //metoda tworzy elementy listy
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //przypisanue widoku zdefiniowanego w text_view_layout.xml
        TextView textView = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.text_view_layout, parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(textView);

        return myViewHolder;
    }

    //przypisanie danych do komponentow widoku
    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, int i) {
        viewHolder.versionName.setText(list.get(i));
    }

    //liczy ile elementow zawiera lista
    @Override
    public int getItemCount() {
        return list.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView versionName;
        public MyViewHolder(TextView itemView) {
            super(itemView);
            versionName = itemView;
        }
    }



    //do funkcji filtrowania wynikow dla podanych kryteriow wyszukiwania
    public void updateList(List<String> newList){

        list = new ArrayList<>();
        list.addAll(newList);
        notifyDataSetChanged();

    }

}