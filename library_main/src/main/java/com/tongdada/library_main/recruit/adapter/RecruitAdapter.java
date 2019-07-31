package com.tongdada.library_main.recruit.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseViewHolder;
import com.tongdada.base.ui.mvp.base.adapter.BaseAdapter;
import com.tongdada.library_main.recruit.respose.RecruitmentBean;

import java.util.List;

public class RecruitAdapter extends BaseAdapter<RecruitmentBean> {
    public RecruitAdapter(int layoutResId, @Nullable List<RecruitmentBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, RecruitmentBean item) {
        super.convert(helper, item);
    }
}
