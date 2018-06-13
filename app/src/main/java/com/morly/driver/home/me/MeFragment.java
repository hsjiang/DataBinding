package com.morly.driver.home.me;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.morly.driver.R;
import com.morly.driver.base.BaseFragment;
import com.morly.driver.databinding.FragmentHomeMeBinding;

/**
 * Created by riven_chris on 2017/4/1.
 */

public class MeFragment extends BaseFragment<MeViewModel, FragmentHomeMeBinding> {

    public static MeFragment newInstance(Bundle bundle) {
        MeFragment fragment = new MeFragment();
        return fragment;
    }

    @Override
    protected void onViewCreatedFinish(View view, @Nullable Bundle savedInstanceState) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_me;
    }

    @Override
    protected MeViewModel bind() {
        MeViewModel meViewModel = new MeViewModel(getActivity());
        mDataBinding.setViewModel(meViewModel);
        return meViewModel;
    }
}
