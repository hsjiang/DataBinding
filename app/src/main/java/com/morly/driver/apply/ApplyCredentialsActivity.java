package com.morly.driver.apply;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.common.library.util.ActivityManager;
import com.common.library.viewModel.BaseViewModel;
import com.morly.driver.R;
import com.morly.driver.base.BaseNavActivity;
import com.morly.driver.user.SignInGuideActivity;

import butterknife.OnClick;

/**
 * Created by riven_chris on 2017/4/5.
 */

public class ApplyCredentialsActivity extends BaseNavActivity implements View.OnClickListener {

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
    protected int getLayoutId() {
        return R.layout.activity_apply_credentials;
    }

    @OnClick({R.id.tv_apply, R.id.tv_date1, R.id.tv_date2})
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_apply:
                alert();
                break;
            case R.id.tv_date1:
                break;
            case R.id.tv_date2:
                break;
        }
    }

    public void alert() {
        AlertDialog dialog = new AlertDialog.Builder(this).setTitle("提交成功!")
                .setMessage("感谢您申请斑马线代驾司机，我们客服人员将在两个工作日内与您取得联系，请您耐心等待")
                .setPositiveButton("好的", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).create();
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                ActivityManager.getInstance().finishAllActivity();
                startActivity(new Intent(ApplyCredentialsActivity.this, SignInGuideActivity.class));
                finish();
            }
        });
        dialog.show();
    }
}
