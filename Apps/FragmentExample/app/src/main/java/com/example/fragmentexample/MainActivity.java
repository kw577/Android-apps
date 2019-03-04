package com.example.fragmentexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    // tworzymy pliki klas rozszerzajace klase Fragment i odpowiadajace im layouty (zaprojektowane graficznie lub w .xml)
    // nastepnie odpowiedznio modyfikuje sie layout activity_main.xml uzywajac LinearLayout

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
