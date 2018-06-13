package com.morly.driver.base;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.common.library.viewModel.BaseViewModel;
import com.morly.driver.R;
import com.morly.driver.widget.AppNavigationBar;

import butterknife.BindView;

/**
 * Created by riven_chris on 2017/3/26.
 */

public abstract class BaseNavFragment<V extends BaseViewModel, D extends ViewDataBinding> extends BaseFragment<V, D> implements AppNavigationBar.OnNavClickListener {

    @BindView(R.id.navigation_bar)
    protected AppNavigationBar nav;

    @Override
    protected void onViewCreatedFinish(View view, @Nullable Bundle savedInstanceState) {
        nav.setOnNavClickListener(this);
    }

    @Override
    public void onTitleClick() {

    }

    @Override
    public void onLeftTitleClick() {

    }

    @Override
    public void onLeftIconClick() {

    }

    @Override
    public void onRightTitleClick() {

    }

    @Override
    public void onRightIconClick() {

    }
}
