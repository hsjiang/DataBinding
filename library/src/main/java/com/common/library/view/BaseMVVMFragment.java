package com.common.library.view;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.common.library.viewModel.BaseViewModel;

/**
 * Created by riven_chris on 2017/3/25.
 */

public abstract class BaseMVVMFragment<V extends BaseViewModel, D extends ViewDataBinding> extends Fragment {

    protected V mViewModel;
    protected D mDataBinding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public final View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mDataBinding == null)
            mDataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        mViewModel = bind();
        return mDataBinding.getRoot();
    }

    protected abstract int getLayoutId();

    protected abstract V bind();
}
