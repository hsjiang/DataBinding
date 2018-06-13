package com.morly.driver.base;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.common.library.view.BaseMVVMFragment;
import com.common.library.viewModel.BaseViewModel;

import butterknife.ButterKnife;

/**
 * Created by riven_chris on 2017/3/26.
 */

public abstract class BaseFragment<V extends BaseViewModel, D extends ViewDataBinding> extends BaseMVVMFragment<V, D> {
    protected Context context;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        context = getActivity();
        onViewCreatedFinish(view, savedInstanceState);
    }

    protected abstract void onViewCreatedFinish(View view, @Nullable Bundle savedInstanceState);
}
