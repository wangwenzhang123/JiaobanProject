package com.tongdada.library_main.user.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.tongdada.library_main.user.respose.UserManagerBean;

import java.util.List;

/**
 * @name JiaobanProject
 * @class describe
 * @anthor 王文章
 * @time 2019/5/20 17:56
 * @change
 */
public class UserManagerAdapter extends BaseQuickAdapter<UserManagerBean,BaseViewHolder> {
    public UserManagerAdapter(int layoutResId, @Nullable List<UserManagerBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, UserManagerBean item) {

    }
}
