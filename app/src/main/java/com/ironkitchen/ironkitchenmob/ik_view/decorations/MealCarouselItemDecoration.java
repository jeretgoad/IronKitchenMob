package com.ironkitchen.ironkitchenmob.ik_view.decorations;

import android.support.annotation.ColorInt;
import android.support.v7.widget.RecyclerView;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public class MealCarouselItemDecoration extends RecyclerView.ItemDecoration{

    private final Paint carouselBGcolor;
    private final int padding;

    public MealCarouselItemDecoration(@ColorInt int carouselBGcolor, int padding) {
        this.carouselBGcolor = new Paint();
        this.carouselBGcolor.setColor(carouselBGcolor);
        this.padding = padding;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.right = padding;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int childCount = parent.getChildCount();
        RecyclerView.LayoutManager lm = parent.getLayoutManager();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);

            int right = (int) (lm.getDecoratedRight(child) + child.getTranslationX());
            if (i == childCount - 1) {
                // Last item
                right = Math.max(right, parent.getWidth());
            }

            // Right border
            c.drawRect(child.getRight() + child.getTranslationX(), 0, right, parent.getHeight(), carouselBGcolor);
        }
    }
}
