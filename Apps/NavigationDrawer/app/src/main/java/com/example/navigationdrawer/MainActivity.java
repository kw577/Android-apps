package com.example.navigationdrawer;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        //dodanie przycisku do paska aplikacji
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);


        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigationView);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                //sprawdzenie ktora ikona zostala wybrana
                switch (menuItem.getItemId()){

                    case R.id.nav_camera:
                        menuItem.setChecked(true);
                        displayMessage("Import Selected...");
                        drawerLayout.closeDrawers();
                        return true;

                    case R.id.nav_gallery:
                        menuItem.setChecked(true);
                        displayMessage("Gallery Selected...");
                        drawerLayout.closeDrawers();
                        return true;

                    case R.id.nav_slideshow:
                        menuItem.setChecked(true);
                        displayMessage("Slide show Selected...");
                        drawerLayout.closeDrawers();
                        return true;

                    case R.id.nav_tools:
                        menuItem.setChecked(true);
                        displayMessage("Tools Selected...");
                        drawerLayout.closeDrawers();
                        return true;

                }


                return false;
            }
        });
    }


    private void displayMessage(String message)
    {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return  true;
        }



        return super.onOptionsItemSelected(item);
    }
}
