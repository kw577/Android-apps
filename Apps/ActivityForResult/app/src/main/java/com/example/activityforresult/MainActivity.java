package com.example.activityforresult;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final int message_request = 01;
    private TextView txt_display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_display = findViewById(R.id.txt_display_message);

    }

    public void getMessage(View view) {

        Intent intent = new Intent(this, MessageActivity.class);
        startActivityForResult(intent, message_request);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(message_request == requestCode){
            if(message_request == RESULT_OK){
                String msg1 = data.getStringExtra("message");
                txt_display.setText(msg1);
             

            }
        }

    }

}
