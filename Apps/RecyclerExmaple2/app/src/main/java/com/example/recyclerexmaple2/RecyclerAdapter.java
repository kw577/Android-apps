package com.example.recyclerexmaple2;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ImageViewHolder> {

    private int[] images;
    private Context context;


    public RecyclerAdapter(int[] images, Context context){
        this.images = images;
        this.context = context;
    }

    //tworzenie obiektow klasy ImageViewHolder
    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.album_layout, parent, false);
        ImageViewHolder imageViewHolder = new ImageViewHolder(view, context, images);


        return imageViewHolder;
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {

        int image_id = images[position];
        holder.Album.setImageResource(image_id);
        holder.albumTitle.setText("Image : " + position);

    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    //kozdy obiekt tej klasy to wyswietlony pojedynczy obrazaek wraz z podpisem
    public static class ImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView Album;
        TextView albumTitle;
        Context context;
        int[] images;

        public ImageViewHolder(@NonNull View itemView, Context context, int[] images) {
            super(itemView);

            Album = itemView.findViewById(R.id.album);
            albumTitle = itemView.findViewById(R.id.album_title);

            itemView.setOnClickListener(this);

            this.context = context;
            this.images = images;
        }

        @Override
        public void onClick(View v) {

            Intent intent = new Intent(context, DisplayActivity.class);
            intent.putExtra("image_id", images[getAdapterPosition()]); //zapisuje numer wybranego zdjecia

            //rozpoczecie nowego activity - podglad obrazka
            context.startActivity(intent);
        }
    }

}
