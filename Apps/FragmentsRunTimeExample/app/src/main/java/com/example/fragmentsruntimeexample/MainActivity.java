package com.example.fragmentsruntimeexample;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    // w pliku activity_main.xml dodajemy FrameLayout - w pliku .xml lub za pomoca edytora graficznego
    // nastepnie tworzy sie klasy rozszerzajace klase fragment i ospowiadajace im layouty


    public static FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //inicjalizowanie fragmentManager
        fragmentManager = getSupportFragmentManager();

        if(findViewById(R.id.fragment_container)!=null){

            if(savedInstanceState!=null){
                return;
            }

            //dodawanie fragmentow
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            HomeFragment homeFragment = new HomeFragment(); // jeden z utworzonych klas w ramach projektu fragmentow
            fragmentTransaction.add(R.id.fragment_container, homeFragment, null); //fragment_container - to obiekt typu layout w activity_main.xml
            fragmentTransaction.commit();

        }

    }
}
