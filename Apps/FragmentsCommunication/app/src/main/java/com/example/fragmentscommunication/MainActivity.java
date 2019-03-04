package com.example.fragmentscommunication;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


// OnMessageReadListener - interfejs zdefiniowany wewnatrz klasy MessageFragment.java
//interfejs ten umozliwia komunikacje komponentow
public class MainActivity extends AppCompatActivity implements MessageFragment.OnMessageReadListener {

    // do komunikacji pomiedzy fragmentami konieczne sa interfejsy

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.fragment_container)!=null){

            if(savedInstanceState!=null){
                return;
            }

            //dodanie fragmentu
            MessageFragment messageFragment = new MessageFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                    .beginTransaction().add(R.id.fragment_container, messageFragment, null);

            fragmentTransaction.commit();

        }

    }

    @Override
    public void onMessageRead(String message) {
        textView = findViewById(R.id.txt_display_message);
        textView.setText(message);
    }
}
