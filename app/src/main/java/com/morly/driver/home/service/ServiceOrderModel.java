package com.morly.driver.home.service;

import android.content.Context;
import android.databinding.ObservableField;

import com.common.library.viewModel.BaseViewModel;

/**
 * Created by riven_chris on 2017/4/2.
 */

public class ServiceOrderModel extends BaseViewModel {

    public final ObservableField<String> title = new ObservableField<>();

    public ServiceOrderModel(Context context) {
        super(context);
    }

    public void setData(int position) {
        title.set("" + position);
    }

    public void onItemClick() {
        title.set(title.get() + title.get());
    }
}
