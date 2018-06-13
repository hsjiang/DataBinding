package com.morly.driver.home.benefit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.morly.driver.R;
import com.morly.driver.base.BaseFragment;
import com.morly.driver.databinding.FragmentHomeBenefitBinding;

/**
 * Created by riven_chris on 2017/4/1.
 */

public class BenefitFragment extends BaseFragment<BenefitViewModel, FragmentHomeBenefitBinding> {

    public static BenefitFragment newInstance(Bundle bundle) {
        return new BenefitFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_benefit;
    }

    @Override
    protected BenefitViewModel bind() {
        BenefitViewModel viewModel = new BenefitViewModel(getActivity());
        mDataBinding.setViewModel(viewModel);
        return viewModel;
    }

    @Override
    protected void onViewCreatedFinish(View view, @Nullable Bundle savedInstanceState) {

    }
}
