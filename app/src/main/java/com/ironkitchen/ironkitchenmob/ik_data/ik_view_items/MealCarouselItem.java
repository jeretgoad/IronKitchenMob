package com.ironkitchen.ironkitchenmob.ik_data.ik_view_items;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;

import com.ironkitchen.ironkitchenmob.R;
import com.ironkitchen.ironkitchenmob.ik_view.ik_viewholders.MealCarouselViewHolder;
import com.xwray.groupie.GroupAdapter;
import com.xwray.groupie.Item;

public class MealCarouselItem extends Item<MealCarouselViewHolder>{

    private RecyclerView.Adapter adapter;
    private RecyclerView carouselRV;
    private RecyclerView.ItemDecoration carouselDecoration;
    private LinearLayoutManager layoutManager;

    public MealCarouselItem(RecyclerView.ItemDecoration itemDecoration){
        this.carouselDecoration = itemDecoration;
    }

    public void setAdapter(GroupAdapter adapter){
        this.adapter = adapter;
    }

    public RecyclerView.Adapter getAdapter(){
        return adapter;
    }

    public RecyclerView getRecyclerView(){
        return carouselRV;
    }

    public LinearLayoutManager getLayoutManager() {
        return layoutManager;
    }

    @Override
    public MealCarouselViewHolder createViewHolder(View itemView) {
        return new MealCarouselViewHolder(itemView);
    }

    @Override
    public int getLayout() {
        return R.layout.carousel_item;
    }

    @Override
    public void bind(@NonNull MealCarouselViewHolder viewHolder, int position) {
        carouselRV = viewHolder.carouselRV;
        layoutManager = new LinearLayoutManager(carouselRV.getContext(), LinearLayoutManager.HORIZONTAL,false);
        carouselRV.setLayoutManager(layoutManager);
        carouselRV.setAdapter(adapter);

        carouselRV.removeItemDecoration(carouselDecoration);
        carouselRV.addItemDecoration(carouselDecoration);

    }
}
