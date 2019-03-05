package com.example.sqliteexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements HomeFragment.OnDbOperationListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.fragment_container) != null){

            if(savedInstanceState != null){
                return;
            }

            HomeFragment homeFragment = new HomeFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, homeFragment).commit();
        }



    }

    @Override
    public void dbOperationPerform(int method) {

        switch (method)
        {
            case 0: // wybrano opcje dodawania nowej osoby do listy kontaktow, nastapi przeniesienie do odpowiedniego layoutu
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new AddContactFragment())
                        .addToBackStack(null).commit();
                break;
        }

    }
}
