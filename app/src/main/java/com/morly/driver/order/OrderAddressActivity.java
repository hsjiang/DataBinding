package com.morly.driver.order;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.common.library.viewModel.BaseViewModel;
import com.morly.driver.R;
import com.morly.driver.base.BaseNavActivity;

import butterknife.OnClick;

/**
 * Created by riven_chris on 2017/4/4.
 */

public class OrderAddressActivity extends BaseNavActivity implements View.OnClickListener {

    @Override
    protected boolean useDataBinding() {
        return false;
    }

    @Override
    protected BaseViewModel bind() {
        return null;
    }

    @Override
    public void onRightTitleClick() {
        finish();
    }

    @Override
    protected void onViewCreated(Bundle savedInstanceState) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_order_address;
    }

    @OnClick({R.id.tv_next})
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_next:
                startActivity(new Intent(this, OrderCreateActivity.class));
                break;
        }
    }
}
