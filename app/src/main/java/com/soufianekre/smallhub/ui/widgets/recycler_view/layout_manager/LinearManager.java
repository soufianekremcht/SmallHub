package com.soufianekre.smallhub.ui.widgets.recycler_view.layout_manager;

import android.content.Context;
import android.util.AttributeSet;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Kosh on 17 May 2016, 10:02 PM
 */
public class LinearManager extends LinearLayoutManager {

    public LinearManager(Context context) {
        super(context);
    }

    public LinearManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    public LinearManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        try {
            super.onLayoutChildren(recycler, state);
        } catch (Exception ignored) {}
    }

    @Override public void onMeasure(RecyclerView.Recycler recycler, RecyclerView.State state, int widthSpec, int heightSpec) {
        try {
            super.onMeasure(recycler, state, widthSpec, heightSpec);
        } catch (Exception ignored) {}
    }

}
