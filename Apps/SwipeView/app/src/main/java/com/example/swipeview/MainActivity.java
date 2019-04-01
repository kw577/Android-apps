package com.example.swipeview;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;


public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    //private DemoFragmentCollectionAdapter adapter;
    private ViewPagerAdapter adapter;

    private Toolbar toolbar;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolBar);

        viewPager = findViewById(R.id.pager);
        //adapter = new DemoFragmentCollectionAdapter(getSupportFragmentManager());
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout = findViewById(R.id.tabs);

        //zakladki odpowidaja stonom na ViewPager - metoda ViewPagerAdapter.getPageTitle()
        tabLayout.setupWithViewPager(viewPager);
    }
}
