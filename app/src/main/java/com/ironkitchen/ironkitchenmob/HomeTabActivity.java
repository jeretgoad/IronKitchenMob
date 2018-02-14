package com.ironkitchen.ironkitchenmob;


import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.widget.AdapterViewFlipper;


import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

import layout.FlipperAdapter;

public class HomeTabActivity extends AppCompatActivity{

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private static List<Fragment> fraggyList;
    /**
     * The {@link ViewPager} that will host the section contents.
     */
    public static ViewPager mViewPager;
    private Intent getIntent;
    private AdapterViewFlipper viewAdapter;
    private ArrayList<Integer> imageList;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_tab);
        imageList = getImagesList();
        viewAdapter = (AdapterViewFlipper)findViewById(R.id.viewFlipper);
        FlipperAdapter adapter = new FlipperAdapter(getApplicationContext(), imageList);
        viewAdapter.setAdapter(adapter);
        viewAdapter.setAutoStart(true);
        viewAdapter.setFlipInterval(10000);
        viewAdapter.startFlipping();
        fraggyList = getFragmentsList();
        rv = (RecyclerView)findViewById(R.id.recView1);
        System.out.println("RecyclerView size from activity: " + rv.getChildCount());
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), fraggyList);

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));



    }

    public ArrayList<Integer> getImagesList()
    {
        ArrayList<Integer> images = new ArrayList<Integer>();
        images.add(R.drawable.burritoes);
        images.add(R.drawable.col2);
        images.add(R.drawable.col3);
        images.add(R.drawable.for_home);
        images.add(R.drawable.keto_bowls_5);
        images.add(R.drawable.pickup);
        images.add(R.drawable.back_again);
        images.add(R.drawable.broc_chic);
        images.add(R.drawable.col_wid_sauce);
        images.add(R.drawable.frig);
        return images;
    }

    public List<Fragment> getFragmentsList()
    {
        List<Fragment> fragments = new Vector<Fragment>();
        fragments.add(new home_tab());
        fragments.add(new meal_prep());
        fragments.add(new family_prep());
        fragments.add(new iron_lunch());
        return fragments;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home_tab, menu);
        return true;
    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> mFragments;

        public SectionsPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
            super(fm);
            mFragments = fragments;
        }

        public Fragment getFragment(int position)
        {
            return mSectionsPagerAdapter.getItem(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

    }


}
