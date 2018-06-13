package com.morly.driver.apply;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.common.library.viewModel.BaseViewModel;
import com.morly.driver.R;
import com.morly.driver.base.BaseNavActivity;

import butterknife.OnClick;


public class ApplyActivity extends BaseNavActivity implements View.OnClickListener {

    @Override
    protected boolean useDataBinding() {
        return false;
    }

    @Override
    protected BaseViewModel bind() {
        return null;
    }

    @Override
    protected void onViewCreated(Bundle savedInstanceState) {

    }

    @Override
    public void onLeftTitleClick() {
        finish();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_apply;
    }

    @OnClick({R.id.tv_next})
    @Override
    public void onClick(View v) {
        startActivity(new Intent(this, ApplyCredentialsActivity.class));
    }
}
