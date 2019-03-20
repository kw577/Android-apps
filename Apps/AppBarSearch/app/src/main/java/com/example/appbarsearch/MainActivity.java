package com.example.appbarsearch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolBar);

        //ustawienie zaprojektowanego paska narzedzi jako glownego paska narzedzi aplikacji
        setSupportActionBar(toolbar);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.toolbar_menu, menu);


        MenuItem.OnActionExpandListener onActionExpandListener = new MenuItem.OnActionExpandListener(){

            //metoda wywolywana gdy uzytkownik rozwija pole wyszukiwania
            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {

                Toast.makeText(MainActivity.this, "Action View Expanded...", Toast.LENGTH_SHORT).show();
                return true;
            }

            //metoda wywolywana gdy uzytkownik zamyka pole wyszukwania
            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {

                Toast.makeText(MainActivity.this, "Action View Collapsed...", Toast.LENGTH_SHORT).show();

                return true;
            }
        };

        MenuItem searchItem = menu.findItem(R.id.action_search);

        searchItem.setOnActionExpandListener(onActionExpandListener);

        return true;
    }
}