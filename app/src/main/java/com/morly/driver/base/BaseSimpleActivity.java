package com.morly.driver.base;

import com.common.library.viewModel.BaseViewModel;

/**
 * Created by riven_chris on 2017/3/28.
 */

public abstract class BaseSimpleActivity extends BaseActivity {

    @Override
    protected final BaseViewModel bind() {
        return null;
    }

    @Override
    protected final boolean useDataBinding() {
        return false;
    }
}
