package com.common.library.util.http;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by riven_chris on 2017/4/2.
 */

public class OkHttpManager {

    private static final int CONNECT_TIMEOUT_MILLIS = 10 * 1000;//连接时间超时
    private static final int WRITE_TIMEOUT_MILLIS = 10 * 1000;//写入时间超时
    private static final int READ_TIMEOUT_MILLIS = 10 * 1000;//读取时间超时

    public static OkHttpClient okHttpClient;

    public static void init() {
        okHttpClient();
    }

    public static OkHttpClient okHttpClient() {
        if (okHttpClient != null)
            return okHttpClient;

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(CONNECT_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)
                .writeTimeout(WRITE_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)
                .readTimeout(READ_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.d("OkHttp", message);
            }
        });
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(loggingInterceptor);
        Cache cache = new Cache(new File(networkCacheDirectoryPath()), networkCacheSize());
        builder.cache(cache);
        okHttpClient = builder.build();
        return okHttpClient;
    }

    private static String networkCacheDirectoryPath() {
        return Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "http_cache";
    }

    private static int networkCacheSize() {
        return 20 * 1024 * 1024;
    }
}
