package com.soufianekre.smallhub.ui.widgets;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import static android.R.attr.enabled;



public class ViewPagerView extends ViewPager {

    private boolean isEnabled;

    public ViewPagerView(Context context) {
        super(context);
    }

    public ViewPagerView(@NonNull Context context, AttributeSet attrs) {
        super(context, attrs);
        int[] attrsArray = {enabled};
        TypedArray array = context.obtainStyledAttributes(attrs, attrsArray);
        isEnabled = array.getBoolean(0, true);
        array.recycle();
    }

    @Override public boolean isEnabled() {
        return isEnabled;
    }

    @Override public void setEnabled(boolean enabled) {
        this.isEnabled = enabled;
        requestLayout();
    }

    @Override public void setAdapter(@Nullable PagerAdapter adapter) {
        super.setAdapter(adapter);
        if (isInEditMode()) return;
        if (adapter != null) {
            setOffscreenPageLimit(adapter.getCount());
        }
    }

    @SuppressLint("ClickableViewAccessibility") @Override public boolean onTouchEvent(MotionEvent event) {
        try {
            return !isEnabled() || super.onTouchEvent(event);
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override public boolean onInterceptTouchEvent(MotionEvent event) {
        try {
            return isEnabled() && super.onInterceptTouchEvent(event);
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
