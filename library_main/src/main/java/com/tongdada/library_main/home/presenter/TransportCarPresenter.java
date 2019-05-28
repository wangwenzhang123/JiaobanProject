package com.tongdada.library_main.home.presenter;

import android.os.Handler;

import com.example.library_commen.model.CommenUtils;
import com.example.library_commen.model.OrderBean;
import com.tongdada.base.net.bean.BaseAppEntity;
import com.tongdada.base.ui.mvp.base.presenter.BasePresenter;
import com.tongdada.base.ui.mvp.base.refresh.BaseRecyclerRefreshPresenter;
import com.tongdada.base.ui.mvp.base.refresh.RequestCallback;
import com.tongdada.library_main.home.net.CarOrderBean;
import com.tongdada.library_main.home.respose.TransportCarBean;
import com.tongdada.library_main.net.MainApiUtils;
import com.tongdada.library_main.net.PagenationBase;
import com.tongdada.library_main.order.presenter.OrderListContract;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Consumer;

/**
 * @name JiaobanProject
 * @class describe
 * @anthor 王文章
 * @time 2019/5/20 11:35
 * @change
 */
public class TransportCarPresenter extends BaseRecyclerRefreshPresenter<TransportCarContract.View,TransportCarBean> implements TransportCarContract.Presenter {
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean isEnableLoadMore() {
        return false;
    }

    @Override
    public boolean isEnableRefresh() {
        return true;
    }

    @Override
    public void onRefresh(final RequestCallback<TransportCarBean> callback) {
        MainApiUtils.getMainApi().detailOrderList(CommenUtils.getIncetance().getUserBean().getStationId(),type)
                .compose(this.<PagenationBase<CarOrderBean>>handleEverythingResult())
                .subscribe(new Consumer<PagenationBase<CarOrderBean>>() {
                    @Override
                    public void accept(final PagenationBase<CarOrderBean> objectBaseAppEntity) throws Exception {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                List<TransportCarBean> list=new ArrayList<>();
                                if (objectBaseAppEntity.getPagenation().getList() != null){
                                    for (int i = 0; i < objectBaseAppEntity.getPagenation().getList().size(); i++) {
                                        TransportCarBean transportCarBean=objectBaseAppEntity.getPagenation().getList().get(i);
                                        if (type.equals(transportCarBean.getOrderStatus())){
                                            list.add(transportCarBean);
                                        }
                                    }
                                }
                                callback.onSuccess(list);
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
    public void onLoadMore(final RequestCallback<TransportCarBean> callback) {
        MainApiUtils.getMainApi().detailOrderList(CommenUtils.getIncetance().getUserBean().getStationId(),type)
                .compose(this.<PagenationBase<CarOrderBean>>handleEverythingResult())
                .subscribe(new Consumer<PagenationBase<CarOrderBean>>() {
                    @Override
                    public void accept(final PagenationBase<CarOrderBean> objectBaseAppEntity) throws Exception {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                List<TransportCarBean> list=new ArrayList<>();
                                if (objectBaseAppEntity.getPagenation().getList() != null){
                                    for (int i = 0; i < objectBaseAppEntity.getPagenation().getList().size(); i++) {
                                        TransportCarBean transportCarBean=objectBaseAppEntity.getPagenation().getList().get(i);
                                        if (type.equals(transportCarBean.getOrderStatus())){
                                            list.add(transportCarBean);
                                        }
                                    }
                                }
                                callback.onSuccess(list);
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
