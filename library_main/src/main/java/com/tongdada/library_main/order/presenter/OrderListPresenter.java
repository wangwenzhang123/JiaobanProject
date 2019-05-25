package com.tongdada.library_main.order.presenter;

import com.example.library_commen.model.CommenUtils;
import com.tongdada.base.net.bean.BaseAppEntity;
import com.tongdada.base.ui.mvp.base.presenter.BasePresenter;
import com.tongdada.library_main.net.MainApiUtils;
import com.tongdada.library_main.net.PagenationBase;
import com.tongdada.library_main.order.respose.OrderListBean;

import io.reactivex.functions.Consumer;

/**
 * @name JiaobanProject
 * @class describe
 * @anthor 王文章
 * @time 2019/5/17 16:59
 * @change
 */
public class OrderListPresenter extends BasePresenter<OrderListContract.View> implements OrderListContract.Presenter{

    @Override
    public void getOrderList(final String type) {
        MainApiUtils.getMainApi().orderList(CommenUtils.getIncetance().getUserBean().getStationId(),"1","",type)
                .compose(this.<PagenationBase<OrderListBean>>handleEverythingResult())
                .subscribe(new Consumer<PagenationBase<OrderListBean>>() {
                    @Override
                    public void accept(PagenationBase<OrderListBean> objectBaseAppEntity) throws Exception {
                        if (objectBaseAppEntity != null && objectBaseAppEntity.getPagenation() != null){
                            getView().setData(objectBaseAppEntity.getPagenation().getList(),type);
                        }

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getView().showToast(throwable.getMessage());
                    }
                });
    }
}
