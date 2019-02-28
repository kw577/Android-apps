package com.example.helloworldapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


// przy utworzeniu nowej klasy typu activity automatycznie tworzy sie tez odpowiadajacy jej plik layoutu typu .xml

public class MessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        // pobranie obiektu Intent a MainActivity
        Intent intent = getIntent();

        String message = intent.getStringExtra("EXTRA_MESSAGE"); // EXTRA_MESSAGE - tak zostala nazwana zmienna w MainActivity

        // utworzenie obiektu typu textView i przypisanie mu obiektu o id=display_message - zdefiniowanym w widoku activity_message.xml
        TextView textView = findViewById(R.id.display_message);
        textView.setText(message);

    }
}
