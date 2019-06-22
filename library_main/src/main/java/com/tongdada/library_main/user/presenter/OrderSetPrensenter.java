package com.tongdada.library_main.user.presenter;

import com.example.library_commen.model.CommenUtils;
import com.example.library_commen.model.RequestRegisterBean;
import com.tongdada.base.net.bean.BaseAppEntity;
import com.tongdada.base.ui.mvp.base.presenter.BasePresenter;
import com.tongdada.library_main.net.MainApiUtils;

import io.reactivex.functions.Consumer;

/**
 * Created by wangshen on 2019/5/24.
 */

public class OrderSetPrensenter extends BasePresenter<OrderSetContract.View> implements OrderSetContract.Presenter{

    @Override
    public void sysSet(final String tong, String beng1, String beng2, String beng3, String beng4, String beng5) {
        MainApiUtils.getMainApi().sysSet(CommenUtils.getIncetance().getUserBean().getStationId(),tong,beng1,beng2,beng3,beng4,beng5)
                .compose(this.<BaseAppEntity<RequestRegisterBean>>handleEverythingResult())
                .subscribe(new Consumer<BaseAppEntity<RequestRegisterBean>>() {
                    @Override
                    public void accept(BaseAppEntity<RequestRegisterBean> objectBaseAppEntity) throws Exception {
                       CommenUtils.getIncetance().setRequestRegisterBean(objectBaseAppEntity.getContent());
                       getView().sysSetSuccess();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getView().showToast(throwable.getMessage());
                    }
                });
    }
}
