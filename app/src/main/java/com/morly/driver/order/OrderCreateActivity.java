package com.morly.driver.order;

import android.os.Bundle;
import android.view.View;

import com.common.library.viewModel.BaseViewModel;
import com.morly.driver.R;
import com.morly.driver.base.BaseNavActivity;

import butterknife.OnClick;

/**
 * Created by riven_chris on 2017/4/4.
 */

public class OrderCreateActivity extends BaseNavActivity implements View.OnClickListener {

    @Override
    protected boolean useDataBinding() {
        return false;
    }

    @Override
    protected void onViewCreated(Bundle savedInstanceState) {

    }

    @Override
    protected BaseViewModel bind() {
        return null;
    }

    @Override
    public void onLeftTitleClick() {
        finish();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_create_order;
    }

    @OnClick({R.id.tv_create_order})
    @Override
    public void onClick(View v) {

    }
}
