package com.tongdada.library_main.user.adapter;

import android.support.annotation.Nullable;
import android.util.Log;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.tongdada.library_main.user.respose.InformationBean;
import com.tongdada.library_main.user.respose.MessageBean;

import java.util.List;

/**
 * @name JiaobanProject
 * @class describe
 * @anthor 王文章
 * @time 2019/5/20 17:56
 * @change
 */
public class MessageAdapter extends BaseQuickAdapter<MessageBean,BaseViewHolder> {
    public MessageAdapter(int layoutResId, @Nullable List<MessageBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MessageBean item) {
        Log.e("12321",item.getClass()+"");
    }
}
