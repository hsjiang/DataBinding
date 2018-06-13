package com.morly.driver;

import com.common.library.BasicApplication;

import butterknife.ButterKnife;

/**
 * Created by riven_chris on 2017/3/25.
 */

public class MyApplication extends BasicApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        ButterKnife.setDebug(false);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
