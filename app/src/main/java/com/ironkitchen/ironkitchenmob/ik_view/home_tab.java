package com.ironkitchen.ironkitchenmob.ik_view;



import android.os.Bundle;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.ironkitchen.ironkitchenmob.R;
import com.ironkitchen.ironkitchenmob.ik_data.FakeDataSource;
import com.ironkitchen.ironkitchenmob.ik_data.IKdataSourceInterface;
import com.ironkitchen.ironkitchenmob.ik_data.MobTabObjects;

import java.util.ArrayList;


/**
 * Created by jeretgoad on 1/21/18.
 */


public class home_tab extends Fragment {

    private View daView;
    private RecyclerView recyclerView;
    private GridLayoutManager mobGridLayout;
    private RecyclerView.Adapter mobAdapter;
    private ArrayList<MobTabObjects> mobObjects;
    private FakeDataSource fds;
    private IKdataSourceInterface ik_dsi;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        daView =  inflater.inflate(R.layout.fragment_home_tab, container, false);
        recyclerView = (RecyclerView) daView.findViewById(R.id.homeRecView);
        recyclerView.setHasFixedSize(true);
        mobGridLayout = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(mobGridLayout);
        mobObjects = getMobList();
        mobAdapter = new MobAdapter(getActivity(), mobObjects);
        recyclerView.setAdapter(mobAdapter);
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), recyclerView, new RecyclerTouchListener.OnItemClickListener() {
          @Override
          public void onItemClick(View view, final int cyclePosition) {
            if(cyclePosition>1) {
                ((HomeTabActivity) getActivity()).choosePage(cyclePosition-1);
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
        for(int i = 0; i < 4; i++){
            mobObjects.add(ik_dsi.createNewMobTabObjects(i));
        }


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
