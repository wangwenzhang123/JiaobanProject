package com.tongdada.library_main.recruit.ui;

import com.tongdada.base.ui.mvp.base.adapter.BaseAdapter;
import com.tongdada.base.ui.mvp.base.refresh.BaseRecyclerRefreshFragment;
import com.tongdada.library_main.recruit.presenter.ResumeCenterContract;
import com.tongdada.library_main.recruit.presenter.ResumeCenterPresenter;
import com.tongdada.library_main.recruit.respose.ResumeBean;

public class ResumeCenterFragment extends BaseRecyclerRefreshFragment<ResumeCenterContract.View, ResumeCenterPresenter, ResumeBean> implements ResumeCenterContract.View{
    @Override
    public BaseAdapter createRecyclerAdapter() {
        return null;
    }

    @Override
    public ResumeCenterPresenter getPresenter() {
        return new ResumeCenterPresenter();
    }

    @Override
    public void initView() {

    }

    @Override
    public void initLinsenterner() {

    }

    @Override
    public void getData() {

    }
}
