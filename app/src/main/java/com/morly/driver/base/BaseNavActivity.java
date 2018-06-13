package com.morly.driver.base;

import android.databinding.ViewDataBinding;
import android.os.Bundle;

import com.common.library.viewModel.BaseViewModel;
import com.morly.driver.R;
import com.morly.driver.widget.AppNavigationBar;

import butterknife.BindView;

/**
 * Created by riven_chris on 2017/4/4.
 */

public abstract class BaseNavActivity<V extends BaseViewModel, D extends ViewDataBinding> extends BaseActivity<V, D>
        implements AppNavigationBar.OnNavClickListener {

    @BindView(R.id.navigation_bar)
    protected AppNavigationBar nav;

    @Override
    protected void onViewCreated(Bundle savedInstanceState) {
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
