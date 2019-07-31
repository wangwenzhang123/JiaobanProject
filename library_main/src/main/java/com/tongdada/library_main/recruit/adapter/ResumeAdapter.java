package com.tongdada.library_main.recruit.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseViewHolder;
import com.tongdada.base.ui.mvp.base.adapter.BaseAdapter;
import com.tongdada.library_main.recruit.respose.RecruitmentBean;
import com.tongdada.library_main.recruit.respose.ResumeBean;

import java.util.List;

public class ResumeAdapter extends BaseAdapter<ResumeBean> {
    public ResumeAdapter(int layoutResId, @Nullable List<ResumeBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ResumeBean item) {
        super.convert(helper, item);
    }
}
