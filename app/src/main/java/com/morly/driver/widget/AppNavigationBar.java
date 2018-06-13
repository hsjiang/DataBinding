package com.morly.driver.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.morly.driver.R;

/**
 * Created by riven_chris on 2017/3/26.
 */

public class AppNavigationBar extends FrameLayout implements View.OnClickListener {

    public interface OnNavClickListener {

        void onTitleClick();

        void onLeftTitleClick();

        void onLeftIconClick();

        void onRightTitleClick();

        void onRightIconClick();
    }

    private TextView tvTitle;
    private TextView tvLeft;
    private TextView tvRight;
    private ImageView ivLeft;
    private ImageView ivRight;

    private OnNavClickListener onNavClickListener;

    public AppNavigationBar(@NonNull Context context) {
        this(context, null);
    }

    public AppNavigationBar(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AppNavigationBar(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.layout_navigation_bar, this);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        setId(R.id.navigation_bar);

        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.navigation_bar);
        String title = a.getString(R.styleable.navigation_bar_title);
        String leftTitle = a.getString(R.styleable.navigation_bar_left_title);
        int leftIconId = a.getResourceId(R.styleable.navigation_bar_left_icon, 0);
        String rightTitle = a.getString(R.styleable.navigation_bar_right_title);
        int rightIconId = a.getInt(R.styleable.navigation_bar_right_icon, 0);
        a.recycle();

        tvTitle = (TextView) findViewById(R.id.tv_nav_title);
        tvLeft = (TextView) findViewById(R.id.tv_nav_left);
        tvRight = (TextView) findViewById(R.id.tv_nav_right);
        ivLeft = (ImageView) findViewById(R.id.iv_nav_left);
        ivRight = (ImageView) findViewById(R.id.iv_nav_right);

        setTitle(title);
        setLeftText(leftTitle);
        if (leftIconId != 0)
            setLeftIcon(ContextCompat.getDrawable(context, leftIconId));
        setRightText(rightTitle);
        if (rightIconId != 0)
            setRightIcon(ContextCompat.getDrawable(context, rightIconId));

        tvTitle.setOnClickListener(this);
        tvLeft.setOnClickListener(this);
        tvRight.setOnClickListener(this);
        ivLeft.setOnClickListener(this);
        ivRight.setOnClickListener(this);
    }

    public void setOnNavClickListener(OnNavClickListener onNavClickListener) {
        this.onNavClickListener = onNavClickListener;
    }

    public void setTitle(String title) {
        tvTitle.setText(title);
        tvTitle.setVisibility(View.VISIBLE);
    }

    public void setLeftText(String text) {
        tvLeft.setText(text);
        tvLeft.setVisibility(View.VISIBLE);
    }

    public void setRightText(String text) {
        tvRight.setText(text);
        tvRight.setVisibility(View.VISIBLE);
    }

    public void setLeftIcon(Drawable drawable) {
        ivLeft.setImageDrawable(drawable);
        ivLeft.setVisibility(View.VISIBLE);
    }

    public void setRightIcon(Drawable drawable) {
        ivRight.setImageDrawable(drawable);
        ivRight.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(View v) {
        if (onNavClickListener != null) {
            switch (v.getId()) {
                case R.id.tv_nav_title:
                    onNavClickListener.onTitleClick();
                    break;
                case R.id.tv_nav_left:
                    onNavClickListener.onLeftTitleClick();
                    break;
                case R.id.iv_nav_left:
                    onNavClickListener.onLeftIconClick();
                    break;
                case R.id.tv_nav_right:
                    onNavClickListener.onRightTitleClick();
                    break;
                case R.id.iv_nav_right:
                    onNavClickListener.onRightIconClick();
                    break;
            }
        }
    }
}
