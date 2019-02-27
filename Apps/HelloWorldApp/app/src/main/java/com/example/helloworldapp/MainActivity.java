package com.example.helloworldapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


// uruchamianie aplikacji w srodowisku symulowanym:
// tools -> AVD manager -> Create Virtual Device -> wybrac rodzaj urzadzenia (np Phone) -> Nexr -> wybrac Platforme Androida (np Oreo) -> Next -> Ustawenia -> Finish -> Uruchamiamy emulator
// dodatkowo w oknie Android Studio uruchamiamy aplikacje - Run App
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
