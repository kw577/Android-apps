package com.example.appa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sharePost(View view) {

        //explicit intent
        Intent intent = new Intent(this, SharePost.class);
        startActivity(intent);

    }

    public void sendMail(View view) {

        //implicit intent
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra("message", "This is new message");

        startActivity(intent);
    }
}
