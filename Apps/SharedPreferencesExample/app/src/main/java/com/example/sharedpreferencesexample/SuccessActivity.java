package com.example.sharedpreferencesexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SuccessActivity extends AppCompatActivity {

    private SharedPreferenceConfig preferenceConfig;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        preferenceConfig = new SharedPreferenceConfig(getApplicationContext());

    }

    public void userLogout(View view) {
        preferenceConfig.writeLoginStatus(false);

        // przeniesienie do ekranu logowania
        startActivity(new Intent(this, MainActivity.class));

        // zakonczenie biezacego activity
        finish();


    }
}
