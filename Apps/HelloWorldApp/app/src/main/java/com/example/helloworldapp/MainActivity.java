package com.example.helloworldapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


// uruchamianie aplikacji w srodowisku symulowanym:
// tools -> AVD manager -> Create Virtual Device -> wybrac rodzaj urzadzenia (np Phone) -> Nexr -> wybrac Platforme Androida (np Oreo) -> Next -> Ustawenia -> Finish -> Uruchamiamy emulator
// dodatkowo w oknie Android Studio uruchamiamy aplikacje - Run App
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    // wpisujemy metode dla przycisku na ekranie glownym
    // po wcisnieciu przycisku pojawi sie strona zdefiniowana w activity_message.xml
    public void sendMessage(View view){

        //obiekt typu editText - przypisujemy mu komponent dodany do widoku activity_main.xml o id=user_message
        EditText editText = findViewById(R.id.user_message);

        //pobiera tekst wpisany przez uzytkownika
        String message = editText.getText().toString();



        Intent intent = new Intent(this, MessageActivity.class);

        // dodanie tekstu aby byl przeslany do kolejnego widoku
        intent.putExtra("EXTRA_MESSAGE", message);

        // przeniesienie do nowego activity
        startActivity(intent);
    }


}
