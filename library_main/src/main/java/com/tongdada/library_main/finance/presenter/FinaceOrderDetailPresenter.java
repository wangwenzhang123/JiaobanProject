package com.tongdada.library_main.finance.presenter;

import com.example.library_commen.model.UserBean;
import com.example.library_commen.net.CommenApi;
import com.tongdada.base.net.bean.BaseAppEntity;
import com.tongdada.base.net.client.KRetrofitFactory;
import com.tongdada.base.ui.mvp.base.presenter.BasePresenter;
import com.tongdada.library_main.net.MainApiUtils;

import io.reactivex.functions.Consumer;

/**
 * @name JiaobanProject
 * @class describe
 * @anthor 王文章
 * @time 2019/5/29 14:25
 * @change
 */
public class FinaceOrderDetailPresenter extends BasePresenter<FinaceOrderDetailContract.View> implements FinaceOrderDetailContract.Presenter {
    private CommenApi commenApi;

    public FinaceOrderDetailPresenter() {
        KRetrofitFactory.createService(CommenApi.class);
    }

    @Override
    public void getOrderDetail(String id) {
        commenApi.getDetailOrderById(id)
                .compose(this.<BaseAppEntity<UserBean>>handleEverythingResult())
                .subscribe(new Consumer<BaseAppEntity<UserBean>>() {
                    @Override
                    public void accept(BaseAppEntity<UserBean> userBeanBaseAppEntity) throws Exception {

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getView().showToast(throwable.getMessage());
                    }
                });
    }
}
