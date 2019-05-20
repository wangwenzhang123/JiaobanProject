package com.tongdada.library_main.home.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.tongdada.library_main.home.respose.TransportCarBean;
import com.tongdada.library_main.order.respose.OrderBean;

import java.util.List;

/**
 * @name JiaobanProject
 * @class describe
 * @anthor 王文章
 * @time 2019/5/17 11:13
 * @change
 */
public class TransportCarrAdapter extends BaseQuickAdapter<TransportCarBean, BaseViewHolder> {
    public TransportCarrAdapter(int layoutResId, @Nullable List<TransportCarBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, TransportCarBean item) {

    }
}
