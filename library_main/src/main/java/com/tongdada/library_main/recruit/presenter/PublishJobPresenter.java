package com.tongdada.library_main.recruit.presenter;

import com.example.library_commen.model.PagenationBase;
import com.example.library_commen.model.PublishJobRequestBean;
import com.example.library_commen.utils.UserMapUtils;
import com.tongdada.base.ui.mvp.base.presenter.BasePresenter;
import com.tongdada.library_main.home.net.CarOrderBean;
import com.tongdada.library_main.net.MainApiUtils;

import io.reactivex.functions.Consumer;

public class PublishJobPresenter extends BasePresenter<PublishJobContract.View> implements PublishJobContract.Presenter {

    @Override
    public void publishJob(PublishJobRequestBean publishJobRequestBean) {
        MainApiUtils.getMainApi().publishPosition(UserMapUtils.getPublishJobMap(publishJobRequestBean))
                .compose(this.<PagenationBase<CarOrderBean>>handleEverythingResult())
                .subscribe(new Consumer<PagenationBase<CarOrderBean>>() {
                    @Override
                    public void accept(PagenationBase<CarOrderBean> carOrderBeanPagenationBase) throws Exception {

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }
}
