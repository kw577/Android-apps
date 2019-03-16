package com.example.recyclerexmaple2;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViev;

    //lista obrazkow
    private int[] images = {R.drawable.img1, R.drawable.img2,
            R.drawable.img3, R.drawable.img4};

    private RecyclerAdapter adapter;

    //dodanie layout manager
    private RecyclerView.LayoutManager layoutManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViev = findViewById(R.id.recyclerView);
        layoutManager = new GridLayoutManager(this, 2);
        recyclerViev.setHasFixedSize(true);

        recyclerViev.setLayoutManager(layoutManager);

        adapter = new RecyclerAdapter(images);
        recyclerViev.setAdapter(adapter);


    }
}
