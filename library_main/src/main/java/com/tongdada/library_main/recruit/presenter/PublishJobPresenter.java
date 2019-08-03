package com.tongdada.library_main.recruit.presenter;

import com.example.library_commen.event.EventJobBean;
import com.example.library_commen.model.PagenationBase;
import com.example.library_commen.utils.UserMapUtils;
import com.tongdada.base.ui.mvp.base.presenter.BasePresenter;
import com.tongdada.library_main.home.net.CarOrderBean;
import com.tongdada.library_main.net.MainApiUtils;
import com.tongdada.library_main.recruit.respose.RecruitmentBean;
import com.example.library_commen.model.RecuritListBean;

import org.greenrobot.eventbus.EventBus;

import io.reactivex.functions.Consumer;

public class PublishJobPresenter extends BasePresenter<PublishJobContract.View> implements PublishJobContract.Presenter {

    @Override
    public void publishJob(RecuritListBean publishJobRequestBean) {
        MainApiUtils.getMainApi().publishPosition(UserMapUtils.getPublishJobMap(publishJobRequestBean))
                .compose(this.<PagenationBase<CarOrderBean>>handleEverythingResult())
                .subscribe(new Consumer<PagenationBase<CarOrderBean>>() {
                    @Override
                    public void accept(PagenationBase<CarOrderBean> carOrderBeanPagenationBase) throws Exception {
                        EventBus.getDefault().post(new EventJobBean());
                        getView().finishActivity();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getView().showToast(throwable.getMessage());
                    }
                });
    }

    @Override
    public void cancelJob(String id) {
        MainApiUtils.getMainApi().cancelPosition(id)
                .compose(this.<PagenationBase<RecruitmentBean>>handleEverythingResult())
                .subscribe(new Consumer<PagenationBase<RecruitmentBean>>() {
                    @Override
                    public void accept(PagenationBase<RecruitmentBean> recruitmentBeanPagenationBase) throws Exception {
                        EventBus.getDefault().post(new EventJobBean());
                        getView().finishActivity();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getView().showToast(throwable.getMessage());
                    }
                });
    }
}
