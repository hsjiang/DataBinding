package com.morly.driver.home.service;

import android.content.Context;
import android.view.View;

import com.common.library.widgets.recyclerView.BaseAdapter;
import com.common.library.widgets.recyclerView.BaseViewHolder;
import com.morly.driver.R;
import com.morly.driver.data.Order;
import com.morly.driver.databinding.LayoutServiceOrderBinding;

import java.text.ParseException;
import java.util.List;

/**
 * Created by riven_chris on 2017/4/2.
 */

public class ServiceOrderAdapter extends BaseAdapter<Order, ServiceOrderAdapter.OrderViewHolder> {

    public ServiceOrderAdapter(Context context, List<Order> orders) {
        super(context, orders);
    }

    @Override
    public Order getItem(int position) {
        return null;
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    @Override
    public int getLayoutId(int viewType) {
        return R.layout.layout_service_order;
    }

    @Override
    public OrderViewHolder getViewHolder(View itemView, int viewType) {
        return new OrderViewHolder(itemView);
    }

    @Override
    public void onBindItem(OrderViewHolder holder, Order order, int position) throws ParseException {
        ServiceOrderModel viewModel = new ServiceOrderModel(context);
        holder.getDataBinding().setViewModel(viewModel);
        viewModel.setData(position);
    }

    public static class OrderViewHolder extends BaseViewHolder<LayoutServiceOrderBinding> {
        public OrderViewHolder(View itemView) {
            super(itemView);
        }
    }
}
