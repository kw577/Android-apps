package com.example.appbarsearch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    private List<String> list;
    private RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolBar);

        //ustawienie zaprojektowanego paska narzedzi jako glownego paska narzedzi aplikacji
        setSupportActionBar(toolbar);


        //dodanie listy panstw zdefiniowanej w app/res/layout
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        list = Arrays.asList(getResources().getStringArray(R.array.country_list));
        adapter = new RecyclerAdapter(list);
        recyclerView.setHasFixedSize(true);

        recyclerView.setAdapter(adapter);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.toolbar_menu, menu);


        MenuItem.OnActionExpandListener onActionExpandListener = new MenuItem.OnActionExpandListener(){

            //metoda wywolywana gdy uzytkownik rozwija pole wyszukiwania
            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {

                //Toast.makeText(MainActivity.this, "Action View Expanded...", Toast.LENGTH_SHORT).show();
                return true;
            }

            //metoda wywolywana gdy uzytkownik zamyka pole wyszukwania
            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {

                //Toast.makeText(MainActivity.this, "Action View Collapsed...", Toast.LENGTH_SHORT).show();

                return true;
            }
        };

        MenuItem searchItem = menu.findItem(R.id.action_search);

        searchItem.setOnActionExpandListener(onActionExpandListener);
        SearchView searchView = (SearchView)searchItem.getActionView();
        searchView.setOnQueryTextListener(this);
        return true;
    }


    //ponizej metody do filtrowania wynikow wyszukiwania
    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        String userInput = newText.toLowerCase();
        List<String> newList = new ArrayList<>();

        for(String name : list){
            if(name.toLowerCase().contains(userInput)){
                newList.add(name);
            }
        }

        //filtrowanie na podstawie wpisanej frazy wyszukiwania
        adapter.updateList(newList);
        return true;
    }
}