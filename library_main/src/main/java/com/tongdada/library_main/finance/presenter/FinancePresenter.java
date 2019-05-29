package com.tongdada.library_main.finance.presenter;

import com.example.library_commen.model.CommenUtils;
import com.tongdada.base.net.client.KRetrofitFactory;
import com.tongdada.base.ui.mvp.base.presenter.BasePresenter;
import com.tongdada.library_main.finance.net.FinanceApi;
import com.tongdada.library_main.home.net.CarOrderBean;
import com.tongdada.library_main.net.MainApiUtils;
import com.tongdada.library_main.net.PagenationBase;

import io.reactivex.functions.Consumer;

/**
 * Created by wangshen on 2019/5/14.
 */

public class FinancePresenter extends BasePresenter<FinanceContract.View> implements FinanceContract.Presenter {
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void detailOrderList() {
        MainApiUtils.getMainApi().detailOrderList(CommenUtils.getIncetance().getUserBean().getStationId(),type)
                .compose(this.<PagenationBase<CarOrderBean>>handleEverythingResult())
                .subscribe(new Consumer<PagenationBase<CarOrderBean>>() {
                    @Override
                    public void accept(PagenationBase<CarOrderBean> carOrderBeanPagenationBase) throws Exception {
                        if (carOrderBeanPagenationBase.getPagenation() != null && carOrderBeanPagenationBase.getPagenation().getList() != null){
                            getView().setOrderList(carOrderBeanPagenationBase.getPagenation().getList());
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
