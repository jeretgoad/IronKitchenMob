package com.ironkitchen.ironkitchenmob;


import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.widget.AdapterViewFlipper;


import java.io.InputStream;
import java.util.ArrayList;

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

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    private Intent getIntent;
    private AdapterViewFlipper viewAdapter;
    private ArrayList<Integer> images;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_tab);
        images = getImages();
        viewAdapter = (AdapterViewFlipper)findViewById(R.id.viewFlipper);
        FlipperAdapter adapter = new FlipperAdapter(getApplicationContext(), images);
        viewAdapter.setAdapter(adapter);
        viewAdapter.setAutoStart(true);
        viewAdapter.setFlipInterval(10000);
        viewAdapter.startFlipping();

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));



    }

    public ArrayList<Integer> getImages()
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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home_tab, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public Fragment getFragment(int position)
        {
            return mSectionsPagerAdapter.getItem(position);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    home_tab tab1 = new home_tab();
                    return tab1;
                case 1:
                    meal_prep tab2 = new meal_prep();
                    return tab2;
                case 2:
                    family_prep tab3 = new family_prep();
                    return tab3;
                case 3:
                    iron_lunch tab4 = new iron_lunch();
                    return tab4;
                default:
                    return null;
            }
        }



        @Override
        public int getCount() {
            // Show 3 total pages.
            return 4;
        }
    }
}
