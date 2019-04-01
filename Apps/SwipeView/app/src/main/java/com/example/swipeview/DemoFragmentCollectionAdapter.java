package com.example.swipeview;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class DemoFragmentCollectionAdapter extends FragmentStatePagerAdapter {

    public DemoFragmentCollectionAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        DemoFragment demoFragment = new DemoFragment();
        Bundle bundle = new Bundle();
        position = position + 1;
        bundle.putString("message", "Hello From Page : " + position);

        demoFragment.setArguments(bundle);

        return demoFragment;
    }

    @Override
    public int getCount() {
        return 100;
    }
}
