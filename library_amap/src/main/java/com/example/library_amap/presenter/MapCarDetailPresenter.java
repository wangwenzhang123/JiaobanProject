package com.example.library_amap.presenter;

import com.example.library_commen.model.TransportCarBean;
import com.example.library_commen.model.UserBean;
import com.example.library_commen.net.CommenApi;
import com.tongdada.base.net.bean.BaseAppEntity;
import com.tongdada.base.net.client.KRetrofitFactory;
import com.tongdada.base.ui.mvp.base.presenter.BasePresenter;

import io.reactivex.functions.Consumer;

/**
 * @name JiaobanProject
 * @class describe
 * @anthor 王文章
 * @time 2019/5/29 10:57
 * @change
 */
public class MapCarDetailPresenter extends BasePresenter<MapCarDetailContract.View> implements MapCarDetailContract.Presenter {
    private CommenApi commenApi;

    public MapCarDetailPresenter() {
        commenApi= KRetrofitFactory.createService(CommenApi.class);
    }

    @Override
    public void getDetailOrderById(String orderid) {
        commenApi.getDetailOrderById(orderid)
                .compose(this.<BaseAppEntity<TransportCarBean>>handleEverythingResult())
                .subscribe(new Consumer<BaseAppEntity<TransportCarBean>>() {
                    @Override
                    public void accept(BaseAppEntity<TransportCarBean> userBeanBaseAppEntity) throws Exception {

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getView().showToast(throwable.getMessage());
                    }
                });
    }
}
