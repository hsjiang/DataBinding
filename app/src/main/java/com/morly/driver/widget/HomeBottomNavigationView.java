package com.morly.driver.widget;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.morly.driver.R;

/**
 * Created by riven_chris on 2017/3/25.
 */

public class HomeBottomNavigationView extends FrameLayout implements View.OnClickListener {

    public interface NavigationClickListener {
        void onItemClicked(int position);
    }

    private TextView tvService;
    private TextView tvBenefit;
    private TextView tvLocal;
    private TextView tvMe;

    private TextView[] items = null;
    private int currentPosition = 0;
    private NavigationClickListener navigationClickListener;

    public HomeBottomNavigationView(Context context) {
        this(context, null);
    }

    public HomeBottomNavigationView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HomeBottomNavigationView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setBackgroundColor(Color.parseColor("#F5F5F5"));
        LayoutInflater.from(context).inflate(R.layout.layout_home_bottom_navigation, this);
        init();
    }

    private void init() {
        tvService = (TextView) findViewById(R.id.tv_service);
        tvBenefit = (TextView) findViewById(R.id.tv_benefit);
        tvLocal = (TextView) findViewById(R.id.tv_local);
        tvMe = (TextView) findViewById(R.id.tv_me);
        items = new TextView[]{tvService, tvBenefit, tvLocal, tvMe};

        tvService.setOnClickListener(this);
        tvBenefit.setOnClickListener(this);
        tvLocal.setOnClickListener(this);
        tvMe.setOnClickListener(this);
    }

    public void setNavigationClickListener(NavigationClickListener navigationClickListener) {
        this.navigationClickListener = navigationClickListener;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public TextView getCurrentItem() {
        return items[currentPosition];
    }

    @Override
    public void onClick(View v) {
        int position = 0;
        switch (v.getId()) {
            case R.id.tv_service:
                position = 0;
                break;
            case R.id.tv_benefit:
                position = 1;
                break;
            case R.id.tv_local:
                position = 2;
                break;
            case R.id.tv_me:
                position = 3;
                break;
        }
        switchItemState(position);
    }

    private void switchItemState(int position) {
        for (int i = 0; i < items.length; i++) {
            TextView item = items[i];
            if (i == position) {
                item.setTextColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
                item.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_notifications_black_24dp, 0, 0);
            } else {
                item.setTextColor(ContextCompat.getColor(getContext(), R.color.text_black));
                item.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_home_black_24dp, 0, 0);
            }
        }
        currentPosition = position;
        if (navigationClickListener != null)
            navigationClickListener.onItemClicked(position);

    }
}
