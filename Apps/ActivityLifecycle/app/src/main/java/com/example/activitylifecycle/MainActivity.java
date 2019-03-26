package com.example.activitylifecycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //informacja w logach o zakonczeniu biezacej metody
        showLog("onCrreate Finish...");
    }

    @Override
    protected void onStart() {
        super.onStart();
        showLog("onStart Finish...");
    }

    @Override
    protected void onStop() {
        super.onStop();
        showLog("onStop Finish...");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        showLog("onDestroy Finish...");
    }

    @Override
    protected void onPause() {
        super.onPause();
        showLog("onPause Finish...");
    }

    @Override
    protected void onResume() {
        super.onResume();
        showLog("onResume Finish...");
    }

    public void startAnotherActivity(View view) {
        startActivity(new Intent(this, SecondActivity.class));
    }

    public void finishActivity(View view) {
        finish();
    }

    private void showLog(String message){
        Log.d("Lifecycle test", message);
    }
}
