package com.tongdada.library_main.order.presenter;

import com.tongdada.base.ui.mvp.base.presenter.BasePresenter;
import com.tongdada.library_main.home.net.CarOrderBean;
import com.tongdada.library_main.net.MainApiUtils;
import com.tongdada.library_main.net.PagenationBase;

import io.reactivex.functions.Consumer;

/**
 * @name JiaobanProject
 * @class describe
 * @anthor 王文章
 * @time 2019/5/29 17:30
 * @change
 */
public class AcceptOrderDetailPresenter extends BasePresenter<AcceptOrderDetailContract.View> implements AcceptOrderDetailContract.Presenter {

    @Override
    public void detailOrderList(String id) {
        MainApiUtils.getMainApi().detailOrderList(id,null)
                .compose(this.<PagenationBase<CarOrderBean>>handleEverythingResult())
                .subscribe(new Consumer<PagenationBase<CarOrderBean>>() {
                    @Override
                    public void accept(PagenationBase<CarOrderBean> carOrderBeanPagenationBase) throws Exception {
                        getView().setOrderList(carOrderBeanPagenationBase.getPagenation().getList());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getView().showToast(throwable.getMessage());
                    }
                });
    }
}
