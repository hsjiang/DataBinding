package com.morly.driver.home.local;

import android.content.Context;
import android.databinding.ObservableField;

import com.common.library.viewModel.BaseViewModel;
import com.morly.driver.R;

/**
 * Created by riven_chris on 2017/4/4.
 */

public class LocalViewModel extends BaseViewModel {

    public ObservableField<String> title = new ObservableField<>();

    public LocalViewModel(Context context) {
        super(context);
    }

    public void start() {
        title.set(context.getString(R.string.title_local));
    }
}
