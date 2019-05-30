package com.example.library_commen.presenter;

import com.example.library_commen.model.OrderBean;
import com.example.library_commen.net.CommenApi;
import com.tongdada.base.net.bean.BaseAppEntity;
import com.tongdada.base.net.client.KRetrofitFactory;
import com.tongdada.base.ui.mvp.base.presenter.BasePresenter;

import io.reactivex.functions.Consumer;

/**
 * Created by wangshen on 2019/5/30.
 */

public class OrderPresenter extends BasePresenter<OrderDetailContract.View> implements OrderDetailContract.Presenter {
    private CommenApi commenApi;

    public OrderPresenter() {
        commenApi= KRetrofitFactory.createService(CommenApi.class);
    }

    @Override
    public void getOrderById(String id) {
        commenApi.getOrderById(id)
                .compose(this.<BaseAppEntity<OrderBean>>handleEverythingResult())
                .subscribe(new Consumer<BaseAppEntity<OrderBean>>() {
                    @Override
                    public void accept(BaseAppEntity<OrderBean> orderBeanBaseAppEntity) throws Exception {
                        getView().setOrderDetail(orderBeanBaseAppEntity.getContent());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getView().showToast(throwable.getMessage());
                    }
                });
    }
}
