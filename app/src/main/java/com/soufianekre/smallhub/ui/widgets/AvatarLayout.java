package com.soufianekre.smallhub.ui.widgets;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.signature.ObjectKey;
import com.soufianekre.smallhub.R;
import com.soufianekre.smallhub.helper.InputHelper;
import com.soufianekre.smallhub.helper.PrefGetter;
import com.soufianekre.smallhub.ui.user.UserPagerActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.gavinliu.android.lib.shapedimageview.ShapedImageView;

public class AvatarLayout extends FrameLayout {

    @BindView(R.id.avatar)
    ShapedImageView avatar;
    @Nullable private String login;
    private boolean isOrg;

    @OnClick(R.id.avatar)
    void onClick(@NonNull View view) {
        if (InputHelper.isEmpty(login)) return;
        UserPagerActivity.startActivity(view.getContext(), login, isOrg, -1);
    }

    public AvatarLayout(@NonNull Context context) {
        super(context);
    }

    public AvatarLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public AvatarLayout(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public AvatarLayout(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr, @StyleRes int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override protected void onFinishInflate() {
        super.onFinishInflate();
        inflate(getContext(), R.layout.avatar_layout, this);
        if (isInEditMode()) return;
        ButterKnife.bind(this);
        setBackground();
        if (PrefGetter.isRectAvatar()) {
            avatar.setShape(ShapedImageView.SHAPE_MODE_ROUND_RECT, 15);
        }
    }

    public void setUrl(@Nullable String url, @Nullable String login, boolean isOrg) {
        setUrl(url, login,isOrg, false);
    }

    public void setUrl(@Nullable String url, @Nullable String login,boolean isOrg, boolean reload) {
        this.login = login;
        this.isOrg = isOrg;
        avatar.setContentDescription(login);
        if (login != null) {
            TooltipCompat.setTooltipText(avatar, login);
        } else {
            avatar.setOnClickListener(null);
            avatar.setOnLongClickListener(null);
        }
        Glide.with(getContext())
                .load(url)
                .fallback(ContextCompat.getDrawable(getContext(), R.drawable.ic_fasthub_mascot))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .signature(new ObjectKey(reload ? String.valueOf(System.currentTimeMillis()) : "0"))
                .dontAnimate()
                .into(avatar);
    }

    private void setBackground() {
        if (PrefGetter.isRectAvatar()) {
            setBackgroundResource(R.drawable.rect_shape);
        } else {
            setBackgroundResource(R.drawable.circle_shape);
        }
    }
}