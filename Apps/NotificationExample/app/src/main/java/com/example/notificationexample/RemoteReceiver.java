package com.example.notificationexample;

import android.app.NotificationManager;
import android.app.RemoteInput;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class RemoteReceiver extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remote_receiver);

        textView = findViewById(R.id.txt_display);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT_WATCH) {
            Bundle remoteReply = RemoteInput.getResultsFromIntent(getIntent());

            if(remoteReply!=null){
                String message = remoteReply.getCharSequence(MainActivity.TXT_REPLY).toString();
                textView.setText(message);
            }

        }

        //zamkniecie notyfikacji
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.cancel(MainActivity.NOTIFICATION_ID);

    }
}
