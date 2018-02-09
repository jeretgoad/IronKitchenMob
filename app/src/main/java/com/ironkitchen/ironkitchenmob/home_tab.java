package com.ironkitchen.ironkitchenmob;


import android.os.Bundle;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnItemTouchListener;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.R.*;
import android.widget.AdapterView;

import java.util.ArrayList;


/**
 * Created by jeretgoad on 1/21/18.
 */

public class home_tab extends Fragment {

    private View daView;
    private ViewPager viewPager;
    private RecyclerView recyclerView;
    private GridLayoutManager mobGridLayout;
    private RecyclerView.Adapter mobAdapter;
    private ArrayList<MobTabObjects> mobObjects;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i("onCreate", "created");
        System.out.println("onCreate bitch");
        viewPager = new ViewPager(getContext());
        viewPager.setId(R.id.tabs);
        daView =  inflater.inflate(R.layout.fragment_home_tab, container, false);
        recyclerView = (RecyclerView) daView.findViewById(R.id.recView1);
        recyclerView.setHasFixedSize(true);
        mobGridLayout = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(mobGridLayout);
        mobObjects = getMobList();
        mobAdapter = new MobAdapter(getActivity(), mobObjects);
        recyclerView.setAdapter(mobAdapter);
        recyclerView.setLayoutManager(mobGridLayout);
        System.out.println(recyclerView.getAdapter().getItemCount());
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), recyclerView, new RecyclerTouchListener.OnItemClickListener() {
          @Override
          public void onItemClick(View view, int position) {
              System.out.println("onClick method inside recyclerView");
            if(position > 1)
            {
                System.out.println("inside if: position " + position);
                viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                        System.out.println("onPageScrolled");
                    }

                    @Override
                    public void onPageSelected(int position) {
                        System.out.println("onPageSelected");
                        Fragment fragment = ((HomeTabActivity.SectionsPagerAdapter)viewPager.getAdapter()).getFragment(position);
                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {
                        System.out.println("onPageScrollStateChanged");
                    }
                });
            }
          }
          @Override
          public void onLongItemClick(View view, int position) {
                System.out.println("longClick");
          }
        }));
        return daView;
    }


    public ArrayList<MobTabObjects> getMobList()
    {
        ArrayList<MobTabObjects> mobObjects = new ArrayList<>();

        MobTabObjects doubleView = new MobTabObjects(R.drawable.ik_loc, R.raw.ik_intro, 2);
        mobObjects.add(doubleView);
        MobTabObjects frigLoc = new MobTabObjects(R.drawable.frig_loc, 1);
        mobObjects.add(frigLoc);
        MobTabObjects mealPrep = new MobTabObjects("Meal Prep",  R.drawable.broc_chic, 0);
        mobObjects.add(mealPrep);
        MobTabObjects familyPrep = new MobTabObjects("Family Prep", R.drawable.cbr_trey, 0);
        mobObjects.add(familyPrep);
        MobTabObjects lunch = new MobTabObjects("Lunch", R.drawable.lunch_button, 0);
        mobObjects.add(lunch);

        return mobObjects;
    }

    public static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        public interface OnItemClickListener {
            public void onItemClick(View view, int position);
            public void onLongItemClick(View view, int position);
        }

        private OnItemClickListener mListener;
        private GestureDetector mGesture;
        public RecyclerTouchListener(Context context, final RecyclerView rView, OnItemClickListener listener) {
            mListener = listener;

            mGesture = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapConfirmed(MotionEvent e) {
                    View childView = rView.findChildViewUnder(e.getX(), e.getY());

                    if (childView != null && mListener != null) {
                        mListener.onItemClick(childView, rView.getChildAdapterPosition(childView));
                    }
                    return true;
                }
            });
        }
        @Override public boolean onInterceptTouchEvent(RecyclerView view, MotionEvent e) {
            View childView = view.findChildViewUnder(e.getX(), e.getY());
            if(childView != null && mListener != null && mGesture.onTouchEvent(e)) {
                mListener.onItemClick(childView, view.getChildAdapterPosition(childView));
                return true;
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView view, MotionEvent e) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept){

        }
    }
}
