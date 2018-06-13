package com.common.library.viewModel;

import android.content.Context;
import android.databinding.BaseObservable;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by riven_chris on 2017/3/26.
 */

public class BaseViewModel extends BaseObservable {
    protected Context context;
    protected CompositeDisposable disposables;

    public BaseViewModel(Context context) {
        this.context = context.getApplicationContext();
    }
}
