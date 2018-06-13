package com.morly.driver.home.service;

import android.content.Context;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;

import com.common.library.viewModel.BaseViewModel;
import com.morly.driver.R;
import com.morly.driver.util.TimeUtils;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by riven_chris on 2017/3/26.
 */

public class ServiceViewModel extends BaseViewModel {

    public final ObservableField<String> title = new ObservableField<>();
    public final ObservableField<String> time = new ObservableField<>();
    public final ObservableField<String> date = new ObservableField<>();
    public final ObservableBoolean loading = new ObservableBoolean();
    public final ObservableField<String> work = new ObservableField<>();
    private boolean isWorking = false;

    public ServiceViewModel(Context context) {
        super(context);
    }

    public void start() {
        title.set(context.getString(R.string.title_service));
        work.set(context.getString(R.string.text_work));
        timeTicked();
        dataChanged();
    }

    public void timeTicked() {
        long currentMills = System.currentTimeMillis();
        time.set(TimeUtils.millsToTime(currentMills, TimeUtils.YMD_HMS_PATTERN3));
    }

    public void dataChanged() {
        long currentMills = System.currentTimeMillis();
        String week = TimeUtils.getWeekDate(new Date(currentMills));
        String d = TimeUtils.millisecondToDate(currentMills, TimeUtils.YMD_PATTERN);
        date.set(week + " " + d);
    }

    public void loadData(boolean showLoading) {
        loading.set(true);
        Observable.timer(3, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(@NonNull Long aLong) throws Exception {
                        loading.set(false);
                    }
                });
    }

    public void onRefresh() {
        loadData(true);
    }

    public void onWorkClick() {
        isWorking = !isWorking;
        work.set(isWorking ? context.getString(R.string.text_work_off) : context.getString(R.string.text_work));
    }

    public void stop() {

    }

}
