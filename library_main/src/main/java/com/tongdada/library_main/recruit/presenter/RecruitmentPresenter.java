package com.tongdada.library_main.recruit.presenter;

import android.os.Handler;

import com.example.library_commen.model.CommenUtils;
import com.example.library_commen.model.PagenationBase;
import com.tongdada.base.ui.mvp.base.presenter.BasePresenter;
import com.tongdada.base.ui.mvp.base.refresh.BaseRecyclerRefreshPresenter;
import com.tongdada.base.ui.mvp.base.refresh.RequestCallback;
import com.tongdada.library_main.home.net.CarOrderBean;
import com.tongdada.library_main.net.MainApiUtils;
import com.tongdada.library_main.recruit.respose.RecruitmentBean;

import io.reactivex.functions.Consumer;

public class RecruitmentPresenter extends BasePresenter<RecruitmentContract.View> implements RecruitmentContract.Presenter {
    @Override
    public void getData() {
        MainApiUtils.getMainApi().listPosition("","", CommenUtils.getIncetance().getRequestRegisterBean().getId())
                .compose(this.<PagenationBase<RecruitmentBean>>handleEverythingResult())
                .subscribe(new Consumer<PagenationBase<RecruitmentBean>>() {
                    @Override
                    public void accept(final PagenationBase<RecruitmentBean> carOrderBeanPagenationBase) throws Exception {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                getView().getAdapter().setNewData(carOrderBeanPagenationBase.getPagenation().getList());
                                getView().getRefrshView().finishRefresh();
                            }
                        },2000);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getView().showToast(throwable.getMessage());
                    }
                });
    }

}
