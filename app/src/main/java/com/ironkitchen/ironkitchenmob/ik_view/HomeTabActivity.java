package com.ironkitchen.ironkitchenmob.ik_view;



import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.AdapterViewFlipper;

import com.google.android.material.tabs.TabLayout;
import com.ironkitchen.ironkitchenmob.R;
import com.ironkitchen.ironkitchenmob.ik_data.FakeDataSource;
import com.ironkitchen.ironkitchenmob.ik_data.IKdataSourceInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import layout.FlipperAdapter;

public class HomeTabActivity extends AppCompatActivity{

    /**
     * The {@link androidx.core.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link androidx.core.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private static List<Fragment> fraggyList;
    /**
     * The {@link ViewPager} that will host the section contents.
     */
    public static ViewPager mViewPager;
    private AdapterViewFlipper viewAdapter;
    private ArrayList<Integer> imageList;
    private IKdataSourceInterface ik_dsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_tab);
        ik_dsi = new FakeDataSource();
        imageList = (ArrayList<Integer>) ik_dsi.getSlideShow();
        viewAdapter = findViewById(R.id.viewFlipper);
        FlipperAdapter adapter = new FlipperAdapter(getApplicationContext(), imageList);
        viewAdapter.setAdapter(adapter);
        viewAdapter.setAutoStart(true);
        viewAdapter.setFlipInterval(10000);
        viewAdapter.startFlipping();
        fraggyList = getFragmentsList();
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), fraggyList);

        // Set up the ViewPager with the sections adapter.
        mViewPager = findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tabs);

        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }



    public List<Fragment> getFragmentsList()
    {
        List<Fragment> fragments = new Vector<>();
        fragments.add(new home_tab());
        fragments.add(new meal_prep());
        fragments.add(new family_prep());
        fragments.add(new iron_lunch());
        return fragments;
    }

    public void choosePage(int position)
    {
        mViewPager.setCurrentItem(position);
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
