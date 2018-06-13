package com.morly.driver.user;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.morly.driver.R;
import com.morly.driver.base.BaseSimpleActivity;
import com.morly.driver.home.HomeActivity;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by riven_chris on 2017/3/29.
 */

public class SignInActivity extends BaseSimpleActivity implements View.OnClickListener {

    @BindView(R.id.et_number)
    EditText etNumber;
    @BindView(R.id.et_code)
    EditText etCode;
    @BindView(R.id.tv_get_code)
    TextView tvGetCode;

    private Disposable timerDisposable;
    private final int countDownSeconds = 60;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_sign_in;
    }

    @Override
    protected void onViewCreated(Bundle savedInstanceState) {

    }

    @OnClick({R.id.tv_get_code, R.id.tv_login})
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_get_code:
                getCode();
                break;
            case R.id.tv_login:
                login();
                break;
        }
    }

    private void getCode() {
        String phoneNumber = etNumber.getText().toString();
        if (phoneNumber.length() < 11) {
            Toast.makeText(this, "请输入正确手机号", Toast.LENGTH_SHORT).show();
            return;
        }
        tvGetCode.setClickable(false);
        timerDisposable = Observable.interval(1, TimeUnit.SECONDS)
                .scan(new BiFunction<Long, Long, Long>() {
                    @Override
                    public Long apply(@NonNull Long aLong, @NonNull Long aLong2) throws Exception {
                        return aLong2;
                    }
                }).subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(@NonNull Long time) throws Exception {
                        if (time >= countDownSeconds) {
                            timerDisposable.dispose();
                            tvGetCode.setClickable(true);
                            tvGetCode.setText(SignInActivity.this.getString(R.string.text_get_coe));
                        } else {
                            tvGetCode.setText((countDownSeconds - time) + "s");
                        }
                    }
                });
    }

    private void login() {
        String phoneNumber = etNumber.getText().toString();
        if (phoneNumber.length() < 11) {
            Toast.makeText(this, "请输入正确手机号", Toast.LENGTH_SHORT).show();
            return;
        }

        String code = etCode.getText().toString();
        if (TextUtils.isEmpty(code)) {
            Toast.makeText(this, "请输入正确验证码", Toast.LENGTH_SHORT).show();
            return;
        }

        startActivity(new Intent(this, HomeActivity.class));
        finish();
    }
}
