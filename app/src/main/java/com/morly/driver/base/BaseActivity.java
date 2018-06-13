package com.morly.driver.base;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.common.library.view.BaseMVVMActivity;
import com.common.library.viewModel.BaseViewModel;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by riven_chris on 2017/3/31.
 */

public abstract class BaseActivity<V extends BaseViewModel, D extends ViewDataBinding> extends BaseMVVMActivity<V, D> {
    private Unbinder unbinder;

    @Override
    protected final void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        unbinder = ButterKnife.bind(this);
        onViewCreated(savedInstanceState);
    }

    protected abstract void onViewCreated(Bundle savedInstanceState);

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
