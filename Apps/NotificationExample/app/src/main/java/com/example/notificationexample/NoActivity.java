package com.example.notificationexample;

import android.app.NotificationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no);

        //po wcisnieciu przycisku "Yes" na notyfikacji nastepuje przeniesienie do tego Activity i usuniecie notyfikacji
        //usuniecie notyfikacji po wcisnieciu przycisku
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.cancel(MainActivity.NOTIFICATION_ID);
    }
}
