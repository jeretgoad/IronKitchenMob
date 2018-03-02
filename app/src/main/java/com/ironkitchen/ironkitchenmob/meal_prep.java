package com.ironkitchen.ironkitchenmob;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class meal_prep extends Fragment {
    private View mealView;
    private RecyclerView mealRV;
    private MealAdapters mealAdapters;
    private OuterRVAdapter outerRVAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mealView = inflater.inflate(R.layout.fragment_meal_prep, container, false);
        mealRV  = (RecyclerView) mealView.findViewById(R.id.mealChoiceSelectionRV);
        mealAdapters = new MealAdapters(getActivity());
        outerRVAdapter = mealAdapters.getOuterAdapter();
        mealRV.setAdapter(outerRVAdapter);
        mealRV.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        return mealView;
    }


}
