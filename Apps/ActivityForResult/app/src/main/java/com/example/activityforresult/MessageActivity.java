package com.example.activityforresult;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MessageActivity extends AppCompatActivity {


    EditText message_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        message_txt = findViewById(R.id.txt_message);

    }

    public void sendMessage(View view) {

        String msg = message_txt.getText().toString();
        Intent returnIntent = new Intent();
        returnIntent.putExtra("message", msg);
        setResult(RESULT_OK, returnIntent);

        finish();
    }


}
