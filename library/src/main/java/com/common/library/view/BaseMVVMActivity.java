package com.common.library.view;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.common.library.util.ActivityManager;
import com.common.library.viewModel.BaseViewModel;

/**
 * Created by riven_chris on 2017/3/25.
 */

public abstract class BaseMVVMActivity<V extends BaseViewModel, D extends ViewDataBinding> extends AppCompatActivity {

    protected V mViewModel;
    protected D mDataBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        int layoutId = getLayoutId();
        if (useDataBinding()) {
            mDataBinding = DataBindingUtil.setContentView(this, layoutId);
            mViewModel = bind();
        } else {
            setContentView(layoutId);
        }
    }

    protected abstract V bind();

    protected abstract int getLayoutId();

    protected boolean useDataBinding() {
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
