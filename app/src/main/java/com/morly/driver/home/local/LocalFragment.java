package com.morly.driver.home.local;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.morly.driver.R;
import com.morly.driver.base.BaseFragment;
import com.morly.driver.databinding.FragmentHomeLocalBinding;

/**
 * Created by riven_chris on 2017/4/1.
 */

public class LocalFragment extends BaseFragment<LocalViewModel, FragmentHomeLocalBinding> {

    public static LocalFragment newInstance(Bundle bundle) {
        LocalFragment fragment = new LocalFragment();
        return fragment;
    }

    @Override
    protected void onViewCreatedFinish(View view, @Nullable Bundle savedInstanceState) {
        mViewModel.start();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_local;
    }

    @Override
    protected LocalViewModel bind() {
        LocalViewModel localViewModel = new LocalViewModel(getActivity());
        mDataBinding.setViewModel(localViewModel);
        return localViewModel;
    }
}
