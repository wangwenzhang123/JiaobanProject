package com.tongdada.library_main.recruit.presenter;

import com.tongdada.base.ui.mvp.base.refresh.BaseRecyclerRefreshPresenter;
import com.tongdada.base.ui.mvp.base.refresh.RequestCallback;
import com.tongdada.library_main.recruit.respose.RecruitmentBean;

public class ResumeCenterPresenter extends BaseRecyclerRefreshPresenter<ResumeCenterContract.View, RecruitmentBean> implements ResumeCenterContract.Presenter {

    @Override
    public void onRefresh(RequestCallback<RecruitmentBean> callback) {

    }

    @Override
    public void onLoadMore(RequestCallback<RecruitmentBean> callback) {

    }
}
