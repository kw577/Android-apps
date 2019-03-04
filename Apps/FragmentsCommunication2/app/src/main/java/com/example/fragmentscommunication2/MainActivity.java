package com.example.fragmentscommunication2;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements MessageFragment.OnMessageSendListener {

    // fragmenty moge sie komunikowac za pomoca interfejsow - tu zdefiniowany wewnatrz klasy MessageFragment.java
    // aby dodawac fragmenty do MainActivity - nalezy w activity_main.xml utworzyc Layout - tu nazywa sie on fragment_container

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.fragment_container)!=null){
            if(savedInstanceState != null){
                return;
            }
        }

        MessageFragment messageFragment = new MessageFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, messageFragment, null).commit();
    }

    @Override
    public void onMessageSend(String message) {

        //przycisk send spowoduje zamiane fragmentu MessageFragment na DisplayFragment
        DisplayFragment displayFragment = new DisplayFragment();
        Bundle bundle = new Bundle(); // obiekt ten sluzy do przekazania dancych miedzy fragmentami "message" to identyfikator przekazywanej wartosci
        bundle.putString("message", message);
        displayFragment.setArguments(bundle);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, displayFragment, null);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

        //wyswietlenie tekstu




    }
}
