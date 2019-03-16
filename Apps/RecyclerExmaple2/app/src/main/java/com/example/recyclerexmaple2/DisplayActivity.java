package com.example.recyclerexmaple2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class DisplayActivity extends AppCompatActivity {

    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        imageView = findViewById(R.id.album_display);

        //pobranie numeru zdjecia do podgladu
        imageView.setImageResource(getIntent().getIntExtra("image_id", 0));

    }
}
