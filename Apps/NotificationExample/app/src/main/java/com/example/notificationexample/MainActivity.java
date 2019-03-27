package com.example.notificationexample;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.RemoteInput;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private final String CHANNEL_ID = "personal_notification";
    public static final int NOTIFICATION_ID = 001;

    public static final String TXT_REPLY = "text_reply";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayNotification(View view) {

        // notification channel - wymagany dla wersji Androida nowszych od 7.1
        createNotificationChnnel();

        Intent landingIntent = new Intent(this, LandingActivity.class);
        landingIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

        PendingIntent landingPendingIntent = PendingIntent.getActivity(this, 0, landingIntent, PendingIntent.FLAG_ONE_SHOT);


        //dodawanie przyciskow do notyfikacji

        Intent yesIntent = new Intent(this, YesActivity.class);
        yesIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent yesPendingIntent = PendingIntent.getActivity(this, 0, yesIntent, PendingIntent.FLAG_ONE_SHOT);


        Intent noIntent = new Intent(this, NoActivity.class);
        noIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent noPendingIntent = PendingIntent.getActivity(this, 0, noIntent, PendingIntent.FLAG_ONE_SHOT);


        //---------------

        final NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID);

        builder.setSmallIcon(R.drawable.ic_download);
        builder.setContentTitle("Image download");
        builder.setContentText("Download in progress...");
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);

        //progress bar
        final int max_progress = 100;
        int current_progress = 0;
        builder.setProgress(max_progress, current_progress, false);




        //-------------------




        //pokliknieciu na notyfikacje nastepuje przeniesienie do aplikacji
        builder.setAutoCancel(true);
        builder.setContentIntent(landingPendingIntent);

        //dodanie przyciskow do notyfikacji
        builder.addAction(R.drawable.ic_download, "Yes", yesPendingIntent);
        builder.addAction(R.drawable.ic_download, "No", noPendingIntent);


        //-----------------

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){

            RemoteInput remoteInput = new RemoteInput.Builder(TXT_REPLY).setLabel("Reply").build();

            Intent replyIntent = new Intent(this, RemoteReceiver.class);
            replyIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            PendingIntent replyPendingIntent = PendingIntent.getActivity(this, 0 , replyIntent, PendingIntent.FLAG_ONE_SHOT);

            NotificationCompat.Action action = new NotificationCompat.Action
                    .Builder(R.drawable.ic_sms_notification, "Reply", replyPendingIntent)
                    .addRemoteInput(remoteInput).build();


            builder.addAction(action);

        }

        //Expandable Notification - rozwijana notyfikacja - tu przechowuje obrazek
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.img3);
        builder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap));

        //----------------



        final NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(NOTIFICATION_ID, builder.build());


        //progres bar - update status
        Thread thread = new Thread(){
            @Override
            public void run() {
                int count = 0;

                try {
                    while(count <= 100){
                        count += 10;
                        sleep(1000);
                        builder.setProgress(max_progress, count, false);
                        notificationManagerCompat.notify(NOTIFICATION_ID, builder.build()); //upadate notyfikacji

                    }

                    //po zakonczeniu ladawania paska postepu
                    builder.setContentText("Download completed");
                    builder.setProgress(0, 0, false); //usuniecie paska postepu z notyfikacji
                    notificationManagerCompat.notify(NOTIFICATION_ID, builder.build()); //upadate notyfikacji


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        thread.start();
    }


    //notification channel - wymagany dla wersji Androida nowszych od 7.1
    private void createNotificationChnnel(){

        //sprawdzenie wersji systemu
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            CharSequence name = "Personal Notification";
            String description = "Include all the personal notifications";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, name, importance);

            notificationChannel.setDescription(description);

            NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);



        }
    }


}
