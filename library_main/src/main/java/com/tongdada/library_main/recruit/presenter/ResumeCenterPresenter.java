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

public class ResumeCenterPresenter extends BasePresenter<ResumeCenterContract.View> implements ResumeCenterContract.Presenter {

   /* @Override
    public void onRefresh(RequestCallback<RecruitmentBean> callback) {
        MainApiUtils.getMainApi().listApply("","", CommenUtils.getIncetance().getRequestRegisterBean().getId())
                .compose(this.<PagenationBase<CarOrderBean>>handleEverythingResult())
                .subscribe(new Consumer<PagenationBase<CarOrderBean>>() {
                    @Override
                    public void accept(final PagenationBase<CarOrderBean> carOrderBeanPagenationBase) throws Exception {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                //callback.onSuccess(carOrderBeanPagenationBase);
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

    @Override
    public void onLoadMore(RequestCallback<RecruitmentBean> callback) {

    }*/
}
