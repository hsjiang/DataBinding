package com.morly.driver.user;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.morly.driver.R;
import com.morly.driver.apply.ApplyActivity;
import com.morly.driver.base.BaseSimpleActivity;

import butterknife.OnClick;

/**
 * Created by riven_chris on 2017/3/28.
 */

public class SignInGuideActivity extends BaseSimpleActivity implements View.OnClickListener {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_sign_in_guide;
    }

    @Override
    protected void onViewCreated(Bundle savedInstanceState) {

    }

    @OnClick({R.id.tv_login, R.id.tv_apply})
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_login:
                startActivity(new Intent(this, SignInActivity.class));
                break;
            case R.id.tv_apply:
                startActivity(new Intent(this, ApplyActivity.class));
                break;
        }
    }
}
