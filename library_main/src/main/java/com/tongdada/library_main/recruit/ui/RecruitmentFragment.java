package com.tongdada.library_main.recruit.ui;

import com.tongdada.base.ui.mvp.base.adapter.BaseAdapter;
import com.tongdada.base.ui.mvp.base.refresh.BaseRecyclerRefreshFragment;
import com.tongdada.library_main.recruit.presenter.RecruitmentContract;
import com.tongdada.library_main.recruit.presenter.RecruitmentPresenter;
import com.tongdada.library_main.recruit.respose.RecruitmentBean;

public class RecruitmentFragment extends BaseRecyclerRefreshFragment<RecruitmentContract.View,RecruitmentPresenter, RecruitmentBean> implements RecruitmentContract.View {

    @Override
    public BaseAdapter createRecyclerAdapter() {
        return null;
    }

    @Override
    public RecruitmentPresenter getPresenter() {
        return new RecruitmentPresenter();
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
