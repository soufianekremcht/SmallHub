package com.soufianekre.smallhub.ui.widgets;


import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.TooltipCompat;

import com.soufianekre.smallhub.helper.ViewHelper;

public class ForegroundImageView extends AppCompatImageView {

    public ForegroundImageView(@NonNull Context context) {
        this(context, null);
    }

    public ForegroundImageView(@NonNull Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        if (getContentDescription() != null) {
            TooltipCompat.setTooltipText(this, getContentDescription());
        }
    }

    public ForegroundImageView(@NonNull Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void tintDrawableColor(@ColorInt int color) {
        ViewHelper.tintDrawable(getDrawable(), color);
    }
}