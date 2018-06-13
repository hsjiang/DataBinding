package com.morly.driver.home.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.Toast;

import com.common.library.widgets.recyclerView.BaseRecyclerView;
import com.common.library.widgets.recyclerView.ScrollChildSwipeRefreshLayout;
import com.morly.driver.R;
import com.morly.driver.base.BaseNavFragment;
import com.morly.driver.databinding.FragmentHomeServiceBinding;
import com.morly.driver.order.OrderAddressActivity;

/**
 * Created by riven_chris on 2017/3/25.
 */

public class ServiceFragment extends BaseNavFragment<ServiceViewModel, FragmentHomeServiceBinding> {

    public static ServiceFragment newInstance(Bundle bundle) {
        return new ServiceFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_service;
    }

    @Override
    protected ServiceViewModel bind() {
        ServiceViewModel viewModel = new ServiceViewModel(getActivity());
        mDataBinding.setViewModel(viewModel);
        return viewModel;
    }

    @Override
    protected void onViewCreatedFinish(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreatedFinish(view, savedInstanceState);
        registerReceiver();
        mViewModel.start();
        setUpRecyclerView();
    }

    private void setUpRecyclerView() {
        final ScrollChildSwipeRefreshLayout refreshLayout = mDataBinding.srRefresh;
        refreshLayout.setSize(SwipeRefreshLayout.DEFAULT);
//        srRefresh.setPadding(20, 20, 20, 20);
//        srRefresh.setProgressViewOffset(true, 50, 100);
//        srRefresh.setDistanceToTriggerSync(50);
//        srRefresh.setProgressViewEndTarget(true, 50);
        refreshLayout.setColorSchemeColors(
                ContextCompat.getColor(getActivity(), R.color.colorPrimary),
                ContextCompat.getColor(getActivity(), R.color.colorAccent),
                ContextCompat.getColor(getActivity(), R.color.colorPrimaryDark)
        );
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
//                refreshLayout.setRefreshing(true);

            }
        });
        // Set the scrolling view in the custom SwipeRefreshLayout.
        refreshLayout.setScrollUpChild(mDataBinding.recyclerView);

        BaseRecyclerView recyclerView = mDataBinding.recyclerView;
        recyclerView.setAdapter(new ServiceOrderAdapter(getActivity(), null));
    }

    private void registerReceiver() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_TIME_TICK);
        filter.addAction(Intent.ACTION_DATE_CHANGED);
        filter.addAction(Intent.ACTION_TIME_CHANGED);
        getActivity().registerReceiver(timeReceiver, filter);
    }

    @Override
    public void onRightTitleClick() {
        startActivity(new Intent(getActivity(), OrderAddressActivity.class));
    }

    private BroadcastReceiver timeReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            switch (action) {
                case Intent.ACTION_DATE_CHANGED:
                    Toast.makeText(getActivity(), "dateChanged", Toast.LENGTH_SHORT).show();
                    mViewModel.dataChanged();
                    break;
                case Intent.ACTION_TIME_TICK:
//                    Toast.makeText(getActivity(), "timeTick", Toast.LENGTH_SHORT).show();
                    mViewModel.timeTicked();
                    break;
                case Intent.ACTION_TIME_CHANGED:
                    Toast.makeText(getActivity(), "timeChanged", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        getActivity().unregisterReceiver(timeReceiver);
    }
}