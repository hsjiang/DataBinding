package com.common.library;

import android.support.multidex.MultiDexApplication;

import com.common.library.util.http.OkHttpManager;
import com.common.library.widgets.fresco.ImagePipelineFactory;
import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by riven_chris on 2017/3/25.
 */

public class BasicApplication extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        OkHttpManager.init();
        Fresco.initialize(this, ImagePipelineFactory.imagePipelineConfig(getApplicationContext()
                , OkHttpManager.okHttpClient()));
    }
}
