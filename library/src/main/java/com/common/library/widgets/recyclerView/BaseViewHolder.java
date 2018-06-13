package com.common.library.widgets.recyclerView;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by riven_chris on 2017/4/2.
 */

public class BaseViewHolder<D extends ViewDataBinding> extends RecyclerView.ViewHolder {

    private D dataBinding;

    public D getDataBinding() {
        return dataBinding;
    }

    public void setDataBinding(D dataBinding) {
        this.dataBinding = dataBinding;
    }

    public BaseViewHolder(View itemView) {
        super(itemView);
    }
}
