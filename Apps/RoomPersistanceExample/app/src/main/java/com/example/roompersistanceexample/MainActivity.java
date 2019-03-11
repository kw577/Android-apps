package com.example.roompersistanceexample;

import android.arch.persistence.room.Room;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public static FragmentManager fragmentManager;
    public static MyAppDatabase myAppDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();

        //baza danych nazywa sie userdb
        myAppDatabase = Room.databaseBuilder(getApplicationContext(), MyAppDatabase.class, "userdb")
                .allowMainThreadQueries().build();

        //allowMainThreadQueries()  - domyslnie nie jest dozwolone wykonywanie operacji na watku glownym
        //i aplikacja wyrzuci blad przy probie takiego polaczenia z baza
        //ta komenda umozliwi operacje na bazie w watku glownym

        if(findViewById(R.id.fragment_container)!=null){
            if(savedInstanceState!=null){
                return;
            }

            //dodanie fragmentu HomeFragment do MainActivity
            fragmentManager.beginTransaction().add(R.id.fragment_container, new HomeFragment()).commit();

        }

    }
}
